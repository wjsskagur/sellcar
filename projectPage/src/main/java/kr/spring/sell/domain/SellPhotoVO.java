package kr.spring.sell.domain;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class SellPhotoVO {
	private int carp_num;
	private int car_num;
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
	public int getCarp_num() {
		return carp_num;
	}
	public void setCarp_num(int carp_num) {
		this.carp_num = carp_num;
	}
	public int getCar_num() {
		return car_num;
	}
	public void setCar_num(int car_num) {
		this.car_num = car_num;
	}
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
	public String getFilename17() {
		return filename17;
	}
	public void setFilename17(String filename17) {
		this.filename17 = filename17;
	}
	@Override
	public String toString() {
		return "SellPhotoVO [upload1=" + upload1 + ", upload2=" + upload2 + ", upload3=" + upload3 + ", upload4="
				+ upload4 + ", upload5=" + upload5 + ", upload6=" + upload6 + ", upload7=" + upload7 + ", upload8="
				+ upload8 + ", upload9=" + upload9 + ", upload10=" + upload10 + ", upload11=" + upload11 + ", upload12="
				+ upload12 + ", upload13=" + upload13 + ", upload14=" + upload14 + ", upload15=" + upload15
				+ ", upload16=" + upload16 + ", upload17=" + upload17 + ", filename1=" + filename1 + ", filename2="
				+ filename2 + ", filename3=" + filename3 + ", filename4=" + filename4 + ", filename5=" + filename5
				+ ", filename6=" + filename6 + ", filename7=" + filename7 + ", filename8=" + filename8 + ", filename9="
				+ filename9 + ", filename10=" + filename10 + ", filename11=" + filename11 + ", filename12=" + filename12
				+ ", filename13=" + filename13 + ", filename14=" + filename14 + ", filename15=" + filename15
				+ ", filename16=" + filename16 + ", filename17=" + filename17 + "]";
	}
	
	
}
