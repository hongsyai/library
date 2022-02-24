package org.smart.board.controller;

import org.smart.board.entity.Book;
import org.smart.board.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/bookList")
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


        for(int i = 0; i< bookList.size(); i++) {
            if(bookList.get(i).getStock()>0) {
                bookList.get(i).setReturnbook(1);
            }
        }

        return "book/bookList";

    }

    @GetMapping("/bookDetail")
    public String bookDetail(Long bookseq, Model model){

        Book book  = bookService.findOne(bookseq);

        // 2) Model에 저장
        model.addAttribute("book", book);

        System.out.println("findone으로 하나 찾아온거 : ==================" +book);

        if(book.getStock() >0){
            book.setReturnbook(1);
        }

        return "book/bookDetail";

    }

//    @GetMapping("/bookSearch")
//    public String bookSearch() {
//        return "book/bookSearch";
//    }
//
//    @PostMapping("/bookSearch")
//    @ResponseBody
//    public List<Book> search_text(String searchField, String search_text) {
//        List<Book> booklist  = bookService.findAll(searchField, search_text);
//
//        return booklist;
//    }

}
