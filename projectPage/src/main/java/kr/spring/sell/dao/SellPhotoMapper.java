package kr.spring.sell.dao;

import org.apache.ibatis.annotations.Insert;

import kr.spring.sell.domain.SellcarVO;

public interface SellPhotoMapper {
	@Insert("INSERT INTO (car_num,carp_num,car_mainimg,car_img1,car_img2,car_img3,car_img4,car_img5,car_img6,car_img7,car_img8,car_img9,car_img10,car_option,car_test,car_content,map_img,car_log,car_detail) VALUES "
			+ "(#{car_num},carp_seq.nextval,#{car_mainimg},#{car_img1},#{car_img2},#{car_img3},#{car_img4},#{car_img5},#{car_img6},#{car_img7},#{car_img8},#{car_img9},#{car_img10},#{car_option},#{car_test},#{car_content},#{map_img},#{car_log},#{car_detail}")
	public void insert(SellcarVO sellcar);
}
