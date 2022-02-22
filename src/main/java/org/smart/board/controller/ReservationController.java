package org.smart.board.controller;

import org.smart.board.entity.Book;
import org.smart.board.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    BookService bookService;

    @GetMapping("/reservationPage")
    public String reservationPage(Long bookseq, Model model){
        System.out.println("====================" + bookseq);
        Book book  = bookService.findOne(bookseq);

        // 2) Model에 저장
        model.addAttribute("book", book);

        System.out.println("findone으로 하나 찾아온거 : ==================" +book);

        if(book.getStock() >0){
            book.setReturnbook(1);
        }
        return "/reservation/reservationPage";
    }
}
