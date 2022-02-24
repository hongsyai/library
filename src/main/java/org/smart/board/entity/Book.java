package org.smart.board.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString
public class Book {
    private int bookseq;
    private String isbn;
    private String booktitle;
    private String writer;
    private String publisher;
    private String descrip;
    private int stock;
    private String bookphoto;
    private String all;
    private String rvseq;
    private String usrid;
    private int returnbook;

}
/*
CREATE TABLE book
(
    bookseq   NUMBER,
    isbn      NUMBER PRIMARY KEY,
    booktitle VARCHAR2(100) NOT NULL,
    writer    VARCHAR2(50) NOT NULL,
    publisher VARCHAR2(50) NOT NULL,
    descrip   VARCHAR2(1000),
    stock     NUMBER default 0,
    bookphoto VARCHAR2(500)     -- 책 사진 파일명
);
 */