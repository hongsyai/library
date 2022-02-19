package org.smart.board.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BookReply {
    private Long replyseq;
    private Long boardseq;
    private String usrid;
    private String replytext;
    private int starcount;
    private String regdate;
}
