package org.smart.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.smart.board.entity.BookReply;

import java.util.List;

@Mapper
public interface BookReplyDao {
    /**
     * 특정 boardseq에 해당하는 모든 댓글 목록 리턴
     * @param bookseq
     * @return
     */
    public List<BookReply> list(Long bookseq);

    /**
     * 댓글 등록
     * @param bookreply
     * @return
     */
    public int insert(BookReply ReplyDaoreply);

    public BookReply findOne(Long bookreplyseq);
    public int delete(Long bookreplyseq);
    public int update(BookReply bookreply);
}
