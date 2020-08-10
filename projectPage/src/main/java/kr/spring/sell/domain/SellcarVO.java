package kr.spring.sell.domain;

import java.io.IOException;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class SellcarVO {
	private byte[] car_mainimg;
	private byte[] car_img1;
	private byte[] car_img2;
	private byte[] car_img3;
	private byte[] car_img4;
	private byte[] car_img5;
	private byte[] car_img6;
	private byte[] car_img7;
	private byte[] car_img8;
	private byte[] car_img9;
	private byte[] car_img10;
	private byte[] car_option;
	private byte[] car_test;
	private byte[] car_content;
	private byte[] map_img;
	private byte[] car_log;
	private byte[] car_detail;
	private MultipartFile upload1;
	private MultipartFile upload2;
	private MultipartFile upload3;
	private MultipartFile upload4;
	private MultipartFile upload5;
	private MultipartFile upload6;
	private MultipartFile upload7;
	private MultipartFile upload8;
	private MultipartFile upload9;
	private MultipartFile upload10;
	private MultipartFile upload11;
	private MultipartFile upload12;
	private MultipartFile upload13;
	private MultipartFile upload14;
	private MultipartFile upload15;
	private MultipartFile upload16;
	private MultipartFile upload17;
	private String filename1;
	private String filename2;
	private String filename3;
	private String filename4;
	private String filename5;
	private String filename6;
	private String filename7;
	private String filename8;
	private String filename9;
	private String filename10;
	private String filename11;
	private String filename12;
	private String filename13;
	private String filename14;
	private String filename15;
	private String filename16;
	private String filename17;
	private String car_des;
	private int board_num;
	private String board_name;
	private String board_con;
	private String board_com;
	private int board_auth;
	private String mem_id;
	private Date reg_date;
	private char secret_yn;
	private Date mod_date;
	private String ip;
	private int car_num;
	private int mem_auth;
	private String car_name;
	private String car_cate1;
	private String car_cate2;
	private String car_cate3;
	private String car_cate4;
	private String car_cate5;
	private int car_break;
	private int car_smoke;
	private String car_outcolor;
	private String car_incolor;
	private String car_work;
	private int car_debt;
	private int car_price;
	private String comm_com;
	private int fo_hit;
	private int fo_good;
	private int fo_bad;
	private int map_num;
	private String map_name;
	private String map_address;
	private String map_content;
	private int mem_num;
	private String mem_name;
	private String mem_pw;
	private String mem_cell;
	private String mem_email;
	private String mem_zip;
	private String mem_addr;
	private String mem_date;
	private int ord_num;
	private int ord_price;
	private char ord_map;
	private String ord_etc;
	private char ord_pdata;
	private int qna_num;
	private String qna_com;
	private String qna_title;
	private int qna_auth;
	private String answer;
	private int qna_hit;
	private int review_num;
	private String review_title;
	private String review_con;
	private String review_com;
	private String car_number;
	private int carp_num;
	
	public SellcarVO() {};
	
	
	
	public byte[] getCar_mainimg() {
		return car_mainimg;
	}

	public void setCar_mainimg(byte[] car_mainimg) {
		this.car_mainimg = car_mainimg;
	}

	public byte[] getCar_img1() {
		return car_img1;
	}

	public void setCar_img1(byte[] car_img1) {
		this.car_img1 = car_img1;
	}

	public byte[] getCar_img2() {
		return car_img2;
	}

	public void setCar_img2(byte[] car_img2) {
		this.car_img2 = car_img2;
	}

	public byte[] getCar_img3() {
		return car_img3;
	}

	public void setCar_img3(byte[] car_img3) {
		this.car_img3 = car_img3;
	}

	public byte[] getCar_img4() {
		return car_img4;
	}

	public void setCar_img4(byte[] car_img4) {
		this.car_img4 = car_img4;
	}

	public byte[] getCar_img5() {
		return car_img5;
	}

	public void setCar_img5(byte[] car_img5) {
		this.car_img5 = car_img5;
	}

	public byte[] getCar_img6() {
		return car_img6;
	}

	public void setCar_img6(byte[] car_img6) {
		this.car_img6 = car_img6;
	}

	public byte[] getCar_img7() {
		return car_img7;
	}

	public void setCar_img7(byte[] car_img7) {
		this.car_img7 = car_img7;
	}

	public byte[] getCar_img8() {
		return car_img8;
	}

	public void setCar_img8(byte[] car_img8) {
		this.car_img8 = car_img8;
	}

	public byte[] getCar_img9() {
		return car_img9;
	}

	public void setCar_img9(byte[] car_img9) {
		this.car_img9 = car_img9;
	}

	public byte[] getCar_img10() {
		return car_img10;
	}

	public void setCar_img10(byte[] car_img10) {
		this.car_img10 = car_img10;
	}

	public byte[] getCar_option() {
		return car_option;
	}

	public void setCar_option(byte[] car_option) {
		this.car_option = car_option;
	}

	public byte[] getCar_test() {
		return car_test;
	}

	public void setCar_test(byte[] car_test) {
		this.car_test = car_test;
	}

	public byte[] getCar_content() {
		return car_content;
	}

	public void setCar_content(byte[] car_content) {
		this.car_content = car_content;
	}

	public byte[] getMap_img() {
		return map_img;
	}

	public void setMap_img(byte[] map_img) {
		this.map_img = map_img;
	}

	public byte[] getCar_log() {
		return car_log;
	}

	public void setCar_log(byte[] car_log) {
		this.car_log = car_log;
	}

	public byte[] getCar_detail() {
		return car_detail;
	}

	public void setCar_detail(byte[] car_detail) {
		this.car_detail = car_detail;
	}

	public MultipartFile getUpload1() {
		return upload1;
	}

	public void setUpload1(MultipartFile upload1) throws IOException{
		this.upload1 = upload1;
		setCar_mainimg(upload1.getBytes());
		setFilename1(upload1.getOriginalFilename());
	}

	public MultipartFile getUpload2() {
		return upload2;
	}

	public void setUpload2(MultipartFile upload2) throws IOException{
		this.upload2 = upload2;
		setCar_img1(upload2.getBytes());
		setFilename2(upload2.getOriginalFilename());
	}

	public MultipartFile getUpload3() {
		return upload3;
	}

	public void setUpload3(MultipartFile upload3) throws IOException{
		this.upload3 = upload3;
		setCar_img2(upload3.getBytes());
		setFilename3(upload3.getOriginalFilename());
	}

	public MultipartFile getUpload4() {
		return upload4;
	}

	public void setUpload4(MultipartFile upload4) throws IOException{
		this.upload4 = upload4;
		setCar_img3(upload4.getBytes());
		setFilename4(upload4.getOriginalFilename());
	}

	public MultipartFile getUpload5() {
		return upload5;
	}

	public void setUpload5(MultipartFile upload5) throws IOException{
		this.upload5 = upload5;
		setCar_img4(upload5.getBytes());
		setFilename5(upload5.getOriginalFilename());
	}

	public MultipartFile getUpload6() {
		return upload6;
	}

	public void setUpload6(MultipartFile upload6) throws IOException{
		this.upload6 = upload6;
		setCar_img5(upload6.getBytes());
		setFilename6(upload6.getOriginalFilename());
	}

	public MultipartFile getUpload7() {
		return upload7;
	}

	public void setUpload7(MultipartFile upload7) throws IOException{
		this.upload7 = upload7;
		setCar_img6(upload7.getBytes());
		setFilename7(upload7.getOriginalFilename());
	}

	public MultipartFile getUpload8() {
		return upload8;
	}

	public void setUpload8(MultipartFile upload8) throws IOException{
		this.upload8 = upload8;
		setCar_img7(upload8.getBytes());
		setFilename8(upload8.getOriginalFilename());
	}

	public MultipartFile getUpload9() {
		return upload9;
	}

	public void setUpload9(MultipartFile upload9) throws IOException{
		this.upload9 = upload9;
		setCar_img8(upload9.getBytes());
		setFilename9(upload9.getOriginalFilename());
	}

	public MultipartFile getUpload10() {
		return upload10;
	}

	public void setUpload10(MultipartFile upload10) throws IOException{
		this.upload10 = upload10;
		setCar_img9(upload10.getBytes());
		setFilename10(upload10.getOriginalFilename());
	}

	public MultipartFile getUpload11() {
		return upload11;
	}

	public void setUpload11(MultipartFile upload11) throws IOException{
		this.upload11 = upload11;
		setCar_img10(upload11.getBytes());
		setFilename11(upload11.getOriginalFilename());
	}

	public MultipartFile getUpload12() {
		return upload12;
	}

	public void setUpload12(MultipartFile upload12) throws IOException{
		this.upload12 = upload12;
		setCar_option(upload12.getBytes());
		setFilename12(upload12.getOriginalFilename());
	}

	public MultipartFile getUpload13() {
		return upload13;
	}

	public void setUpload13(MultipartFile upload13) throws IOException{
		this.upload13 = upload13;
		setCar_test(upload13.getBytes());
		setFilename13(upload13.getOriginalFilename());
	}

	public MultipartFile getUpload14() {
		return upload14;
	}

	public void setUpload14(MultipartFile upload14) throws IOException{
		this.upload14 = upload14;
		setCar_content(upload14.getBytes());
		setFilename14(upload14.getOriginalFilename());
	}

	public MultipartFile getUpload15() {
		return upload15;
	}

	public void setUpload15(MultipartFile upload15) throws IOException{
		this.upload15 = upload15;
		setMap_img(upload15.getBytes());
		setFilename15(upload15.getOriginalFilename());
	}

	public MultipartFile getUpload16() {
		return upload16;
	}

	public void setUpload16(MultipartFile upload16) throws IOException{
		this.upload16 = upload16;
		setCar_log(upload16.getBytes());
		setFilename16(upload16.getOriginalFilename());
	}
	
	public MultipartFile getUpload17() {
		return upload17;
	}

	public void setUpload17(MultipartFile upload17) throws IOException{
		this.upload17 = upload17;
		setCar_detail(upload17.getBytes());
		setFilename17(upload17.getOriginalFilename());
	}

	public String getFilename17() {
		return filename17;
	}

	public void setFilename17(String filename17) {
		this.filename17 = filename17;
	}

	public String getFilename1() {
		return filename1;
	}

	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}

	public String getFilename2() {
		return filename2;
	}

	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}

	public String getFilename3() {
		return filename3;
	}

	public void setFilename3(String filename3) {
		this.filename3 = filename3;
	}

	public String getFilename4() {
		return filename4;
	}

	public void setFilename4(String filename4) {
		this.filename4 = filename4;
	}

	public String getFilename5() {
		return filename5;
	}

	public void setFilename5(String filename5) {
		this.filename5 = filename5;
	}

	public String getFilename6() {
		return filename6;
	}

	public void setFilename6(String filename6) {
		this.filename6 = filename6;
	}

	public String getFilename7() {
		return filename7;
	}

	public void setFilename7(String filename7) {
		this.filename7 = filename7;
	}

	public String getFilename8() {
		return filename8;
	}

	public void setFilename8(String filename8) {
		this.filename8 = filename8;
	}

	public String getFilename9() {
		return filename9;
	}

	public void setFilename9(String filename9) {
		this.filename9 = filename9;
	}

	public String getFilename10() {
		return filename10;
	}

	public void setFilename10(String filename10) {
		this.filename10 = filename10;
	}

	public String getFilename11() {
		return filename11;
	}

	public void setFilename11(String filename11) {
		this.filename11 = filename11;
	}

	public String getFilename12() {
		return filename12;
	}

	public void setFilename12(String filename12) {
		this.filename12 = filename12;
	}

	public String getFilename13() {
		return filename13;
	}

	public void setFilename13(String filename13) {
		this.filename13 = filename13;
	}

	public String getFilename14() {
		return filename14;
	}

	public void setFilename14(String filename14) {
		this.filename14 = filename14;
	}

	public String getFilename15() {
		return filename15;
	}

	public void setFilename15(String filename15) {
		this.filename15 = filename15;
	}

	public String getFilename16() {
		return filename16;
	}

	public void setFilename16(String filename16) {
		this.filename16 = filename16;
	}

	public String getCar_des() {
		return car_des;
	}

	public void setCar_des(String car_des) {
		this.car_des = car_des;
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

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public char getSecret_yn() {
		return secret_yn;
	}

	public void setSecret_yn(char secret_yn) {
		this.secret_yn = secret_yn;
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

	public int getCar_num() {
		return car_num;
	}

	public void setCar_num(int car_num) {
		this.car_num = car_num;
	}

	public int getMem_auth() {
		return mem_auth;
	}

	public void setMem_auth(int mem_auth) {
		this.mem_auth = mem_auth;
	}

	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public String getCar_cate1() {
		return car_cate1;
	}

	public void setCar_cate1(String car_cate1) {
		this.car_cate1 = car_cate1;
	}

	public String getCar_cate2() {
		return car_cate2;
	}

	public void setCar_cate2(String car_cate2) {
		this.car_cate2 = car_cate2;
	}

	public String getCar_cate3() {
		return car_cate3;
	}

	public void setCar_cate3(String car_cate3) {
		this.car_cate3 = car_cate3;
	}

	public String getCar_cate4() {
		return car_cate4;
	}

	public void setCar_cate4(String car_cate4) {
		this.car_cate4 = car_cate4;
	}

	public String getCar_cate5() {
		return car_cate5;
	}

	public void setCar_cate5(String car_cate5) {
		this.car_cate5 = car_cate5;
	}

	public int getCar_break() {
		return car_break;
	}

	public void setCar_break(int car_break) {
		this.car_break = car_break;
	}

	public int getCar_smoke() {
		return car_smoke;
	}

	public void setCar_smoke(int car_smoke) {
		this.car_smoke = car_smoke;
	}

	public String getCar_outcolor() {
		return car_outcolor;
	}

	public void setCar_outcolor(String car_outcolor) {
		this.car_outcolor = car_outcolor;
	}

	public String getCar_incolor() {
		return car_incolor;
	}

	public void setCar_incolor(String car_incolor) {
		this.car_incolor = car_incolor;
	}

	public String getCar_work() {
		return car_work;
	}

	public void setCar_work(String car_work) {
		this.car_work = car_work;
	}

	public int getCar_debt() {
		return car_debt;
	}

	public void setCar_debt(int car_debt) {
		this.car_debt = car_debt;
	}

	public int getCar_price() {
		return car_price;
	}

	public void setCar_price(int car_price) {
		this.car_price = car_price;
	}

	public String getComm_com() {
		return comm_com;
	}

	public void setComm_com(String comm_com) {
		this.comm_com = comm_com;
	}

	public int getFo_hit() {
		return fo_hit;
	}

	public void setFo_hit(int fo_hit) {
		this.fo_hit = fo_hit;
	}

	public int getFo_good() {
		return fo_good;
	}

	public void setFo_good(int fo_good) {
		this.fo_good = fo_good;
	}

	public int getFo_bad() {
		return fo_bad;
	}

	public void setFo_bad(int fo_bad) {
		this.fo_bad = fo_bad;
	}

	public int getMap_num() {
		return map_num;
	}

	public void setMap_num(int map_num) {
		this.map_num = map_num;
	}

	public String getMap_name() {
		return map_name;
	}

	public void setMap_name(String map_name) {
		this.map_name = map_name;
	}

	public String getMap_address() {
		return map_address;
	}

	public void setMap_address(String map_address) {
		this.map_address = map_address;
	}

	public String getMap_content() {
		return map_content;
	}

	public void setMap_content(String map_content) {
		this.map_content = map_content;
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
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

	public String getMem_date() {
		return mem_date;
	}

	public void setMem_date(String mem_date) {
		this.mem_date = mem_date;
	}

	public int getOrd_num() {
		return ord_num;
	}

	public void setOrd_num(int ord_num) {
		this.ord_num = ord_num;
	}

	public int getOrd_price() {
		return ord_price;
	}

	public void setOrd_price(int ord_price) {
		this.ord_price = ord_price;
	}

	public char getOrd_map() {
		return ord_map;
	}

	public void setOrd_map(char ord_map) {
		this.ord_map = ord_map;
	}

	public String getOrd_etc() {
		return ord_etc;
	}

	public void setOrd_etc(String ord_etc) {
		this.ord_etc = ord_etc;
	}

	public char getOrd_pdata() {
		return ord_pdata;
	}

	public void setOrd_pdata(char ord_pdata) {
		this.ord_pdata = ord_pdata;
	}

	public int getQna_num() {
		return qna_num;
	}

	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}

	public String getQna_com() {
		return qna_com;
	}

	public void setQna_com(String qna_com) {
		this.qna_com = qna_com;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public int getQna_auth() {
		return qna_auth;
	}

	public void setQna_auth(int qna_auth) {
		this.qna_auth = qna_auth;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getQna_hit() {
		return qna_hit;
	}

	public void setQna_hit(int qna_hit) {
		this.qna_hit = qna_hit;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public String getReview_title() {
		return review_title;
	}

	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}

	public String getReview_con() {
		return review_con;
	}

	public void setReview_con(String review_con) {
		this.review_con = review_con;
	}

	public String getReview_com() {
		return review_com;
	}

	public void setReview_com(String review_com) {
		this.review_com = review_com;
	}
	
	public String getCar_number() {
		return car_number;
	}
	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}
	
	public void setCarp_num(int carp_num) {
		this.carp_num = carp_num;
	}
	public int getCarp_num() {
		return carp_num;
	}
	
	
	@Override
	public String toString() {
		return "SellcarVO [upload1=" + upload1 + ", upload2=" + upload2 + ", upload3=" + upload3 + ", upload4="
				+ upload4 + ", upload5=" + upload5 + ", upload6=" + upload6 + ", upload7=" + upload7 + ", upload8="
				+ upload8 + ", upload9=" + upload9 + ", upload10=" + upload10 + ", upload11=" + upload11 + ", upload12="
				+ upload12 + ", upload13=" + upload13 + ", upload14=" + upload14 + ", upload15=" + upload15
				+ ", upload16=" + upload16 + ", upload17=" + upload17 + ", filename1=" + filename1 + ", filename2="
				+ filename2 + ", filename3=" + filename3 + ", filename4=" + filename4 + ", filename5=" + filename5
				+ ", filename6=" + filename6 + ", filename7=" + filename7 + ", filename8=" + filename8 + ", filename9="
				+ filename9 + ", filename10=" + filename10 + ", filename11=" + filename11 + ", filename12=" + filename12
				+ ", filename13=" + filename13 + ", filename14=" + filename14 + ", filename15=" + filename15
				+ ", filename16=" + filename16 + ", filename17=" + filename17 + ", car_des=" + car_des + ", board_num="
				+ board_num + ", board_name=" + board_name + ", board_con=" + board_con + ", board_com=" + board_com
				+ ", board_auth=" + board_auth + ", mem_id=" + mem_id + ", reg_date=" + reg_date + ", secret_yn="
				+ secret_yn + ", mod_date=" + mod_date + ", ip=" + ip + ", car_num=" + car_num + ", mem_auth="
				+ mem_auth + ", car_name=" + car_name + ", car_cate1=" + car_cate1 + ", car_cate2=" + car_cate2
				+ ", car_cate3=" + car_cate3 + ", car_cate4=" + car_cate4 + ", car_cate5=" + car_cate5 + ", car_break="
				+ car_break + ", car_smoke=" + car_smoke + ", car_outcolor=" + car_outcolor + ", car_incolor="
				+ car_incolor + ", car_work=" + car_work + ", car_debt=" + car_debt + ", car_price=" + car_price
				+ ", comm_com=" + comm_com + ", fo_hit=" + fo_hit + ", fo_good=" + fo_good + ", fo_bad=" + fo_bad
				+ ", map_num=" + map_num + ", map_name=" + map_name + ", map_address=" + map_address + ", map_content="
				+ map_content + ", mem_num=" + mem_num + ", mem_name=" + mem_name + ", mem_pw=" + mem_pw + ", mem_cell="
				+ mem_cell + ", mem_email=" + mem_email + ", mem_zip=" + mem_zip + ", mem_addr=" + mem_addr
				+ ", mem_date=" + mem_date + ", ord_num=" + ord_num + ", ord_price=" + ord_price + ", ord_map="
				+ ord_map + ", ord_etc=" + ord_etc + ", ord_pdata=" + ord_pdata + ", qna_num=" + qna_num + ", qna_com="
				+ qna_com + ", qna_title=" + qna_title + ", qna_auth=" + qna_auth + ", answer=" + answer + ", qna_hit="
				+ qna_hit + ", review_num=" + review_num + ", review_title=" + review_title + ", review_con="
				+ review_con + ", review_com=" + review_com + ", car_number=" + car_number +", carp_num=" + carp_num +"]";
	}

	
	}
