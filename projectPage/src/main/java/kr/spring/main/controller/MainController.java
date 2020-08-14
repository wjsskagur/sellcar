package kr.spring.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.sell.domain.SellcarVO;
import kr.spring.sell.service.SellPhoto;
import kr.spring.util.PagingUtil;

/* 메인  컨트롤러 */
@Controller
public class MainController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 100;
	private int pageCount = 100;
	
	//파일 업로드 경로 읽기
	@Value("${file_path}")
	private String path;
	@Resource
	private SellPhoto sellPhoto;
	
	@RequestMapping("/main/main.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1")int currentPage,
			@RequestParam(value="keyfield",defaultValue="")String keyfield,
			@RequestParam(value="keyword",defaultValue="")String keyword){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		int count = sellPhoto.selectRowCount(map);
		if(log.isDebugEnabled()) {
			log.debug("<<Count>> : "+ count);
		}
		//페이징처리
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"main.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<SellcarVO> list =null;
		if(count>0) {
			list = sellPhoto.selectList(map);
		}
		/*List<SellcarVO> photo = null;
		if(count>0) {
			photo = sellPhoto.selectPhoto(car_num);
		}*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("count",count);
		mav.addObject("list",list);
		//mav.addObject("photo",photo);
		mav.addObject("pagingHtml",page.getPagingHtml());
		
		return mav;
		/*SellcarVO photo = new SellcarVO();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("photo",photo);
		
		return mav;
		}*/
		}
	@RequestMapping("/main/imageView.do")
	public ModelAndView viewImage(@RequestParam("carp_num")int carp_num) {
		SellcarVO sellcar = sellPhoto.selectBoard(carp_num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile",sellcar.getCar_mainimg());
		mav.addObject("filename","photo.jpg");
		
		return mav;}
	
	@RequestMapping("/board/carreview.do")
	public String carReview() {
		return "carreview";
	}
	@RequestMapping("/board/board.do")
	public String community() {
		return "board";
	}
	@RequestMapping("/board/generic.do")
	public String form() {
		return "generic";
	}
	@RequestMapping("/board/center.do")
	public String center() {
		return "center";
	}
	@RequestMapping("/search/search.do")
	public String search() {
		return "search";
	}
	@RequestMapping("/search/searchList.do")
	public String searchform() {
		return "searchList";
	}
	@RequestMapping("/board/generic_1.do")
	public String form1() {
		return "generic_1";
	}
	@RequestMapping("/board/generic_2.do")
	public String form2() {
		return "generic_2";
	}
	@RequestMapping("/board/generic_3.do")
	public String form3() {
		return "generic_3";
	}
	@RequestMapping("/board/generic_4.do")
	public String form4() {
		return "generic_4";
	}
	@RequestMapping("/board/generic_5.do")
	public String form5() {
		return "generic_5";
	}
}
