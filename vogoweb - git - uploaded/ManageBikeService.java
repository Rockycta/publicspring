package com.vogo.service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vogo.bo.BikeBo;
import com.vogo.bo.BikeSearchBo;
import com.vogo.dao.BikeDao;
import com.vogo.dto.BikeDto;
import com.vogo.form.BikeSearchForm;

@Service
public class ManageBikeService {
	@Autowired
	private BikeDao bikeDao;

	@Transactional(readOnly = true)
	public List<BikeDto> getBikes() {
		return bikeDao.getBikes().stream().map((bo) -> {
			return mapBikeBoToBikeDto(bo);
		}).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<BikeDto> searchBikes(BikeSearchForm bikeSearchForm) {
		BikeSearchBo bikeSearchBo = null;

		bikeSearchBo = new BikeSearchBo();
		BeanUtils.copyProperties(bikeSearchForm, bikeSearchBo);
		return bikeDao.searchBikes(bikeSearchBo).stream().map((bo) -> {
			return mapBikeBoToBikeDto(bo);
		}).collect(Collectors.toList());
	}

	private BikeDto mapBikeBoToBikeDto(BikeBo bo) {
		BikeDto dto = new BikeDto();
		dto.setBikeNo(bo.getBikeNo());
		dto.setBikeModelName(bo.getBikeModelName());
		dto.setManufacturer(bo.getManufacturer());
		dto.setPrice(bo.getPrice());
		return dto;
	}
	
	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		System.out.println(locale);
	}
}
