package kr.spring.qa.service;

import java.util.List;
import java.util.Map;

import kr.spring.qa.domain.QaVO;
import kr.spring.qa.domain.ReplyVO;
  
public interface QaService {
	public List<QaVO> selectList(Map<String,Object> map);
	public List<ReplyVO> readReply(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insert(QaVO qa);
	public QaVO selectBoard(Integer num);
	public void updateHit(Integer num);
	public void update(QaVO qa);
	public void delete(Integer num);
}
