package org.smart.board.controller;

import org.smart.board.entity.BookReply;
import org.smart.board.service.BookReplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookreply")
public class BookReplyController {

    @Autowired
    BookReplyService bookreplyService;

    @PostMapping("/bookreplyList")
    @ResponseBody
    public List<BookReply> bookreplyList(Long bookseq){
        List<BookReply> bookreplyList = bookreplyService.list(bookseq);
        System.out.println("======= 댓글 목록 : " + bookreplyList); // [] 이런 모양으로 나오는지 확인
        return bookreplyList;
    }

    @PostMapping("/bookreplyWrite")
    @ResponseBody
    public String bookreplyWrite(BookReply bookreply, @AuthenticationPrincipal UserDetails user){
        //아이디 꺼내오기
        String loginId = user.getUsername();
        bookreply.setUsrid(loginId);
        System.out.println("===============" + bookreply);
        int result = bookreplyService.insert(bookreply);

        String message = "";
        if(result ==1) message="댓글 저장을 완료했습니다.";
        else if(result ==0) message="댓글 저장하지 못했습니다.";

        return message;
    }


    @PostMapping("/bookreplyDelete")
    @ResponseBody
    public String bookreplyDelete(BookReply bookreply, @AuthenticationPrincipal UserDetails user){ //로그인한 사람의 아이디와 댓글쓴 사람의 아이디가 같을 때만 삭제 가능!
        System.out.println("=============삭제하려는 데이터:  " +bookreply);

        String loginId = user.getUsername();
        BookReply r = bookreplyService.findOne(bookreply.getBookreplyseq());

        String message = "";
        if(!(loginId.equals(r.getUsrid()))){
            message = "본인이 쓴 댓글만 삭제할 수 있습니다.";
        }else {
            int result = bookreplyService.delete(bookreply.getBookreplyseq());
            if(result == 1) message="삭제되었습니다.";
        }
        return message;
    }

    //댓글 수정을 위한 1개의 데이터를 조회
    @ResponseBody
    @PostMapping("/bookreplyFind")
    public BookReply bookreplyFind(Long bookreplyseq, @AuthenticationPrincipal UserDetails user){
        System.out.println(bookreplyseq);
        String loginId = user.getUsername(); //로그인 정보
        BookReply bookreply = bookreplyService.findOne(bookreplyseq);

        if(loginId.equals(bookreply.getUsrid()))
            return bookreply;
        return null;
    }

    //댓글 수정
    @ResponseBody
    @PostMapping("/bookreplyUpdate")
    public String bookreplyUpdate(BookReply bookreply){
        int result = bookreplyService.update(bookreply);

        String message = null;
        if(result == 1){
            message="수정 완료";
        }else {
            message="수정 오류";
        }
        return message;
    }
}
