package org.yandex.service;

import org.yandex.dto.StreetDto;
import org.yandex.dto.StreetsDto;

import java.util.List;

public interface StreetService {

	StreetsDto getStreets(String cityName, String countryName);
}
