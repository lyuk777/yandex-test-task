package org.yandex.entity;

import lombok.Data;

@Data
public class Street {

	private Long id;

	private String name;

	private City city;

}
