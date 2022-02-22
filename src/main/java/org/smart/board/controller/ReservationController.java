package org.smart.board.controller;

import org.smart.board.entity.Book;
import org.smart.board.entity.Reservation;
import org.smart.board.service.BookService;
import org.smart.board.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    BookService bookService;

    @Autowired
    ReservationService reservationService;

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

    @PostMapping("/rvWrite")
    public String rvWrite(Reservation reservation, @AuthenticationPrincipal UserDetails user){
        //아이디 꺼내오기

        String loginId = user.getUsername();
        reservation.setUsrid(loginId);

        int result = reservationService.rvWrite(reservation);

        int result2 = bookService.updateStock(reservation);



        return "index";
    }

}
