package kr.spring.sell.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.sell.dao.SellPhotoMapper;
import kr.spring.sell.domain.SellPhotoVO;
import kr.spring.sell.domain.SellcarVO;

@Service("SellPhoto")
public class SellPhotoImpl implements SellPhoto{

	@Resource
	SellPhotoMapper sellPhoto;
	
	@Override
	public void insert(SellcarVO sellcar) {
		sellPhoto.insert(sellcar);
		
	}

	@Override
	public SellcarVO selectBoard(int carp_num) {
		return sellPhoto.selectBoard(carp_num);
	}

	@Override
	public List<SellcarVO> selectList(Map<String, Object> map) {
		return sellPhoto.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return sellPhoto.selectRowCount(map);
	}

	@Override
	public List<SellcarVO> selectPhoto(int car_num) {
		return sellPhoto.selectPhoto(car_num);
	}

	@Override
	public List<SellcarVO> selectCar(Map<String, Object> map) {
		return sellPhoto.selectCar(map);
	}
	
	

}
