package kr.green.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.MemberDAO;
import kr.green.springtest.vo.MemberVO;
 
@Service
public class MemberServicelmp implements MemberService {
  
	@Autowired
  MemberDAO memberDao;
  
  @Override
  public String getEmail(String id) {
      return memberDao.getEmail(id);
  }

	@Override
	public boolean signup(MemberVO member) {
		if(member == null)
			return false;
		if(member.getMe_id() == null || member.getMe_pw() == null ||
				member.getMe_birth() == null || member.getMe_email() == null)
			return false;
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		
		if(dbMember != null)
			return false;
		
		memberDao.insertMember(member);
		return true;
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return null;
			
			MemberVO user = memberDao.selectMember(member.getMe_id());
			//가입된 아이디가 아니면
			if(user == null)
				return null;
			
			//아이디, 비번이 일치하는 경우
			if(user.getMe_pw().equals(member.getMe_pw()))
				return user;
			//아이디는 있지만 비번이 다른경우
			return null;
	}
}
 
