package kr.spring.member.controller;

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


import kr.spring.member.domain.MemberVO;
import kr.spring.member.service.MemberService;
import kr.spring.member.validator.MemberValidator;
import kr.spring.sell.service.SellPhoto;
import kr.spring.util.AuthCheckException;
 
@Controller
public class MemberController {
	// 로그 대상 지정
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@Resource
	private SellPhoto sellPhoto;
	
	// 자바빈 초기화
	@ModelAttribute
	public MemberVO initCommand() {
		
		return new MemberVO();
	}
	//1
	// 회원가입 전 이용약관 동의 페이지 호출
	@RequestMapping(value="/member/registerAgree.do", method=RequestMethod.GET)
	public String formRegisterAgree() {
		
		return "memberRegister";
	}
	@RequestMapping("/member/myPage.do")
	public String myPage(MemberVO memberVO, BindingResult result, HttpSession session,HttpServletRequest request) {
		
		return "myPage";
}
	// 약관동의 체크 여부 확인 후 회원가입 폼 호출
	@RequestMapping(value="/member/register.do", method=RequestMethod.GET)
	public String formRegister() {
		
		return "memberRegisterForm";
	}
	
	// 회원가입
	@RequestMapping(value="/member/register.do", method=RequestMethod.POST)
	public String submitRegister(@Valid MemberVO memberVO, BindingResult result) {
		// 로그 표시
		if(log.isDebugEnabled()) {
			log.debug("<<memberVO>> : " + memberVO);
		}
		
		// 유효성 체크 결과 에러가 있으면 폼 호출
		if(result.hasErrors()) {
			return formRegister();
		}
		
		// 회원가입
		memberService.insert(memberVO);
		
		return "redirect:/main/main.do";
	}
	
	// 로그인 폼 호출
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public String formLogin() {
		
		return "memberLogin";
	}
	
	// 로그인
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String submitLogin(MemberVO memberVO, BindingResult result, HttpSession session) {
		// 로그 표시
		if(log.isDebugEnabled()) {
			log.debug("<<MemberVO>> : " + memberVO);
		}
		//아이디와 비밀번호 체크결과 에러가 있으면 폼을 호출
				if(result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
					return formLogin();
				}
		try {
			MemberVO member = memberService.selectCheckMember(memberVO.getMem_id());
			boolean check = false;
			
			if(member != null) {
				// 비밀번호 체크
				check = member.isCheckedPasswd(memberVO.getMem_pw());
			}
			
			// 비밀번호 인증 성공
			if(check) {
				member.count = 1;
				
				session.setAttribute("user", member);
				session.setAttribute("user_id", member.getMem_id());
				session.setAttribute("user_num", member.getMem_num());
				session.setAttribute("user_auth", member.getMem_auth());
				session.setAttribute("user_name", member.getMem_name());
				session.setAttribute("user_cell", member.getMem_cell());
				session.setAttribute("user_email", member.getMem_email());
				session.setAttribute("user_addr", member.getMem_addr());
				session.setAttribute("user_addr2", member.getMem_addr2());
				if(log.isDebugEnabled()) {
					log.debug("==로그인 성공==");
					log.debug("<<user_id>> : " + member.getMem_id());
					log.debug("<<user_auth>> : " + member.getMem_auth());
				}
				return "redirect:/main/main.do";
			} else {
				member.count = 0;
				
				session.setAttribute("count", member.count);
				// 로그인 실패
				throw new AuthCheckException();
			}

		} catch(AuthCheckException e) {
			// 로그인 실패시 에러 코드를 지정하고 폼을 호출함
			result.reject("invalidIdOrPassword");
			
			return formLogin();
		}
	}
	
	// 로그아웃
	@RequestMapping("/member/logout.do")
	public String processLogout(HttpSession session) {
		// 로그아웃 처리
		session.invalidate();
		
		return "redirect:/main/main.do";
	}
	
	// 아이디 찾기 폼 호출
	@RequestMapping(value="/member/findId.do", method=RequestMethod.GET)
	public String formFindId() {
		
		return "memberFindId";
	}
	
	@RequestMapping(value="/member/findId.do", method=RequestMethod.POST)
	public String submitFindId(MemberVO memberVO, BindingResult result, HttpSession session) {
		// 로그 표시
		if(log.isDebugEnabled()) {
			log.debug("<<MemberVO>> : " + memberVO);
		}
		String mem_id = null;
		
		MemberVO member = memberService.findMemberId(memberVO.getMem_name(), memberVO.getMem_cell());

		if(member != null) {
			String id = member.getMem_id();
			mem_id = id.substring(0, 4);
			
			for(int i = 0; i < id.substring(4).length(); i++) {
				mem_id += "*";
			}
			
			session.setAttribute("mem_name", member.getMem_name());
			session.setAttribute("mem_id", mem_id);
		} else {
			session.setAttribute("message", "님은 본 사이트에 회원으로 등록되어 있지 않습니다.");
		}

		return "memberFindIdCheck";
	}
	
