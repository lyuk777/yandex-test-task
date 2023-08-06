package org.yandex.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.yandex.entity.City;
import org.yandex.entity.Country;
import org.yandex.entity.Street;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StreetMapper {

	List<Street> findAll();

	List<Street> findAllByCityAndCountry(Country country, City city);

	Optional<Street> findByName(String name);

	Optional<Street> findById(Long id);

	void save(Street street);

	void delete(Street street);

	void update(Street street);

}
