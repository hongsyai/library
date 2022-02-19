package org.smart.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.smart.board.entity.Board;
import org.smart.board.entity.Book;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookDao {
    public List<Book> findAll(Map<String, Object> map);
    public int insert(Book book);
    public Board findOne(Long bookseq);
    public int getBookCount(Map<String, String> map);
}
