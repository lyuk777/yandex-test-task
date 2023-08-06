package org.yandex.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yandex.dto.StreetDto;
import org.yandex.dto.StreetsDto;
import org.yandex.entity.Country;
import org.yandex.mapper.CityMapper;
import org.yandex.mapper.CountryMapper;
import org.yandex.mapper.StreetMapper;
import org.yandex.service.StreetService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StreetController {

	private final StreetService streetService;

	@GetMapping("/streets")
	public StreetsDto getCountries(@RequestParam(required = false) String cityName, @RequestParam(required = false) String countryName) {
		return streetService.getStreets(cityName, countryName);
	}
}
