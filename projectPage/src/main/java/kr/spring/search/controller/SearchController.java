package kr.spring.search.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.search.domain.Search;
import kr.spring.search.service.SearchService;
import kr.spring.util.PagingUtil;


@Controller
public class SearchController {
	
	@Resource
	private SearchService searchService;
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("/search/searchMain.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="car_name",defaultValue="") String car_name,
			@RequestParam(value="car_make",defaultValue="") String car_make,
			@RequestParam(value="car_keyword",defaultValue="") String car_keyword
			) {

		//회원정보 총 개수
		int count = searchService.selectCount();

		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		//페이징 처리
		PagingUtil page = new PagingUtil(currentPage, count, 10, 10, "list.do","&car_name="+car_name+"&car_make="+car_make);

		List<Search> list = null;
		if(count > 0) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("car_name", car_name);
			map.put("car_make", car_make);
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
 
			list = searchService.selectList(map);
		}

		ModelAndView mav = new ModelAndView();
			mav.setViewName("search");
			mav.addObject("count",count);
			mav.addObject("list",list);
			mav.addObject("pagingHtml",page.getPagingHtml());
			
		return mav;
	}
	@ModelAttribute
	public Search initCommand() {
		return new Search();
	}
	@RequestMapping("/search/searchgo.do")
	public String searchgo() {
		return "searchgo";
	}
}
