package kr.spring.carre.service;

import java.util.List;
import java.util.Map;

import kr.spring.carre.domain.CarreVO;
  
public interface CarreService {
	public List<CarreVO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insert(CarreVO qa);
	public CarreVO selectBoard(Integer num);
	public void updateHit(Integer num);
	public void update(CarreVO qa);
	public void delete(Integer num);
}
