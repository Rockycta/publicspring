package com.vogo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.vogo.form.BikeForm;

@Component
public class BikeFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == BikeForm.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		BikeForm bikeForm = null;

		bikeForm = (BikeForm) target;
		if (bikeForm.getModelName() == null || bikeForm.getModelName().trim().length() == 0) {
			errors.rejectValue("modelName", "modelName.blank");
		}
		if (bikeForm.getManufacturer() == null || bikeForm.getManufacturer().trim().length() == 0) {
			errors.rejectValue("manufacturer", "manufacturer.blank");
		}
		if (bikeForm.getRtaRegistrationNo() == null || bikeForm.getRtaRegistrationNo().trim().length() == 0) {
			errors.rejectValue("rtaRegistrationNo", "rtaRegistrationNo.blank");
		} else if (bikeForm.getRtaRegistrationNo().length() != 10) {
			errors.rejectValue("rtaRegistrationNo", "rtaRegistrationNo.invalid");

		}
		//abc
		
		// no binding errors are there for price
		if (errors.hasFieldErrors("price") == false) {
			if (bikeForm.getPrice() <= 0) {
				errors.rejectValue("price", "price.invalid");
			}
		}
	}

}
