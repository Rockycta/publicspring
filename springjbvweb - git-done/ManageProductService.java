package com.sjv.service;

import org.springframework.stereotype.Service;

import com.sjv.exception.ProductAlreadyExistsException;
import com.sjv.form.ProductForm;

@Service
public class ManageProductService {
	public int addProduct(ProductForm productForm) {

		if (productForm.getProductName().equals("LG Fridge")) {
			throw new ProductAlreadyExistsException();
		}
		return (int) Math.random();
	}
}
