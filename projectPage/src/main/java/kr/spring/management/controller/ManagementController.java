package kr.spring.management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.management.service.ManagementService;
import kr.spring.member.domain.MemberVO;
import kr.spring.util.PagingUtil;

@Controller
public class ManagementController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private ManagementService managementService;
	
	// 자바빈(VO) 초기화
	@ModelAttribute
	public MemberVO initCommand() {
		
		return new MemberVO();
	}
	
	// 회원목록
	@RequestMapping("/management/member.do")
	public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1") int currentPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int count = managementService.selectRowCount();
		
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "member.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<MemberVO> list = null;
		if(count > 0) {
			list = managementService.selectList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("managementMember");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
	// 회원 삭제
	@RequestMapping(value="/management/memberclear.do",method=RequestMethod.GET)
	public ModelAndView process(@RequestParam("mem_id") String mem_id) {
		if(log.isDebugEnabled()) {
			log.debug("<<mem_id>> : " + mem_id);
		}
		
		MemberVO member = managementService.selectMember(mem_id);
		member.setMem_id(mem_id);
		
		return new ModelAndView("memberclear", "member", member);
	}
	
	@RequestMapping(value="/management/memberclear.do",method=RequestMethod.POST)
	public String submitdelete(@RequestParam("mem_num") int mem_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<~~~~~~~~~~~~mem_num>> : " + mem_num);
		}
		
		managementService.clear(mem_num); 
		
		
		return "redirect:/management/member.do";
	}
	@RequestMapping(value="/management/memberLevel.do",method=RequestMethod.GET)
	public ModelAndView memlevel(@RequestParam("mem_id") String mem_id) {		
		
		MemberVO member = managementService.selectMember(mem_id);
		member.setMem_id(mem_id);
		
		
		return new ModelAndView("memberLevel", "member", member);
	}
	@RequestMapping(value="/management/memberLevel.do",method=RequestMethod.POST)
	public String submitlevel(@RequestParam("mem_auth")int mem_auth,@RequestParam("mem_num") int mem_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<mem_num>> : " + mem_num);
		}
		managementService.level(mem_auth,mem_num);
		
		return "redirect:/management/member.do";
	}
}
