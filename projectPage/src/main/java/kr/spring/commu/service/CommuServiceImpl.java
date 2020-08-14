package kr.spring.commu.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.commu.dao.CommuMapper;
import kr.spring.commu.domain.CommuVO;
@Service("cService")

public class CommuServiceImpl implements CommuService{
	
	@Resource
	private CommuMapper commuMapper;
	
	@Override
	public List<CommuVO> selectList(Map<String, Object> map) {
		
		return commuMapper.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commuMapper.selectRowCount(map);
	}

	@Override
	public void insert(CommuVO board) {
		commuMapper.insert(board);
		
	}

	@Override
	public CommuVO selectBoard(Integer board_num) {
		// TODO Auto-generated method stub
		return commuMapper.selectBoard(board_num);
	}

	@Override
	public void update(CommuVO board) {
		commuMapper.update(board);
		
	}

	@Override
	public void delete(Integer board_num) {
		commuMapper.delete(board_num);
		
	}

	@Override
	public void updateHit(Integer board_num) {
		commuMapper.updateHit(board_num);
		
	}

}
