package org.smart.board.controller;

import org.smart.board.entity.Board;
import org.smart.board.entity.Book;
import org.smart.board.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/bookList")
    public String bookList(@RequestParam(defaultValue="all") String searchField,
                           @RequestParam(defaultValue="") String search_text,
                           Model model){
        List<Book> bookList = bookService.findAll(searchField, search_text);

        System.out.println(bookList);
        System.out.println("가져온 글 개수 : " + bookList.size());

        model.addAttribute("bookList", bookList);
        model.addAttribute("searchField", searchField);
        model.addAttribute("search_text", search_text);
        System.out.println("=================" + bookList);


        System.out.println(bookList.get(0).getReturnbook());

        return "book/bookList";
    }

    //    @GetMapping("/bookDetail")
//    public String bookDetail() {
//
//        return "book/bookDetail";
//    }
    /**
     * 글 자세히 보기 화면 요청
     * @param bookseq
     * @param model
     * @return
     */
    @GetMapping("/bookDetail")
    public String bookDetail(Long bookseq, Model model) {
        // 1) DB에서 boardseq에 해당하는 하나의 글을 질의해옴
        // 1-1) 조회수 증가해야함
        Book book  = bookService.findOne(bookseq);

        // 2) Model에 저장
        model.addAttribute("book", book);

        // 3) view로 forward
        return "book/bookDetail";
    }

    @GetMapping("/bookSearch")
    public String bookSearch() {

        return "book/bookSearch";
    }

}
