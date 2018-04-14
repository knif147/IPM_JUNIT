package com.ou.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ou.entity.Recruitment;
import com.ou.services.RecruitmentService;

@Component
public class RecruitmentValidator implements Validator {
	@Autowired
	RecruitmentService recruitmentService;

	
	public boolean supports(Class<?> cls) {
		return Recruitment.class.isAssignableFrom(cls);
	}

	
	public void validate(Object o, Errors errors) {
		Recruitment recruitment = (Recruitment) o;
		
		//Unique name
		Recruitment dbRecruitment = recruitmentService.findByName(recruitment.getName());
		if (dbRecruitment != null && dbRecruitment.getId() != recruitment.getId()) {
			errors.rejectValue("name", "Unique.recruitment.name");
		}
	}

}
