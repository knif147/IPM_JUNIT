package com.ou.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ou.entity.Major;
import com.ou.services.MajorService;

@Component
public class MajorValidator implements Validator {
	@Autowired
	MajorService majorService;

	
	public boolean supports(Class<?> cls) {
		return Major.class.isAssignableFrom(cls);
	}

	
	public void validate(Object o, Errors errors) {
		Major major = (Major) o;

		// Unique name
		Major dbMajor = majorService.findByName(major.getName());
		if (dbMajor != null && dbMajor.getId() != major.getId()) {
			errors.rejectValue("name", "Unique.major.name");
		}
	}

}
