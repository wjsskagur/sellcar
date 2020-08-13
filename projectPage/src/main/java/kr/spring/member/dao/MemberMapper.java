package kr.spring.member.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.member.domain.MemberVO;

public interface MemberMapper {
	// 회원번호 가져오기
	@Select("SELECT member_seq.nextval FROM dual")
	public Integer selectMem_num();
	
	// 회원가입
	@Select("INSERT INTO member (mem_id, mem_num, mem_auth) VALUES (#{mem_id}, #{mem_num}, 2)")
	public void insert(MemberVO member);
	@Select("INSERT INTO member_detail (mem_num, mem_name, mem_pw, mem_cell, mem_email, mem_zip, mem_addr, mem_addr2, mem_date) VALUES (#{mem_num}, #{mem_name}, #{mem_pw}, #{mem_cell}, #{mem_email}, #{mem_zip}, #{mem_addr}, #{mem_addr2}, SYSDATE)")
	public void insertDetail(MemberVO member);
	
	// 아이디 중복 체크 및 로그인 체크
	@Select("SELECT * FROM member m LEFT OUTER JOIN member_detail d ON m.mem_num = d.mem_num WHERE m.mem_id=#{mem_id}")
	public MemberVO selectCheckMember(String id);
	
	// 이름, 연락처를 받음으로서 해당 회원의 아이디 찾기
	@Select("SELECT * FROM member m LEFT OUTER JOIN member_detail d ON m.mem_num = d.mem_num WHERE mem_name=#{mem_name} AND mem_cell=#{mem_cell}")
    public MemberVO findMemberId(@Param("mem_name") String mem_name, @Param("mem_cell") String mem_cell);
	
	@Select("SELECT * FROM member m JOIN member_detail d ON m.mem_num = d.mem_num WHERE m.mem_num=#{mem_num}")
	public MemberVO selectMember(int mem_num);
	@Update("UPDATE member_detail SET mem_name=#{mem_name},mem_email=#{mem_email},mem_cell=#{mem_cell},mem_zip=#{mem_zip},mem_addr=#{mem_addr},mem_addr2=#{mem_addr2} WHERE mem_num=#{mem_num}")
	public void updateMember(MemberVO member); 
	@Update("UPDATE member_detail SET mem_pw=#{mem_pw} WHERE mem_num=#{mem_num}")
	public void updatePassword(MemberVO member);
	
	@Update("UPDATE member SET mem_auth=0 WHERE mem_num=#{mem_num}")
	public void delete(Integer mem_num);
	@Delete("DELETE FROM member_detail WHERE mem_num=#{mem_num}")
	public void deleteDetail(Integer mem_num);
	
}
