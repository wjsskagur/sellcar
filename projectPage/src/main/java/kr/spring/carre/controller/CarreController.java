package kr.spring.carre.controller;

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

import kr.spring.carre.domain.CarreVO;
import kr.spring.carre.service.CarreService;
import kr.spring.util.PagingUtil;

//안녕하세요
@Controller
public class CarreController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private CarreService carreService;
	
	//자바빈(VO) 초기화
	@ModelAttribute
	public CarreVO initCommand() {
		return new CarreVO();
	}
	//목록
	@RequestMapping("/carre/carrelist.do")
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
		int count = carreService.selectRowCount(map);

		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		
		//페이징 처리
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<CarreVO> list = null;
		if(count > 0) {
			list = carreService.selectList(map);
		}
				
		ModelAndView mav = new ModelAndView();
		mav.setViewName("carrelist");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());

		return mav;
	}
	//글쓰기
	@RequestMapping(value="/carre/carrewrite.do",method=RequestMethod.GET)
	public String form() {
		return "carrewrite";
	}
	//글쓰기 처리
	@RequestMapping(value="/carre/carrewrite.do",method=RequestMethod.POST)
	public String submit(@Valid CarreVO carreVO,BindingResult result,HttpServletRequest request,HttpSession session) {

		if(log.isDebugEnabled()) {
			log.debug("<<CarreVO>> : " + carreVO);
		}
		//유효성체크 결과 에러가 있으면 폼을 호출
		if(result.hasErrors()) {
			return "carrewrite";
		}
		//mem_num 반환
		carreVO.setMem_num((Integer)session.getAttribute("user_num"));
		//ip
		carreVO.setIp(request.getRemoteAddr());
		//글등록
		carreService.insert(carreVO);

		return "redirect:/carre/carrelist.do";
	}
	//글 상세
	@RequestMapping("/carre/detail.do")
	public ModelAndView process(@RequestParam("num") int num) {

		//로그표시
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
		}

		//조회수 증가
		carreService.updateHit(num);

		CarreVO carre = carreService.selectBoard(num);


		//뷰 이름		,속성명     , 속성값
		return new ModelAndView("carreview","carre", carre);
	}
	//파일 다운로드
	@RequestMapping("/carre/file.do")
	public ModelAndView download(@RequestParam("num") int num) {

		CarreVO carre = carreService.selectBoard(num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("downloadView");
		//파일 정보 
		mav.addObject("downloadFile", carre.getUploadfile());
		mav.addObject("filename", carre.getFilename());

		return mav;
	}
	
	//이미지 처리
	@RequestMapping("/carre/imageView.do")
	public ModelAndView viewImage(@RequestParam("num") int num) {

		CarreVO carre = carreService.selectBoard(num);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile", carre.getUploadfile());
		mav.addObject("filename", carre.getFilename());
			
		return mav;
	}
	//글수정 폼
	@RequestMapping(value="/carre/update.do",method=RequestMethod.GET)
	public String form(@RequestParam("num") int num, Model model) {
			
		CarreVO carreVO = carreService.selectBoard(num);
		model.addAttribute("carreVO", carreVO);
			
			
		return "carreModify";
	}
	//글수정 처리
	@RequestMapping(value="/carre/update.do",method=RequestMethod.POST)
	public String submitUpdate(@Valid CarreVO carreVO, BindingResult result,HttpServletRequest request) {
			
		//로그표시
		if(log.isDebugEnabled()) {
			log.debug("<<CarreVO>> : " + carreVO);
		}
		//유효성체크결과 에러가 있으면 폼 호출
		if(result.hasErrors()) {
			return "carremodify";
		}
		carreVO.setIp(request.getRemoteAddr());
		
		carreService.update(carreVO);
		
		return "redirect:/carre/carrelist.do";
	}
	//글 삭제 
	@RequestMapping("/carre/delete.do")
	public String submit(@RequestParam("num") int num) {
			
		//로그표시
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
		}
			
		//글삭제
		carreService.delete(num);
			
		return "redirect:/carre/carrelist.do";
	}
}	