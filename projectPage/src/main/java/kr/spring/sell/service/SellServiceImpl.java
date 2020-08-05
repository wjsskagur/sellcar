package kr.spring.sell.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.sell.dao.SellMapper;
import kr.spring.sell.domain.SellcarVO;

@Service("sellService")
public class SellServiceImpl implements SellService{
  
	@Resource
	private SellMapper sellMapper;
	
	@Override
	public void insert(SellcarVO sellcar) {
		sellMapper.insert(sellcar);
	}
}
