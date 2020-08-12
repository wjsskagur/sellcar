package kr.spring.carre.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.carre.domain.CarreVO;

public interface CarreMapper {
	public List<CarreVO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	@Insert("INSERT INTO carreboard (num,title,content,uploadfile,filename,ip,mem_num) VALUES (board_seq.nextval,#{title},#{content},#{uploadfile},#{filename},#{ip},#{mem_num})")
	public void insert(CarreVO qa);
	@Select("SELECT * FROM carreboard b JOIN member m ON b.mem_num=m.mem_num WHERE b.num=#{num}")
	public CarreVO selectBoard(Integer num);
	@Update("UPDATE carreboard SET hit=hit+1 WHERE num=#{num}")
	public void updateHit(Integer num);
	public void update(CarreVO qa);
	@Delete("DELETE FROM carreboard WHERE num=#{num}")
	public void delete(Integer num);
}