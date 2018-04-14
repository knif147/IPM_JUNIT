package com.ou.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ou.entity.Position;
import com.ou.services.PositionService;

@Component
public class PositionValidator implements Validator {
	@Autowired
	PositionService positionService;
	
	
	public boolean supports(Class<?> cls) {
		return Position.class.isAssignableFrom(cls);
	}

	
	public void validate(Object o, Errors errors) {
		Position position = (Position) o;

		// Unique name
		Position dbPosition = positionService.findByName(position.getName());
		if (dbPosition != null && dbPosition.getId() != position.getId()) {
			errors.rejectValue("name", "Unique.position.name");
		}
	}

}
