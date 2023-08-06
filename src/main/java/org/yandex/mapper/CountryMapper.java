package org.yandex.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.yandex.entity.Country;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CountryMapper {

	List<Country> findAll();

	Optional<Country> findById(Long id);

	Optional<Country> findByName(String name);

	void save(Country country);

	void delete(Country country);

	void update(Country country);
}
