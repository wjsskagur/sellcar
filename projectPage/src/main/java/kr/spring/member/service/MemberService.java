package kr.spring.member.service;

import kr.spring.member.domain.MemberVO;

public interface MemberService {
	public MemberVO selectCheckMember(String id);
	public void insert(MemberVO member);
	
	public MemberVO findMemberId(String name, String cell);
}
