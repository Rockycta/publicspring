package com.vogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vogo.dto.BikeDto;
import com.vogo.form.BikeForm;
import com.vogo.form.BikeSearchForm;
import com.vogo.service.ManageBikeService;
import com.vogo.validator.BikeFormValidator;

@Controller
@RequestMapping("/bike")
public class BikeController {
	@Autowired
	private ManageBikeService bikeService;

	@Autowired
	private BikeFormValidator bikeFormValidator;

	@GetMapping("/list.htm")
	public String showBikes(ModelMap modelMap) {
		List<BikeDto> bikes = null;

		bikes = bikeService.getBikes();
		modelMap.addAttribute("bikes", bikes);

		return "bikes";
	}

	@PostMapping("/doSearchBikes.htm")
	public String doSearchBikes(@ModelAttribute("bikeSearchForm") BikeSearchForm bikeSearchForm, BindingResult errors,
			Model model) {
		List<BikeDto> bikes = null;

		if (errors.hasErrors()) {
			return "search-bikes";
		}

		bikes = bikeService.searchBikes(bikeSearchForm);
		model.addAttribute("bikes", bikes);

		return "bike-search-results";
	}

	@GetMapping("/{bikeNo}/details.htm")
	public String showBikeDetails(@PathVariable("bikeNo") String bikeNo, ModelMap modelMap) {
		BikeDto bikeDto = null;

		bikeDto = bikeService.getBike(Integer.parseInt(bikeNo));
		modelMap.addAttribute("bike", bikeDto);

		return "bike-details";
	}

	@GetMapping("/new.htm")
	public String showAddBikeForm(ModelMap modelMap) {
		BikeForm bikeForm = new BikeForm();
		modelMap.addAttribute("bikeForm", bikeForm);
		return "add-bike";
	}

	@PostMapping("/new.htm")
	public String addBike(@ModelAttribute("bikeForm") BikeForm bikeForm, BindingResult errors, ModelMap modelMap) {
		long bikeNo = 0;
		if (bikeFormValidator.supports(bikeForm.getClass())) {
			bikeFormValidator.validate(bikeForm, errors);
			if (errors.hasErrors()) {
				return "add-bike";
			}
		}
		// invoke service
		bikeNo = bikeService.addBike(bikeForm);
		modelMap.put("bikeNo", bikeNo);

		return "add-bike-success";
	}

	@GetMapping("/edit.htm")
	public String editBike(@RequestParam("bikeNo") String bikeNo, ModelMap modelMap) {
		BikeDto bikeDto = null;
		BikeForm bikeForm = null;

		bikeDto = bikeService.getBike(Integer.parseInt(bikeNo));
		bikeForm = new BikeForm();
		bikeForm.setBikeNo(bikeDto.getBikeNo());
		bikeForm.setModelName(bikeDto.getBikeModelName());
		bikeForm.setManufacturer(bikeDto.getManufacturer());
		bikeForm.setPrice(bikeDto.getPrice());
		bikeForm.setRtaRegistrationNo(bikeDto.getRtaRegistrationNo());

		modelMap.put("editBikeForm", bikeForm);

		return "edit-bike";
	}

	@PostMapping("/edit.htm")
	public String updateBike(@ModelAttribute("editBikeForm") BikeForm bikeForm, BindingResult errors,
			ModelMap modelMap) {
		if (bikeFormValidator.supports(bikeForm.getClass())) {
			bikeFormValidator.validate(bikeForm, errors);
			if (errors.hasErrors()) {
				return "edit-bike";
			}
		}
		bikeService.updateBike(bikeForm);
		modelMap.put("bikeNo", bikeForm.getBikeNo());
		
		return "edit-bike-success";
	}
}
