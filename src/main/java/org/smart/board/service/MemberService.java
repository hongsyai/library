package org.smart.board.service;

import org.smart.board.entity.Member;

public interface MemberService {
    // 회원가입
    public int insertMember(Member member);

    //회원조회 return null인 경우만 사용 가능
    public Member findOne(String usrid);

    // 회원정보 업데이트
    public int update(Member member);
}
