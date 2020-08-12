package kr.spring.carre.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.carre.dao.CarreMapper;
import kr.spring.carre.domain.CarreVO;

@Service("carreService")
public class CarreServiceImpl implements CarreService {
  
	@Resource
	private CarreMapper carreMapper;
	
	@Override
	public List<CarreVO> selectList(Map<String, Object> map) {

		return carreMapper.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		
		return carreMapper.selectRowCount(map);
	}

	@Override
	public void insert(CarreVO carre) {
		carreMapper.insert(carre);
		
	}

	@Override
	public CarreVO selectBoard(Integer num) {
	
		return carreMapper.selectBoard(num);
	}

	@Override
	public void updateHit(Integer num) {
		
		carreMapper.updateHit(num);
	}

	@Override
	public void update(CarreVO carre) {
		
		carreMapper.update(carre);	
	}

	@Override
	public void delete(Integer num) {
		carreMapper.delete(num);
		
	}

}