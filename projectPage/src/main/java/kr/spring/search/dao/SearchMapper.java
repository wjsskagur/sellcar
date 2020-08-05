package kr.spring.search.dao;

import java.util.List;
import java.util.Map;

import kr.spring.search.domain.Search;


public interface SearchMapper {
	
	public int selectCount();
	public List<Search> selectList(Map<String,Object> map);
} 
