/*package kr.spring.sell.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.sell.domain.SellPhotoVO;
import kr.spring.sell.service.SellPhoto;
import kr.spring.sell.service.SellService;

public class SellPhotoController {
	private Logger log = Logger.getLogger(this.getClass());
	@Value("${file_path}")
	private String path;
	@Resource
	private SellPhoto sellPhoto;
	@Resource
	private SellService sellService;
	
	@ModelAttribute
	public SellPhotoVO initCommand() {
		return new SellPhotoVO();
	}
	
	//내차사진등록
		@RequestMapping(value="/sell/sellphoto.do",method=RequestMethod.GET)
		public String cphoto(@RequestParam int car_num,Model model) {
			
			model.addAttribute("car_num", car_num);
			
			return "sellphoto";
			
		}
		//내차사진등록처리
		@RequestMapping(value="/sell/sellPhoto.do",method=RequestMethod.POST)
		public String CarPhoto(@Valid SellPhotoVO sellphoto,BindingResult result,HttpServletRequest request,HttpSession session) {
			
			
			if(log.isDebugEnabled()) {
				log.debug("<<sellphotoVO>> : "+sellphoto);
			}
			//new SellcarValidator().validate(sellcar, result);
			if(result.hasErrors()) {
				return "sellphoto";
			}
			
			//글등록
			sellPhoto.insert(sellphoto);
			
			return "redirect:/main/main.do";
			
		}	

}
*/