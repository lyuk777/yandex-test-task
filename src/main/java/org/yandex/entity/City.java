package org.yandex.entity;

import lombok.Data;

@Data
public class City {

	private Long id;

	private String name;

	private Country country;

}
