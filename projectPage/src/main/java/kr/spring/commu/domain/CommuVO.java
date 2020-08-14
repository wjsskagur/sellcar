package kr.spring.commu.domain;

import java.io.IOException;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class CommuVO {
	private String mem_id;
	private int board_num;
	private String board_name;
	private String board_con;
	private String board_com;
	private int board_auth;
	private char secret_yn;
	private Date reg_date;
	private Date mod_date;
	private String ip;
	private MultipartFile upload;
	private byte[] board_img;
	private String board_filename;
	private int board_hit;
	
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_con() {
		return board_con;
	}
	public void setBoard_con(String board_con) {
		this.board_con = board_con;
	}
	public String getBoard_com() {
		return board_com;
	}
	public void setBoard_com(String board_com) {
		this.board_com = board_com;
	}
	public int getBoard_auth() {
		return board_auth;
	}
	public void setBoard_auth(int board_auth) {
		this.board_auth = board_auth;
	}
	public char getSecret_yn() {
		return secret_yn;
	}
	public void setSecret_yn(char secret_yn) {
		this.secret_yn = secret_yn;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getMod_date() {
		return mod_date;
	}
	public void setMod_date(Date mod_date) {
		this.mod_date = mod_date;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) throws IOException {
		this.upload = upload;
		//byte[] 로 변환
		setBoard_img(upload.getBytes());
		
		setBoard_filename(upload.getOriginalFilename());
		
	}
	public byte[] getBoard_img() {
		return board_img;
	}
	public void setBoard_img(byte[] board_img) {
		this.board_img = board_img;
	}
	public String getBoard_filename() {
		return board_filename;
	}
	public void setBoard_filename(String board_filename) {
		this.board_filename = board_filename;
	}
	@Override
	public String toString() {
		return "CommuVO [mem_id=" + mem_id + ", board_num=" + board_num + ", board_name=" + board_name + ", board_con="
				+ board_con + ", board_com=" + board_com + ", board_auth=" + board_auth + ", secret_yn=" + secret_yn
				+ ", reg_date=" + reg_date + ", mod_date=" + mod_date + ", ip=" + ip + ", upload=" + upload
				+ ", board_filename=" + board_filename +",board_hit"+board_hit+ "]";
	}
	
	
}
