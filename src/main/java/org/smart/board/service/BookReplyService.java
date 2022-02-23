package org.smart.board.service;

import org.smart.board.entity.BookReply;
import org.smart.board.entity.Reply;

import java.util.List;

public interface BookReplyService {
    public List<BookReply> list(Long bookseq);
    public int insert(BookReply bookreply);
    public BookReply findOne(Long bookreplyseq);
    public int delete(Long bookreplyseq);
    public int update(BookReply bookreply);
}
