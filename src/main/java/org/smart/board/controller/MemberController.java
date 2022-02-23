package org.smart.board.controller;

import org.smart.board.entity.Board;
import org.smart.board.entity.Member;
import org.smart.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/account")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 로그인 화면 요청
     * @return
     */
    @GetMapping("/loginForm")
    public String loginForm() {

        return "account/loginForm";
    }

    /**
     * 회원가입을 위한 화면 요청
     * @return
     */
    @GetMapping("/register")
    public String register() {

        return "account/register";
    }
    /**
     * 회원가입 처리를 위한 요청
     * @return
     */
    @PostMapping("/register")
    public String register(Member member) {
        memberService.insertMember(member);

        return "index";
    }

    /**
     * 회원정보 화면 요청
     */
    @GetMapping("/myInfo")
    public String myInfo(Model model, @AuthenticationPrincipal UserDetails user) {
        String loginid = user.getUsername();
        Member member = memberService.findOne(loginid);

        model.addAttribute("member", member);

        return "account/myInfo";
    }

    /*
    회원정보 수정 위한 화면 요청
     */
    @GetMapping("/myInfoEdit")
    public String myInfoEdit(String usrid, Model model) {
        Member member = memberService.findOne(usrid);
        model.addAttribute("member", member);
        return "account/myInfoEdit";
    }

//    @PostMapping("/myInfoEdit")
//    public String myInfoEdit(Board board) {
//
//        return "redirect:/account/myInfoEdit";
//    }

    /**
     * 회원정보 수정 요청
     */
    @PostMapping("/myInfoEdit")
    public String myInfoEdit(Member member, RedirectAttributes rttr){
        System.out.println(member);
        memberService.update(member);
        rttr.addAttribute("usrid", member.getUsrid());
        return "redirect:/account/myInfo";
    }

}
