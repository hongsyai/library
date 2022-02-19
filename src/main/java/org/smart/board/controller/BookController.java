package org.smart.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @GetMapping("/bookDetail")
    public String bookDetail() {

        return "book/bookDetail";
    }

    @GetMapping("/bookSearch")
    public String bookSearch() {

        return "book/bookSearch";
    }

}
