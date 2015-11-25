package com.myeshop.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.myeshop.web.entity.CustomerForm;

@Component
public class ConfirmPasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CustomerForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//ValidationUtils.rejectIfEmpty(errors, "password", "NotEmpty.customer.password");
		//ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "NotEmpty.customer.confirmPassword");
		CustomerForm form = (CustomerForm)target;
		if(!form.getPassword().equals(form.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "password.customer.notmatch");
		}
	}
}
