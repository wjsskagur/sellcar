package kr.spring.sell.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.spring.sell.domain.SellcarVO;

public class SellcarValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return SellcarVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "car_name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "car_price", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "car_break", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "car_num", "required");
		
	}

}
