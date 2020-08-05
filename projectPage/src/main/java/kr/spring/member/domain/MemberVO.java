package kr.spring.member.domain;

import java.sql.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberVO {
	// 로그인 시도 시 아이디 혹은 비밀번호가 틀릴 경우 count의 값이 0이 되며, '아이디/비밀번호를 확인해주세요.' 경고창이 출력되도록 하는 변수
	public int count = 1;
	
	private int mem_num; // 이름
	@Size(min=6, max=12)
	private String mem_id; // 아이디
	@NotEmpty
	private String mem_name; // 이름
	@Size(min=8, max=20)
	private String mem_pw; // 비밀번호
	@NotEmpty
	private String mem_cell; // 폰 번호
	private int mem_auth; // 회원등급
	@Email
	@NotEmpty
	private String mem_email; // 이메일
	@NotEmpty
	private String mem_zip; // 우편번호
	@NotEmpty
	private String mem_addr; // 주소
	private String mem_addr2; // 상세
	private Date mem_date; // 회원등록 날짜
	
	// 비밀번호 확인
	public boolean isCheckedPasswd(String userPasswd) {
		if(mem_auth > 1 && mem_pw.equals(userPasswd)) {
			
			return true;
		}
		
		return false;
	}
	
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	
	public String getMem_cell() {
		return mem_cell;
	}
	public void setMem_cell(String mem_cell) {
		this.mem_cell = mem_cell;
	}
	
	public int getMem_auth() {
		return mem_auth;
	}
	public void setMem_auth(int mem_auth) {
		this.mem_auth = mem_auth;
	}
	
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	
	public String getMem_zip() {
		return mem_zip;
	}
	public void setMem_zip(String mem_zip) {
		this.mem_zip = mem_zip;
	}
	
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	
	public Date getMem_date() {
		return mem_date;
	}
	public void setMem_date(Date mem_date) {
		this.mem_date = mem_date;
	}
}