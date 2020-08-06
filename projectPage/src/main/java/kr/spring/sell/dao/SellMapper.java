package kr.spring.sell.dao;

import org.apache.ibatis.annotations.Insert;

import kr.spring.sell.domain.SellcarVO;
  
public interface SellMapper {
	@Insert("INSERT INTO car (car_num,mem_id,car_name,car_cate1,car_cate2,car_cate3,car_cate4,car_cate5,car_break,car_smoke,car_outcolor,car_incolor,car_work,car_debt,car_price,mod_date,car_des,car_number) VALUES "
			+ "(sell_seq.nextval,#{mem_id},#{car_name},#{car_cate1},#{car_cate2},#{car_cate3},#{car_cate4},#{car_cate5},#{car_break},#{car_smoke},#{car_outcolor},#{car_incolor},#{car_work},#{car_debt},#{car_price},SYSDATE,#{car_des},#{car_number})")
	public void insert(SellcarVO sellcar);
}


