package org.yandex.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.yandex.entity.City;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CityMapper {

	List<City> findAll();

	Optional<City> findById(Long id);

	Optional<City> findByName(String name);

	void save(City city);

	void delete(City city);

	void update(City city);
}
