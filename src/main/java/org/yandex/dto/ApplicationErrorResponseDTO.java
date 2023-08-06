package org.yandex.dto;

import lombok.Getter;

@Getter
public final class ApplicationErrorResponseDTO {

	private final boolean success = false;

	private String errorMessage;

	public ApplicationErrorResponseDTO(String e) {
		this.errorMessage = e;
	}

}
