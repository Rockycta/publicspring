package com.sjv.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sjv.exception.ProductAlreadyExistsException;
import com.sjv.form.ProductForm;
import com.sjv.service.ManageProductService;
import com.sjv.validator.ProductFormValidator;

@Controller
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	private ProductFormValidator productFormValidator;

	@Autowired
	private ManageProductService manageProductService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) 
	{
		webDataBinder.addValidators(productFormValidator);
	}

	@GetMapping("/new.htm")
	public String showAddProductForm(ModelMap model) 
	{
		model.put("productForm", new ProductForm());
		return "add-product";
	}

	@PostMapping("/new.htm")
	public String addProduct(@ModelAttribute("productForm") @Valid ProductForm productForm, BindingResult errors, ModelMap model) 
	{
		if (errors.hasErrors()) {
			return "add-product";
		}
		manageProductService.addProduct(productForm);
		model.put("productName", productForm.getProductName());
		return "add-product-success";
	}
}
