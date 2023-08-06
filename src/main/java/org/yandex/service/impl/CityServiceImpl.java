package org.yandex.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yandex.entity.City;
import org.yandex.exception.ResourceNotFoundException;
import org.yandex.mapper.CityMapper;
import org.yandex.service.CityService;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

	private final CityMapper cityMapper;

	@Override
	public City getCityByName(String name) {
		return cityMapper.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Город не найден"));
	}
}
