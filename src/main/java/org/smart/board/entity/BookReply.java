package org.smart.board.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BookReply {
    private Long bookreplyseq;
    private Long bookseq;
    private String usrid;
    private String bookreplytext;
    private int starcount;
    private String regdate;
}