	@RequestMapping(value="/member/update.do",method=RequestMethod.GET)
	public String formUpdate(HttpSession session, Model model) {
		int mem_num = (Integer)session.getAttribute("user_num");
		
		MemberVO memberVO = memberService.selectMember(mem_num);
		//속성명		속성값
		model.addAttribute("memberVO", memberVO);

		return "update";
	}

	@RequestMapping(value="/member/update.do",method=RequestMethod.POST)
	public String submitUpdate(@Valid MemberVO memberVO, BindingResult result,HttpSession session) {
		
		//유효성 체크
		new MemberValidator().validate(memberVO, result);
		

				if(result.hasFieldErrors("mem_name") ||
				   result.hasFieldErrors("mem_cell") ||
				   result.hasFieldErrors("mem_email") ||
				   result.hasFieldErrors("mem_zip") ||
				   result.hasFieldErrors("mem_addr") ||
				   result.hasFieldErrors("mem_addr2")) {
					return "myPage";
				}
		//회원 정보 수정
		memberService.updateMember(memberVO);

		return "redirect:/member/myPage.do";
	}
	
	@RequestMapping(value="/member/changePassword.do",method=RequestMethod.GET)
	public String formChangePassword(HttpSession session, Model model) {
		//세션에 저장되어 있는 mem_num 반환
		int mem_num = (Integer)session.getAttribute("user_num");
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_num(mem_num);
		model.addAttribute("memberVO", memberVO);
		
		return "memberChangePassword";
	}
	
	//비밀번호 변경 처리
	@RequestMapping(value="/member/changePassword.do",method=RequestMethod.POST)
	public String submitChangePassword(@Valid MemberVO memberVO, BindingResult result) {
		//로그 표시
		if(log.isDebugEnabled()) {
			log.debug("<<MemberVO>> : " + memberVO);
		}
		
		//유효성 체크
		if(result.hasFieldErrors("mem_pw")) {
			return "memberChangePassword";
		}
		
		//비밀번호 인증
		MemberVO member = memberService.selectMember(memberVO.getMem_num());
		if(!member.getMem_pw().equals(memberVO.getOld_pw())) {
			result.rejectValue("old_pw", "invalidPassword");
			
			return "memberChangePassword";
		}
		
		//비밀번호 변경
		memberService.updatePassword(memberVO);
		
		
		return "redirect:/member/myPage.do";
	}
	
	//회원탈퇴 폼
		@RequestMapping(value="/member/delete.do",method=RequestMethod.GET)
		public String formDelete(HttpSession session, Model model) {
			int mem_num = (Integer)session.getAttribute("user_num");
			MemberVO memberVO = new MemberVO();
			memberVO.setMem_num(mem_num);
			
			model.addAttribute("memberVO", memberVO);
			
			return "memberDelete";
		}
		
	
	//회원 탈퇴 처리
		@RequestMapping(value="/member/delete.do",method=RequestMethod.POST)
		public String submitDelete(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {
			//로그 표시
			if(log.isDebugEnabled()) {
				log.debug("<<MemberVO>> : " + memberVO);
			}
			
			//비밀번호만 유효성 체크, 유효성 체크 결과 에러가 있으면 폼 호출
			if(result.hasFieldErrors("mem_pw")) {
				return "memberDelete";
			} 
			
			//비밀번호 인증
			try {
				MemberVO member = memberService.selectMember(memberVO.getMem_num());
				boolean check = false;
				
				if(member!=null) {
					//비밀번호 인증
					check = member.isCheckedPasswd(memberVO.getMem_pw());
				} 
				
				if(check) {
					//비밀번호 인증 성공
					//회원탈퇴
					memberService.delete(memberVO.getMem_num());
					//로그아웃
					session.invalidate();
					
					return "redirect:/main/main.do";
				}else {
					//비밀번호 인증 실패
					throw new AuthCheckException();
				}
				
			}catch(AuthCheckException e) {
				//비밀번호 인증 실패시 에러 코드 지정하고 폼 호출
				result.rejectValue("mem_pw", "invalidPassword");
				
				return "memberDelete";
			}
		}
	
}
