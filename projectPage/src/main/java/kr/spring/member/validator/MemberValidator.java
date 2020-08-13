package kr.spring.member.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.spring.member.domain.MemberVO;

public class MemberValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mem_id", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mem_cell", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mem_email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mem_zip", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mem_addr", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mem_addr2", "required");
	}

}
