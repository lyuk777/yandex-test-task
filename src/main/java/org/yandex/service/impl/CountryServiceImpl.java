package org.yandex.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yandex.entity.Country;
import org.yandex.exception.ResourceNotFoundException;
import org.yandex.mapper.CountryMapper;
import org.yandex.service.CountryService;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

	private final CountryMapper countryMapper;

	@Override
	public Country getCountryByName(String name) {
		return countryMapper.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Страна не найдена"));
	}
}
