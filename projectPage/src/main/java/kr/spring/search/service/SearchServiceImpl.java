package kr.spring.search.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import kr.spring.search.dao.SearchMapper;
import kr.spring.search.domain.Search;

@Service("searchService")
public class SearchServiceImpl implements SearchService{
 
	@Resource 
	private SearchMapper searchDAO;
	
 
	@Override
	public int selectCount() {
		
		return searchDAO.selectCount();
	}

	@Override
	public List<Search> selectList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return searchDAO.selectList(map);
	}

}
