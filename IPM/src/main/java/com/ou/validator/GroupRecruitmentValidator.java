package com.ou.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ou.entity.GroupRecruitment;
import com.ou.services.GroupRecruitmentService;

@Component
public class GroupRecruitmentValidator implements Validator {
	@Autowired
	GroupRecruitmentService groupRecruitmentService;

	
	public boolean supports(Class<?> cls) {
		return GroupRecruitment.class.isAssignableFrom(cls);
	}

	
	public void validate(Object o, Errors errors) {
		GroupRecruitment groupRecruitment = (GroupRecruitment) o;

		// Unique name
		GroupRecruitment dbGroupRecruitment = groupRecruitmentService.findByName(groupRecruitment.getName());
		if (dbGroupRecruitment != null && dbGroupRecruitment.getId() != groupRecruitment.getId()) {
			errors.rejectValue("name", "Unique.groupRecruitment.name");
		}
	}

}
