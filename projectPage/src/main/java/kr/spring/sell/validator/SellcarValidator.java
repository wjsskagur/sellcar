package kr.spring.sell.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.sell.domain.SellcarVO;

public class SellcarValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return SellcarVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SellcarVO sellcar = (SellcarVO)target;
		if(sellcar.getUpload1() == null || sellcar.getUpload1().isEmpty()) {
			errors.rejectValue("upload1", "required");
		}
		if(sellcar.getUpload2() == null || sellcar.getUpload2().isEmpty()) {
			errors.rejectValue("upload2", "required");
		}
		if(sellcar.getUpload3() == null || sellcar.getUpload3().isEmpty()) {
			errors.rejectValue("upload3", "required");
		}
		if(sellcar.getUpload6() == null || sellcar.getUpload6().isEmpty()) {
			errors.rejectValue("upload6", "required");
		}
		if(sellcar.getUpload7() == null || sellcar.getUpload7().isEmpty()) {
			errors.rejectValue("upload7", "required");
		}
		if(sellcar.getUpload8() == null || sellcar.getUpload8().isEmpty()) {
			errors.rejectValue("upload8", "required");
		}
		if(sellcar.getUpload12() == null || sellcar.getUpload12().isEmpty()) {
			errors.rejectValue("upload12", "required");
		}
		if(sellcar.getUpload13() == null || sellcar.getUpload13().isEmpty()) {
			errors.rejectValue("upload13", "required");
		}
		if(sellcar.getUpload14() == null || sellcar.getUpload14().isEmpty()) {
			errors.rejectValue("upload14", "required");
		}
		if(sellcar.getUpload15() == null || sellcar.getUpload15().isEmpty()) {
			errors.rejectValue("upload15", "required");
		}
		if(sellcar.getUpload16() == null || sellcar.getUpload16().isEmpty()) {
			errors.rejectValue("upload16", "required");
		}
		if(sellcar.getUpload17() == null || sellcar.getUpload17().isEmpty()) {
			errors.rejectValue("upload17", "required");
		}
		
	}

}
