package kr.spring.management.controller;

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
	
	// 회원 상세목록
	@RequestMapping("/management/memberView.do")
	public ModelAndView process(@RequestParam("mem_id") String mem_id) {
		if(log.isDebugEnabled()) {
			log.debug("<<mem_id>> : " + mem_id);
		}
		
		MemberVO member = managementService.selectMember(mem_id);
		
		return new ModelAndView("managementMemberView", "member", member);
	}
}
