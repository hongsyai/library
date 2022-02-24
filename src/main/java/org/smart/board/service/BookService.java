package org.smart.board.service;

import org.smart.board.entity.Board;
import org.smart.board.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    public List<Book> findAll(String searchField, String search_text);
    public Book findOne(Long boardseq);
}
