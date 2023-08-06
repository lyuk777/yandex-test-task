package org.yandex.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yandex.dto.StreetDto;
import org.yandex.dto.StreetsDto;
import org.yandex.entity.City;
import org.yandex.entity.Country;
import org.yandex.mapper.StreetMapper;
import org.yandex.service.CityService;
import org.yandex.service.CountryService;
import org.yandex.service.StreetService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StreetServiceImpl implements StreetService {

	private final StreetMapper streetMapper;

	private final CountryService countryService;

	private final CityService cityService;

	public StreetsDto getStreets(String cityName, String countryName) {
		City city = Optional.ofNullable(cityName)
				.map(cityService::getCityByName)
				.orElse(null);
		Country country = Optional.ofNullable(countryName)
				.map(countryService::getCountryByName)
				.orElse(null);
		List<StreetDto> streets = streetMapper.findAllByCityAndCountry(country, city)
				.stream()
				.map(StreetDto::new)
				.collect(Collectors.toList());
		return new StreetsDto().setStreets(streets);
	}
}
