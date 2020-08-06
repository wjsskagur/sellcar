package kr.spring.sell.controller;

/*import java.io.File;
import java.io.IOException;*/

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.sell.domain.SellcarVO;
import kr.spring.sell.service.SellService;
//import kr.spring.sell.validator.FileValidator;

@Controller
public class SellController {
	private Logger log = Logger.getLogger(this.getClass());

	//파일 업로드 경로 읽기
	@Value("${file_path}")
	private String path;

	@Resource
	private SellService sellService;

	
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
		//mem_id
		sellcar.setMem_id((String)session.getAttribute("user_id"));
		//ip반환
		sellcar.setIp(request.getRemoteAddr());
		//글등록
		sellService.insert(sellcar);

		return "redirect:/sell/sellphoto.do";
	}	

	/*@PostMapping
	public String file(@ModelAttribute("file")SellcarVO vo,BindingResult result) throws IllegalStateException, IOException {

		//유효성 체크
		new FileValidator().validate(vo, result);

		//유효성 체크 결과 에러가 있으면 폼 호출
		if(result.hasErrors()) {
			return Sellmy();
		}
		//파일 업로드 처리
		//업로드 경로에 파일을 저장
		File file = new File(path + "/" + vo.file().getOriginalFilename());
		vo.getReportFile().transferTo(file);

		return "sell.do";
	}
*/
}
