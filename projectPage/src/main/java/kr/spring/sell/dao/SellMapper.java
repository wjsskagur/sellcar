package kr.spring.sell.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.spring.sell.domain.SellcarVO;
  
public interface SellMapper {
	@Insert("INSERT INTO car (car_num,mem_id,car_name,car_cate1,car_cate2,car_cate3,car_cate4,car_cate5,car_break,car_smoke,car_outcolor,car_incolor,car_work,car_debt,car_price,mod_date,car_des,car_number) VALUES "
			+ "(sell_seq.nextval,#{mem_id},#{car_name},#{car_cate1},#{car_cate2},#{car_cate3},#{car_cate4},#{car_cate5},#{car_break},#{car_smoke},#{car_outcolor},#{car_incolor},#{car_work},#{car_debt},#{car_price},SYSDATE,#{car_des},#{car_number})")
	public void insert(SellcarVO sellcar);
	
	@Select("SELECT * FROM car c JOIN member m ON c.mem_id=m.mem_id JOIN carphoto p on c.car_num = p.car_num WHERE p.carp_num=#{carp_num}")
	public SellcarVO selectBoard(int carp_num);
}


