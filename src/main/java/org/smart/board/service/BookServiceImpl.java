package org.smart.board.service;

import org.smart.board.dao.BookDao;
import org.smart.board.entity.Board;
import org.smart.board.entity.Book;
import org.smart.board.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookDao bookDao;
    @Override
    public List<Book> findAll(String searchField, String search_text) {
        Map<String, Object> map = new HashMap<>();

        map.put("searchField", searchField);
        map.put("search_text", search_text);

        List<Book> bookList = bookDao.findAll(map);
        return bookList;
    }

    @Override
    public Book findOne(Long bookseq) {
        return bookDao.findOne(bookseq);
    }

    @Override
    public int updateStock(Reservation reservation) {
        return bookDao.updateStock(reservation);
    }
}

