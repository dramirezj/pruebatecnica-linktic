package com.darjsoft.inventory_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FeignException.NotFound.class)
	public ResponseEntity<String> handleNotFound(FeignException.NotFound ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso no encontrado");
	}

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<String> handleFeignException(FeignException ex) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Error al comunicar con otro servicio");
	}

}
