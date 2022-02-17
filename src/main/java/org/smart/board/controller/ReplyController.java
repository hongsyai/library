package org.smart.board.controller;

import org.smart.board.entity.Reply;
import org.smart.board.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @PostMapping("/replyList")
    @ResponseBody
    public List<Reply> replyList(Long boardseq){
        List<Reply> replyList = replyService.list(boardseq);
        System.out.println("======= 댓글 목록 : " + replyList); // [] 이런 모양으로 나오는지 확인
        return replyList;
    }

    @PostMapping("/replyWrite")
    @ResponseBody
    public String replyWrite(Reply reply, @AuthenticationPrincipal UserDetails user){
        //아이디 꺼내오기
        String loginId = user.getUsername();
        reply.setUsrid(loginId);
        System.out.println("===============" + reply);
        int result = replyService.insert(reply);

        String message = "";
        if(result ==1) message="댓글 저장을 완료했습니다.";
        else if(result ==0) message="댓글 저장하지 못했습니다.";

        return message;
    }


    @PostMapping("/replyDelete")
    @ResponseBody
    public String replyDelete(Reply reply, @AuthenticationPrincipal UserDetails user){ //로그인한 사람의 아이디와 댓글쓴 사람의 아이디가 같을 때만 삭제 가능!
        System.out.println("=============삭제하려는 데이터:  " +reply);

        String loginId = user.getUsername();
        Reply r = replyService.findOne(reply.getReplyseq());

        String message = "";
        if(!(loginId.equals(r.getUsrid()))){
            message = "본인이 쓴 댓글만 삭제할 수 있습니다.";
        }else {
            int result = replyService.delete(reply.getReplyseq());
            if(result == 1) message="삭제되었습니다.";
        }
        return message;
    }

    //댓글 수정을 위한 1개의 데이터를 조회
    @ResponseBody
    @PostMapping("/replyFind")
    public Reply replyFind(Long replyseq, @AuthenticationPrincipal UserDetails user){
        System.out.println(replyseq);
        String loginId = user.getUsername(); //로그인 정보
        Reply reply = replyService.findOne(replyseq);

        if(loginId.equals(reply.getUsrid()))
            return reply;
        return null;
    }

    //댓글 수정
    @ResponseBody
    @PostMapping("/replyUpdate")
    public String replyUpdate(Reply reply){
        int result = replyService.update(reply);

        String message = null;
        if(result == 1){
            message="수정 완료";
        }else {
            message="수정 오류";
        }
        return message;
    }
}
