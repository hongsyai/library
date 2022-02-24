package org.smart.board.service;

import org.smart.board.dao.MemberDao;
import org.smart.board.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberDao memberDao;

    @Override
    public int insertMember(Member member) {
        String encodedPwd = passwordEncoder.encode(member.getUsrpwd());
        member.setUsrpwd(encodedPwd);

        int result = memberDao.insertMember(member);

        return result;
    }
    // 어제 만들었던 코드 날렸음

    @Override
    public Member findOne(String usrid) {

        return memberDao.findOne(usrid);
    }
    @Override
    public int update(Member member) {
        int result = memberDao.update(member);
        return result;
    }

}
