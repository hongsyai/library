package org.smart.board.entity;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Reservation {
    private int rvseq;
    private String usrid;
    private int bookseq;
    private String rvStartDate;
    private String rvEndDate;
    private int returnBook;
    private String isbn;
    private String booktitle;
    private String writer;
    private String publisher;
    private String descrip;
    private int stock;
    private String bookphoto;
    private String all;

}
/*
CREATE TABLE reservation
(
    rvseq   NUMBER  PRIMARY KEY, -- 예약번호
    usrid   VARCHAR2(20)REFERENCES "member"(USRID) ON DELETE CASCADE,
    bookseq    NUMBER      REFERENCES book(bookseq) ON DELETE CASCADE,
    rvStartDate date default sysdate, -- 대여 시작 날짜
    rvEndDate date default sysdate + 5 , -- 대여 끝 날짜
    returnBook number(1) default 0  -- 1 = 대여중 , 0= 대여x
);
 */