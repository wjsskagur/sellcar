package kr.spring.sell.dao;

import org.apache.ibatis.annotations.Insert;

import kr.spring.sell.domain.SellcarVO;
  
public interface SellMapper {
	@Insert("INSERT INTO car (car_num,mem_id,car_name,car_cate1,car_cate2,car_cate3,car_cate4,car_cate5,car_break,car_smoke,car_outcolor,car_incolor,car_work,car_debt,car_mainimg,car_img1,car_img2,car_img3,car_img4,car_img5,car_img6,car_img7,car_img8,car_img9,car_img10,car_option,car_test,car_content,map_img,car_price,car_log,mod_date,car_detail,car_des) VALUES "
			+ "(#{car_num},#{mem_id},#{car_name},#{car_cate1},#{car_cate2},#{car_cate3},#{car_cate4},#{car_cate5},#{car_break},#{car_smoke},#{car_outcolor},#{car_incolor},#{car_work},#{car_debt},#{car_mainimg},#{car_img1},#{car_img2},#{car_img3},#{car_img4},#{car_img5},#{car_img6},#{car_img7},#{car_img8},#{car_img9},#{car_img10},#{car_option},#{car_test},#{car_content},#{map_img},#{car_price},#{car_log},#{mod_date},#{car_detail},#{car_des})")
	public void insert(SellcarVO sellcar);
}


