package kr.spring.map.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.map.domain.MapleadVO;
import kr.spring.map.service.MapService;

@Controller
public class MapController {
		@Resource
		private MapService mapService;
	
	
		//글쓰기
		@RequestMapping(value="/board/write.do",method=RequestMethod.GET)
		public String form() {
			return"boardWrite";
		}
		
		//글쓰기 처리
		@RequestMapping(value="/board/write.do",method=RequestMethod.POST)
		public String submit(@Valid MapleadVO mapleadVO, BindingResult result, HttpServletRequest request, HttpSession session) {
			
			//유효성 체크 결과 에러가 있으면 폼 호출
			if(result.hasErrors()) {
				return "boardWrite";
			}
			
			//mem_num 반환
			mapleadVO.setMap_num((Integer)session.getAttribute("user_num"));
			mapleadVO.getMod_date();
			//글 등록
			mapService.insert(mapleadVO);
			
			return "redirect:/board/list.do";
		}
		
		//글 상세
		@RequestMapping("/board/detail.do")
		public ModelAndView process(@RequestParam("map_num") int map_num) {
			
			
					
			MapleadVO maplead = mapService.selectMap(map_num);
			
									//뷰 이름		   속성명	    속성값
			return new ModelAndView("MapView", "maplead", maplead);
		}
		
		//글 수정 폼 호출
		@RequestMapping(value="/board/update.do",method=RequestMethod.GET)
		public String form(@RequestParam("map_num") int map_num, Model model) {
			
			MapleadVO mapleadVO = mapService.selectMap(map_num);
			
			model.addAttribute("MapleadVO", mapleadVO);
			
			return "mapModify";
		}
		
		//글 수정 처리
		@RequestMapping(value="/board/update.do",method=RequestMethod.POST)
		public String submitUpdate(@Valid MapleadVO mapleadVO, BindingResult result, HttpServletRequest request) {
			
			//유효성 체크 결과 에러가 있으면 폼 호출
			if(result.hasErrors()) {
				return "boardModify";
			}
			mapleadVO.getMod_date();
			
			mapService.updateMap(mapleadVO);
			
			return "redirect:/board/list.do";
		}
		
		//글 삭제
		@RequestMapping("/board/delete.do")
		public String delete(@RequestParam("map_num") int map_num) {
			
			//글 삭제
			mapService.deleteMap(map_num);
			
			return "redirect:/board/list.do";
		}
}
