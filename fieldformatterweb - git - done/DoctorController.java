package com.ffw.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffw.form.DoctorForm;
import com.ffw.validator.DoctorFormValidator;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorFormValidator doctorFormValidator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		System.out.println("initBinder()");
		// webDataBinder.addCustomFormatter(new EmailAddressFormatter(),
		// EmailAddress.class);
		webDataBinder.addValidators(doctorFormValidator);
	}

	@GetMapping("/new.htm")
	public String showAddDoctorForm(ModelMap modelMap) {
		DoctorForm doctorForm = null;

		System.out.println("showAddDoctorForm(ModelMap modelMap)");
		doctorForm = new DoctorForm();
		modelMap.put("doctorForm", doctorForm);
		return "add-doctor";
	}

	@PostMapping("/new.htm")
	public String addDoctor(@ModelAttribute("doctorForm") @Validated DoctorForm doctorForm, BindingResult errors,
			ModelMap model) {
		System.out.println(
				"addDoctor(@ModelAttribute(doctorForm) DoctorForm doctorForm, BindingResult errors, ModelMap model)");
		/*
		 * if (doctorFormValidator.supports(doctorForm.getClass())) {
		 * doctorFormValidator.validate(doctorForm, errors); }
		 */
		if (errors.hasErrors()) {
			return "add-doctor";
		}

		model.put("doctorNo", 1);
		model.put("emailAddress", doctorForm.getEmailAddress().toString());
		return "add-doctor-success";
	}

	@ModelAttribute("qualifications")
	public List<String> getQualifications() {
		System.out.println("getQualifications()");
		List<String> qualifications = Arrays
				.asList(new String[] { "MBBS", "Ortho", "Nuero", "DGM", "Gynic", "dentist" });

		return qualifications;
	}
}
