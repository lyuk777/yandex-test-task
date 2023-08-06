package org.yandex.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.yandex.dto.ApplicationErrorResponseDTO;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = NOT_FOUND)
	@ResponseBody
	public ApplicationErrorResponseDTO resourceNotFoundException(ResourceNotFoundException e) {
		log.warn(e.getMessage(), e);
		return new ApplicationErrorResponseDTO(e.getMessage());
	}

}
