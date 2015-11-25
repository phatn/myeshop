package com.myeshop.web.validator;

import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.myeshop.web.entity.CustomerForm;

/**
 *  
 * @author Phat Nguyen
 * Customer validator adapter
 * 
 */

public class CustomerValidator implements Validator {

	@Inject
	@Qualifier("validator")
	private javax.validation.Validator beanValidator;
	
	private Set<Validator> springValidators;
	
	public CustomerValidator() {
		this.springValidators = new HashSet<Validator>();
	}
	
	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return CustomerForm.class.isAssignableFrom(clazz);
	}
	

	@Override
	public void validate(Object target, Errors errors) {
		
		Set<ConstraintViolation<Object>> constraintViolations = beanValidator.validate(target);
		for(ConstraintViolation<Object> constraintViolation : constraintViolations) {
			String propertyPath = constraintViolation.getPropertyPath().toString();
			String message = constraintViolation.getMessage();
			errors.rejectValue(propertyPath, "", message);
		}
		
		for(Validator validator : springValidators) {
			validator.validate(target, errors);
		}
		
	}
	
}
