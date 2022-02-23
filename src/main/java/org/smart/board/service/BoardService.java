package org.smart.board.service;

import org.smart.board.entity.Board;
import org.smart.board.entity.Book;
import org.smart.board.entity.Reservation;

import java.util.List;

public interface BoardService {
    // 게시글 전체 데이터 가져오기
    public List<Book> findAll(String searchField, String search_text);

    public Book findOne(Long bookseq);

    public int updateStock(Reservation reservation);
}
