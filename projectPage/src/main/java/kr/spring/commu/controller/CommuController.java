package kr.spring.commu.controller;

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

import kr.spring.commu.domain.CommuVO;
import kr.spring.commu.service.CommuService;
import kr.spring.util.PagingUtil;

@Controller
public class CommuController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;

	@Resource
	private CommuService cService;

	@ModelAttribute
	public CommuVO initCommand() {
		return new CommuVO();
	}
	//목록
	@RequestMapping("/commu/community.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1")int currentPage,
			@RequestParam(value="keyfield",defaultValue="")String keyfield,
			@RequestParam(value="keyword",defaultValue="")String keyword,
			HttpSession session) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		map.put("board_num", (Integer)session.getAttribute("board_num"));

		int count = cService.selectRowCount(map);
		if(log.isDebugEnabled()) {
			log.debug("<<Count>> : "+ count);
		}
		//페이징처리
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"community.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<CommuVO> list =null;
		if(count>0) {
			list = cService.selectList(map);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("community");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());

		return mav;
	}

	//글쓰기
	@RequestMapping(value="/commu/write.do",method=RequestMethod.GET)
	public String form() {
		return "write";
	}
	//글쓰기 처리
	@RequestMapping(value="/commu/write.do",method=RequestMethod.POST)
	public String submit(@Valid CommuVO commuVO,BindingResult result,HttpServletRequest request,HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("<<commuVO>> : "+commuVO);
		}
		if(result.hasErrors()) {
			return "write";
		}
		//mem_num
		commuVO.setMem_id((String)session.getAttribute("user_id"));
		//ip반환
		commuVO.setIp(request.getRemoteAddr());
		//글등록
		cService.insert(commuVO);


		return "redirect:/commu/community.do";
	}
	//글상세
	@RequestMapping("/commu/detail.do")
	public ModelAndView process(@RequestParam("board_num") int board_num,Model model) {
		if(log.isDebugEnabled()) {
			log.debug("<<board_num>> : "+board_num);
		}
		//model.addAttribute("board_num", board_num);
		//조회수 증가
		cService.updateHit(board_num);

		CommuVO board = cService.selectBoard(board_num);

		//뷰이름          속성명        속성값
		return new ModelAndView("detail","board",board);
	}



	//글수정폼호출
	@RequestMapping(value="/commu/modify.do",method=RequestMethod.GET)
	public String form(@RequestParam int board_num,Model model) {
		CommuVO commuVO = cService.selectBoard(board_num);
		model.addAttribute("commuVO",commuVO);
		//model.addAttribute("board_num", board_num);
		return "modify";
	}
	//글수정 처리
	@RequestMapping(value="/commu/modify.do",method=RequestMethod.POST)
	public String submitUpdate(@Valid CommuVO commuVO,BindingResult result,HttpServletRequest request) {
		//로그 표시
		if(log.isDebugEnabled()) {
			log.debug("<<CommuVO>> : "+commuVO);
		}
		//유효성체크 결과 에러가 있으면 폼 호출
		if(result.hasErrors()) {
			return "modify";
		}
		commuVO.setIp(request.getRemoteAddr());

		cService.update(commuVO);

		return "redirect:/commu/community.do";
	}
	//파일 다운로드
		@RequestMapping("/commu/file.do")
		public ModelAndView download(@RequestParam("board_num")int board_num) {
			CommuVO board = cService.selectBoard(board_num);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("downloadView");
			//파일정보
			mav.addObject("downloadFile",board.getBoard_img());
			mav.addObject("filename",board.getBoard_filename());
			
			
			return mav;
		}
	//이미지 처리
		@RequestMapping("/commu/imageView.do")
		public ModelAndView viewImage(@RequestParam("board_num")int board_num) {
			CommuVO board = cService.selectBoard(board_num);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("imageView");
			mav.addObject("imageFile",board.getBoard_img());
			mav.addObject("filename",board.getBoard_filename());
			
			return mav;
		}
		// 글 삭제
		@RequestMapping("/commu/delete.do")
		public String submit(@RequestParam("board_num")int board_num) {
			//로그표시
			if(log.isDebugEnabled()) {
				log.debug("<<log>> : "+board_num);
			}
			//글삭제
			cService.delete(board_num);
			
			return "redirect:/commu/community.do";
		}
}
