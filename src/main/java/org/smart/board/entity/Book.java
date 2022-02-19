package org.smart.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private Long bookseq;
    private String isbn;
    private String booktitle;
    private String writer;
    private String publisher;
    private String descrip;
    private int stock;
    private String bookphoto;
}
