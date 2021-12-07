package com.sjv.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sjv.form.ProductForm;

@Component
public class ProductFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ProductForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductForm productForm = null;

		productForm = (ProductForm) target;

		if (errors.hasFieldErrors("productName") == false) {
			// make a database call to see whether productName is already taken or not
			if (productForm.getProductName().equals("LG Aircondition")) {
				errors.rejectValue("productName", "productName.notAvailable");
			}
		}
	}

}
