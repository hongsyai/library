package org.smart.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myPage")
public class MyPageController {

    @GetMapping("/myBoardList")
    public String myBoardList() {

        return "myPage/myBoardList";
    }

    @GetMapping("/myBookList")
    public String myBookList() {

        return "myPage/myBookList";
    }
}
