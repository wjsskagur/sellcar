package kr.spring.sell.service;

import java.util.List;
import java.util.Map;

import kr.spring.sell.domain.SellPhotoVO;
import kr.spring.sell.domain.SellcarVO;

public interface SellPhoto {
	public List<SellcarVO> selectList(Map<String,Object> map);
	public List<SellcarVO> selectCar(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insert(SellcarVO sellcar);
	public SellcarVO selectBoard(int carp_num);
	public List<SellcarVO> selectPhoto(int car_num);
}
