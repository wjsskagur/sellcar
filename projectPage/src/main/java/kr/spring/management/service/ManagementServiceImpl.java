package kr.spring.management.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.management.dao.ManagementMapper;
import kr.spring.member.domain.MemberVO;

@Service("managementService")
public class ManagementServiceImpl implements ManagementService {
	@Resource
	private ManagementMapper managementMapper;
	
	@Override
	public List<MemberVO> selectList(Map<String, Object> map) {
		
		return managementMapper.selectList(map);
	}

	@Override
	public int selectRowCount() {
		
		return managementMapper.selectRowCount();
	}

	@Override
	public MemberVO selectMember(String mem_id) {
		
		return managementMapper.selectMember(mem_id);
	}
	
}
