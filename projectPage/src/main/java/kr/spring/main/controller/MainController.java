package kr.spring.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/* 메인  컨트롤러 */
@Controller
public class MainController {
	@RequestMapping("/main/main.do")
	public ModelAndView process() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav; 
	}
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
