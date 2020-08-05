package kr.spring.map.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.spring.map.domain.MapleadVO;


public interface MapMapper {
	public List<MapleadVO> mapList(Map<String,Object> map);
	public int selectMapCount();
	@Insert("INSERT INTO map (map_num,map_name,map_address,map_content,reg_date,mod_date) VALUES (board_seq.nextval,#{map_name},#{map_address},#{map_content},SYSDATE,SYSDATE")
	public void insert(MapleadVO maplead);
	@Select("SELECT * FROM map WHERE map_num=#{map_num}")
	public MapleadVO selectMap(Integer num);
	public void updateMap(MapleadVO mapload);
	@Delete("DELETE FROM spboard WHERE map_num=#{map_num}")
	public void deleteMap(Integer num); 
} 
