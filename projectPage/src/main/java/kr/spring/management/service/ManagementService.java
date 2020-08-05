package kr.spring.management.service;

import java.util.List;
import java.util.Map;

import kr.spring.member.domain.MemberVO;

public interface ManagementService {
	public List<MemberVO> selectList(Map<String, Object> map);
	public int selectRowCount();
	public MemberVO selectMember(String mem_id);
}
