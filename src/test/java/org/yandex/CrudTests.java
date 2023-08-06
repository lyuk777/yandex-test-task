package org.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.yandex.entity.City;
import org.yandex.entity.Country;
import org.yandex.entity.Street;
import org.yandex.mapper.CityMapper;
import org.yandex.mapper.CountryMapper;
import org.yandex.mapper.StreetMapper;

import java.util.Optional;

@SpringBootTest
class CrudTests {

	@Autowired
	private StreetMapper streetMapper;

	@Autowired
	private CityMapper cityMapper;

	@Autowired
	private CountryMapper countryMapper;

	@Test
	void crudTest() {
		Country country = new Country().setName("Норвегия");
		countryMapper.save(country);
		Optional<Country> savedCountry = countryMapper.findByName("Норвегия");
		Assertions.assertTrue(savedCountry.isPresent());

		City city = new City().setName("Осло").setCountry(savedCountry.get());
		cityMapper.save(city);
		Optional<City> savedCity = cityMapper.findByName("Осло");
		Assertions.assertTrue(savedCity.isPresent());
		Assertions.assertEquals(savedCity.get().getCountry().getName(), "Норвегия");

		Street street = new Street().setName("Улица").setCity(savedCity.get());
		streetMapper.save(street);
		Optional<Street> savedStreet = streetMapper.findByName("Улица");
		Assertions.assertTrue(savedStreet.isPresent());
		Assertions.assertEquals(savedStreet.get().getCity().getName(), "Осло");

		streetMapper.delete(savedStreet.get());
		Assertions.assertNull(streetMapper.findByName("Улица").orElse(null));

		cityMapper.update(savedCity.get().setName("Осло2"));
		Optional<City> updatedCity = cityMapper.findById(savedCity.get().getId());
		Assertions.assertTrue(updatedCity.isPresent());
		Assertions.assertEquals(updatedCity.get().getName(), "Осло2");

	}

}
