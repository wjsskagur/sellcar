package kr.spring.sell.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*import java.io.File;
import java.io.IOException;*/

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.sell.domain.SellPhotoVO;
import kr.spring.sell.domain.SellcarVO;
import kr.spring.sell.service.SellPhoto;
import kr.spring.sell.service.SellService;
import kr.spring.sell.validator.SellcarValidator;
//import kr.spring.sell.validator.FileValidator;
import kr.spring.util.PagingUtil;

@Controller
public class SellController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	//파일 업로드 경로 읽기
	@Value("${file_path}")
	private String path;

	@Resource
	private SellService sellService;
	@Resource
	private SellPhoto sellPhoto;
	
	@ModelAttribute
	public SellcarVO initCommand() {
		return new SellcarVO();
	}
	
	//내차팔기
	@RequestMapping(value="/sell/sell.do",method=RequestMethod.GET)
	public String Sellmy() {
		return "sell";
	}
	//내차팔기처리
	@RequestMapping(value="/sell/sell.do",method=RequestMethod.POST)
	public String sellmyCar(@Valid SellcarVO sellcar,BindingResult result,HttpServletRequest request,HttpSession session) {

		if(log.isDebugEnabled()) {
			log.debug("<<sellcarVO>> : "+sellcar);
		}
		if(result.hasErrors()) {
			return "sell";
		}
		session.setAttribute("car_num", sellcar.getCar_num());
		//mem_id
		sellcar.setMem_id((String)session.getAttribute("user_id"));
		//ip반환
		sellcar.setIp(request.getRemoteAddr());
		//글등록
		sellService.insert(sellcar);

		return "redirect:/sell/sellview.do";
	}
	
	
	//목록
			@RequestMapping("/sell/sellview.do")
			public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1")int currentPage,
										@RequestParam(value="keyfield",defaultValue="")String keyfield,
										@RequestParam(value="keyword",defaultValue="")String keyword) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("keyfield", keyfield);
			map.put("keyword", keyword);
			
			int count = sellPhoto.selectRowCount(map);
			if(log.isDebugEnabled()) {
				log.debug("<<Count>> : "+ count);
			}
			//페이징처리
			PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"sellview.do");
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			
			List<SellcarVO> list =null;
			if(count>0) {
				list = sellPhoto.selectList(map);
			}
			ModelAndView mav = new ModelAndView();
			mav.setViewName("sellview");
			mav.addObject("count",count);
			mav.addObject("list",list);
			mav.addObject("pagingHtml",page.getPagingHtml());
			
			return mav;
			}
	//내차사진등록
	@RequestMapping(value="/sell/sellphoto.do",method=RequestMethod.GET)
	public String cphoto(@RequestParam int car_num,Model model) {
		
		model.addAttribute("car_num", car_num);
		
		return "sellphoto";
		
	}
	//내차사진등록처리
	@RequestMapping(value="/sell/sellphoto.do",method=RequestMethod.POST)
	public String CarPhoto(SellcarVO sellcar,BindingResult result,HttpServletRequest request,HttpSession session) {
		
		
		if(log.isDebugEnabled()) {
			log.debug("<<sellcarVO>> : "+sellcar);
		}
		
		new SellcarValidator().validate(sellcar, result);
		
		if(result.hasErrors()) {
			return "sellerror";
		}
		//ip반환
		sellcar.setIp(request.getRemoteAddr());
		//글등록
		sellPhoto.insert(sellcar);
		
		return "redirect:/main/main.do";
		
	}
	@RequestMapping("/sell/sellerror.do")
	public String SellErr() {
		
		return "sellerror";
	}

	
}
