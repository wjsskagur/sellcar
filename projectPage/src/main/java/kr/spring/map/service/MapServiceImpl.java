package kr.spring.map.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import kr.spring.map.dao.MapMapper;
import kr.spring.map.domain.MapleadVO;


@Service("mapService")
public class MapServiceImpl implements MapService{
 
	@Resource 
	private MapMapper mapDAO;

	@Override
	public List<MapleadVO> mapList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapDAO.mapList(map);
	}

	@Override
	public int selectMapCount() {
		// TODO Auto-generated method stub
		return mapDAO.selectMapCount();
	}

	@Override
	public void insert(MapleadVO maplead) {
		// TODO Auto-generated method stub
		mapDAO.insert(maplead);
	}

	@Override
	public MapleadVO selectMap(Integer map_num) {
		// TODO Auto-generated method stub
		return mapDAO.selectMap(map_num);
	}

	@Override
	public void updateMap(MapleadVO mapload) {
		mapDAO.updateMap(mapload);
		
	}

	@Override
	public void deleteMap(Integer map_num) {
		mapDAO.deleteMap(map_num);
	}

	
	
}
