package com.vogo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vogo.bo.BikeBo;
import com.vogo.bo.BikeSearchBo;
import com.vogo.dao.BikeDao;
import com.vogo.dto.BikeDto;
import com.vogo.form.BikeForm;
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

	@Transactional(readOnly = true)
	public BikeDto getBike(int bikeNo) {
		return mapBikeBoToBikeDto(bikeDao.getBike(bikeNo));
	}

	@Transactional(readOnly = false)
	public long addBike(BikeForm bikeForm) {
		long bikeNo = 0;
		BikeBo bikeBo = null;

		bikeBo = new BikeBo();
		bikeBo.setBikeModelName(bikeForm.getModelName());
		bikeBo.setManufacturer(bikeForm.getManufacturer());
		bikeBo.setRtaRegistrationNumber(bikeForm.getRtaRegistrationNo());
		bikeBo.setPrice(bikeForm.getPrice());

		bikeNo = bikeDao.saveBike(bikeBo);

		return bikeNo;
	}

	@Transactional(readOnly = false)
	public void updateBike(BikeForm bikeForm) {
		BikeBo bikeBo = null;

		bikeBo = new BikeBo();
		bikeBo.setBikeNo(bikeForm.getBikeNo());
		bikeBo.setBikeModelName(bikeForm.getModelName());
		bikeBo.setManufacturer(bikeForm.getManufacturer());
		bikeBo.setRtaRegistrationNumber(bikeForm.getRtaRegistrationNo());
		bikeBo.setPrice(bikeForm.getPrice());

		bikeDao.updateBike(bikeBo);
	}

	private BikeDto mapBikeBoToBikeDto(BikeBo bo) {
		BikeDto dto = new BikeDto();
		dto.setBikeNo(bo.getBikeNo());
		dto.setBikeModelName(bo.getBikeModelName());
		dto.setManufacturer(bo.getManufacturer());
		dto.setRtaRegistrationNo(bo.getRtaRegistrationNumber());
		dto.setPrice(bo.getPrice());
		return dto;
	}

}
