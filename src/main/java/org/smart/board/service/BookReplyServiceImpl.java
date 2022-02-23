package org.smart.board.service;

import org.smart.board.dao.BookReplyDao;
import org.smart.board.entity.BookReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReplyServiceImpl implements BookReplyService{

    @Autowired
    BookReplyDao bookreplyDao;

    @Override
    public List<BookReply> list(Long bookseq) {
        return bookreplyDao.list(bookseq);
    }

    @Override
    public int insert(BookReply bookreply) {
        return bookreplyDao.insert(bookreply);
    }

    @Override
    public BookReply findOne(Long bookreplyseq) {
        return bookreplyDao.findOne(bookreplyseq);
    }

    @Override
    public int delete(Long bookreplyseq) {
        return bookreplyDao.delete(bookreplyseq);
    }

    @Override
    public int update(BookReply bookreply) {
        return bookreplyDao.update(bookreply);
    }
}
