package org.yandex.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yandex.entity.City;
import org.yandex.entity.Street;

@Setter
@Getter
@NoArgsConstructor
public class StreetDto {

	private String streetName;

	private String cityName;

	private String countryName;

	public StreetDto(Street street) {
		this.streetName = street.getName();
		City city = street.getCity();
		this.cityName = city.getName();
		this.countryName = city.getCountry().getName();
	}
}
