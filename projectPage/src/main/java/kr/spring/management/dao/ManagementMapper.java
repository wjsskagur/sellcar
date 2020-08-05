package kr.spring.management.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import kr.spring.member.domain.MemberVO;

public interface ManagementMapper {
	public List<MemberVO> selectList(Map<String, Object> map);
	@Select("SELECT COUNT(*) FROM member m JOIN member_detail d ON m.mem_num = d.mem_num")
	public int selectRowCount();
	@Select("SELECT * FROM member m JOIN member_detail d ON m.mem_num=d.mem_num WHERE m.mem_id=#{mem_id}")
	public MemberVO selectMember(String mem_id);
}