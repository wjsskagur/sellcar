package kr.spring.management.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.member.domain.MemberVO;

public interface ManagementMapper {
	public List<MemberVO> selectList(Map<String, Object> map);
	@Select("SELECT COUNT(*) FROM member m JOIN member_detail d ON m.mem_num = d.mem_num")
	public int selectRowCount();
	@Select("SELECT * FROM member m JOIN member_detail d ON m.mem_num=d.mem_num WHERE m.mem_id=#{mem_id}")
	public MemberVO selectMember(String mem_id);
	
	@Update("UPDATE member SET mem_auth=0 WHERE mem_num=#{mem_num}")
	public void clear(int mem_num);
	@Delete("DELETE FROM member_detail WHERE mem_num=#{mem_num}")
	public void clearDetail(int mem_num); 
	
	@Update("UPDATE member SET mem_auth=#{mem_auth} WHERE mem_num=#{mem_num}")
	public void level(@Param("mem_auth") int mem_auth, @Param("mem_num") int mem_num);
}