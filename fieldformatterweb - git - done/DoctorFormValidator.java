package com.ffw.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ffw.form.DoctorForm;

@Component
public class DoctorFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(DoctorForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DoctorForm doctorForm = null;

		doctorForm = (DoctorForm) target;
		if (doctorForm.getDoctorName() == null || doctorForm.getDoctorName().trim().length() == 0) {
			errors.rejectValue("doctorName", "doctorName.blank");
		}
		if (errors.hasFieldErrors("emailAddress") == false) {
			if (doctorForm.getEmailAddress() == null) {
				errors.rejectValue("emailAddress", "emailAddress.blank");
			}
		}
		if (doctorForm.getQualification() == null || doctorForm.getQualification().trim().length() == 0) {
			errors.rejectValue("qualification", "qualification.blank");
		}
	}

}
