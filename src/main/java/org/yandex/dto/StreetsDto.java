package org.yandex.dto;

import lombok.Data;
import org.yandex.entity.City;
import org.yandex.entity.Street;

import java.util.List;

@Data
public class StreetsDto {

	private List<StreetDto> streets;

}
