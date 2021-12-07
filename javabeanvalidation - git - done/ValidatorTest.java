package com.jbv.test;

import java.util.Set;

import com.jbv.bean.Address;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidatorTest {
	public static void main(String[] args) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Address address = new Address();
		address.setStreetAddress("Court Street");
		
		Set<ConstraintViolation<Address>> constraintViolations = validator.validate(address);
		for (ConstraintViolation<Address> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation.getPropertyPath().toString());
			System.out.println(constraintViolation.getConstraintDescriptor().getAnnotation());
			System.out.println(constraintViolation.getMessage());
		}
	}
}
