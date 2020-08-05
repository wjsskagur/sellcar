package kr.spring.qa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.qa.dao.QaMapper;
import kr.spring.qa.domain.QaVO;

@Service("qaService")
public class QaServiceImpl implements QaService {
  
	@Resource
	private QaMapper qaMapper;
	
	@Override
	public List<QaVO> selectList(Map<String, Object> map) {

		return qaMapper.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		
		return qaMapper.selectRowCount(map);
	}

	@Override
	public void insert(QaVO qa) {
		qaMapper.insert(qa);
		
	}

	@Override
	public QaVO selectBoard(Integer num) {
	
		return qaMapper.selectBoard(num);
	}

	@Override
	public void updateHit(Integer num) {
		
		qaMapper.updateHit(num);
	}

	@Override
	public void update(QaVO qa) {
		
		qaMapper.update(qa);	
	}

	@Override
	public void delete(Integer num) {
		qaMapper.delete(num);
		
	}

}
