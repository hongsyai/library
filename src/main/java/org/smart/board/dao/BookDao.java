package org.smart.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.smart.board.entity.Book;
import org.smart.board.entity.Reservation;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookDao {
    public List<Book> findAll(Map<String, Object> map);

    public Book findOne(Long bookseq);

    public int updateStock(Reservation reservation);
}
