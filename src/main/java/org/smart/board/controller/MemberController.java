package org.smart.board.controller;

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
}
