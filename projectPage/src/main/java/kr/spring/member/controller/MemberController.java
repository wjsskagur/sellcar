package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.member.domain.MemberVO;
import kr.spring.member.service.MemberService;
import kr.spring.util.AuthCheckException;

@Controller
public class MemberController {
	// 로그 대상 지정
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	// 자바빈 초기화
	@ModelAttribute
	public MemberVO initCommand() {
		
		return new MemberVO();
	}
	
	// 회원가입 전 이용약관 동의 페이지 호출
	@RequestMapping(value="/member/registerAgree.do", method=RequestMethod.GET)
	public String formRegisterAgree() {
		
		return "memberRegister";
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
				
				session.setAttribute("user_id", member.getMem_id());
				session.setAttribute("user_num", member.getMem_num());
				session.setAttribute("user_auth", member.getMem_auth());
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
}
