package org.smart.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.smart.board.entity.Member;

@Mapper
public interface MemberDao {
    // 회원가입
    public int insertMember(Member member);

    // 회원조회
    public Member findOne(String usrid);

    // 회원정보수정
    public int update(Member member);
}
