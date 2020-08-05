package kr.spring.sell.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.sell.domain.SellcarVO;

public class FileValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return SellcarVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SellcarVO vo = (SellcarVO)target;
		if(vo.getUpload1() == null || vo.getUpload1().isEmpty()) {
			errors.rejectValue("File", "required");
		}
		
	}

}
