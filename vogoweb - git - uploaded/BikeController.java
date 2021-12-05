package com.vogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vogo.dto.BikeDto;
import com.vogo.form.BikeSearchForm;
import com.vogo.service.ManageBikeService;

@Controller
@RequestMapping("/bike")
public class BikeController {
	@Autowired
	private ManageBikeService bikeService;

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

}
