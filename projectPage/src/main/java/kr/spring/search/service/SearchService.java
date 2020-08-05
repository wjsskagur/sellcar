package kr.spring.search.service;


import java.util.List;
import java.util.Map;

import kr.spring.search.domain.Search;
 
public interface SearchService {
		public int selectCount(); 
		public List<Search> selectList(Map<String,Object> map);
	}

