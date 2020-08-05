package kr.spring.map.service;


import java.util.List;
import java.util.Map;

import kr.spring.map.domain.MapleadVO;
 
public interface MapService {
	public List<MapleadVO> mapList(Map<String,Object> map);
	public int selectMapCount();
	public void insert(MapleadVO maplead);
	public MapleadVO selectMap(Integer map_num);
	public void updateMap(MapleadVO mapload);
	public void deleteMap(Integer map_num); 
	}

