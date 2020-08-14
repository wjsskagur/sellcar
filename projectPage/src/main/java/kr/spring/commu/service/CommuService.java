package kr.spring.commu.service;

import java.util.List;
import java.util.Map;

import kr.spring.commu.domain.CommuVO;

public interface CommuService {
	public List<CommuVO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insert(CommuVO board);
	public CommuVO selectBoard(Integer board_num);
	public void updateHit(Integer board_num);
	public void update(CommuVO board);
	public void delete(Integer board_num);
}
