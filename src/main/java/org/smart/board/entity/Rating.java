package org.smart.board.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Rating {
    private Long ratingseq;
    private Long bookseq;
    private int likecount;
    private int starcount;
}
