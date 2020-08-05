package kr.spring.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.member.dao.MemberMapper;
import kr.spring.member.domain.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberMapper memberMapper;
	
	@Override
	public MemberVO selectCheckMember(String id) {
		
		return memberMapper.selectCheckMember(id);
	}

	@Override
	public void insert(MemberVO member) {
		// 시퀀스를 이용해서 mem_num 구하기
		member.setMem_num(memberMapper.selectMem_num());
		
		memberMapper.insert(member);
		memberMapper.insertDetail(member);
	}

	@Override
	public MemberVO findMemberId(String name, String cell) {
		
		return memberMapper.findMemberId(name, cell);
	}
	
}