package kr.spring.sell.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.sell.dao.SellPhotoMapper;
import kr.spring.sell.domain.SellcarVO;

@Service("SellPhoto")
public class SellPhotoImpl implements SellPhoto{

	@Resource
	SellPhotoMapper sellPhoto;
	
	@Override
	public void insert(SellcarVO sellcar) {
		sellPhoto.insert(sellcar);
		
	}

}
