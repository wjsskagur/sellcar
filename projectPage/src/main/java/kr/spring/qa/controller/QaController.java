package kr.spring.qa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.qa.domain.QaVO;
import kr.spring.qa.domain.ReplyVO;
import kr.spring.qa.service.QaService;
import kr.spring.util.PagingUtil;

//안녕하세요
@Controller
public class QaController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private QaService qaService;
	
	//자바빈(VO) 초기화
	@ModelAttribute
	public QaVO initCommand() {
		return new QaVO();
	}
	//목록
	@RequestMapping("/qa/list.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1")
	int currentPage,
	@RequestParam(value="keyfield",defaultValue="")
	String keyfield,
	@RequestParam(value="keyword",defaultValue="")
	String keyword) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//게시판의 총 레코드수 또는 검색 레코드 수 반환
		int count = qaService.selectRowCount(map);
				
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		
		//페이징 처리
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<QaVO> list = null;
		if(count > 0) {
			list = qaService.selectList(map);
		}
				
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qaList");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());

		return mav;
	}
	//글쓰기
	@RequestMapping(value="/qa/write.do",method=RequestMethod.GET)
	public String form() {
		return "qaWrite";
	}
	//글쓰기 처리
	@RequestMapping(value="/qa/write.do",method=RequestMethod.POST)
	public String submit(@Valid QaVO qaVO,BindingResult result,HttpServletRequest request,HttpSession session) {

		if(log.isDebugEnabled()) {
			log.debug("<<QaVO>> : " + qaVO);
		}
		//유효성체크 결과 에러가 있으면 폼을 호출
		if(result.hasErrors()) {
			return "qaWrite";
		}
		//mem_num 반환
		qaVO.setMem_num((Integer)session.getAttribute("user_num"));
		//ip
		qaVO.setIp(request.getRemoteAddr());
		//글등록
		qaService.insert(qaVO);

		return "redirect:/qa/list.do";
	}
	//글 상세
	@RequestMapping("/qa/detail.do")
	public ModelAndView process(@RequestParam("num") int num) {

		//로그표시
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
		}

		//조회수 증가
		qaService.updateHit(num);
				
		//댓글 목록 가져오기
		QaVO qa = qaService.selectBoard(num);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("bno", num);
		List<ReplyVO> reply = qaService.readReply(paramMap);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qaView");
		mav.addObject("qa",qa);
		mav.addObject("reply",reply);
		
		if(log.isDebugEnabled()) {
			log.debug("<<reply>> : " + reply);
		}
		
		//뷰 이름		,속성명     , 속성값
		//return new ModelAndView("qaView","qa", qa);
		return mav;
	}
	//파일 다운로드
	@RequestMapping("/qa/file.do")
	public ModelAndView download(@RequestParam("num") int num) {

		QaVO qa = qaService.selectBoard(num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("downloadView");
		//파일 정보 
		mav.addObject("downloadFile", qa.getUploadfile());
		mav.addObject("filename", qa.getFilename());

		return mav;
	}
	
	//이미지 처리
	@RequestMapping("/qa/imageView.do")
	public ModelAndView viewImage(@RequestParam("num") int num) {

		QaVO qa = qaService.selectBoard(num);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile", qa.getUploadfile());
		mav.addObject("filename", qa.getFilename());
			
		return mav;
	}
	//글수정 폼
	@RequestMapping(value="/qa/update.do",method=RequestMethod.GET)
	public String form(@RequestParam("num") int num, Model model) {
			
		QaVO qaVO = qaService.selectBoard(num);
		model.addAttribute("qaVO", qaVO);
			
			
		return "qaModify";
	}
	//글수정 처리
	@RequestMapping(value="/qa/update.do",method=RequestMethod.POST)
	public String submitUpdate(@Valid QaVO qaVO, BindingResult result,HttpServletRequest request) {
			
		//로그표시
		if(log.isDebugEnabled()) {
			log.debug("<<QaVO>> : " + qaVO);
		}
		//유효성체크결과 에러가 있으면 폼 호출
		if(result.hasErrors()) {
			return "qaModify";
		}
		qaVO.setIp(request.getRemoteAddr());
		
		qaService.update(qaVO);
		
		return "redirect:/qa/list.do";
	}
	//글 삭제 
	@RequestMapping("/qa/delete.do")
	public String submit(@RequestParam("num") int num) {
			
		//로그표시
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
		}
			
		//글삭제
		qaService.delete(num);
			
		return "redirect:/qa/list.do";
	}
}	