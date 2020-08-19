package kr.spring.sell.service;

import kr.spring.sell.domain.SellcarVO;

public interface SellService {
	public void insert(SellcarVO sellcar);
	public SellcarVO selectBoard(Integer carp_num);
}
