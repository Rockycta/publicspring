package com.sjv.controller.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sjv.exception.ProductAlreadyExistsException;

@ControllerAdvice
public class GlobalExceptionHandler {
	/*
	 * @ExceptionHandler public String
	 * handleProductAlreadyExistsException(ProductAlreadyExistsException e, Model
	 * model) { model.addAttribute("errorMessage", "Product already found"); return
	 * "error"; }
	 */
}
