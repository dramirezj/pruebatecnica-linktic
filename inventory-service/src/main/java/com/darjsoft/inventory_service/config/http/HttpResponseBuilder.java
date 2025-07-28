package com.darjsoft.inventory_service.config.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.darjsoft.inventory_service.exceptions.InventoryHttpException;
import com.darjsoft.inventory_service.util.message.MessageLevel;
import com.darjsoft.inventory_service.util.message.MessagesEnum;
import com.darjsoft.inventory_service.util.message.MessagesUtil;

import jakarta.validation.constraints.NotNull;

public class HttpResponseBuilder {
	
	private HttpResponseBuilder() {
	}

	public static <T> ResponseEntity<HttpResponseMessage<T>> buildResponse(@NotNull T content, String code,
			String message, MessageLevel level, HttpStatus status) {

		var response = new HttpResponseMessage<T>();
		response.setCode(code);
		response.setLevel(level);
		response.setMessage(message);
		response.setContent(content);

		return ResponseEntity.status(status).body(response);
	}

	public static <T> ResponseEntity<HttpResponseMessage<T>> buildResponse(@NotNull T content, MessagesEnum message,
			HttpStatus status) {

		var response = new HttpResponseMessage<T>();
		response.setCode(message.name());
		response.setLevel(MessageLevel.INFO);
		response.setMessage(MessagesUtil.buildMessage(message));
		response.setContent(content);

		return ResponseEntity.status(status).body(response);
	}

	public static <T> ResponseEntity<HttpResponseMessage<T>> buildResponse(@NotNull HttpResponseMessage<T> response,
			HttpStatus status) {
		return ResponseEntity.status(status).body(response);
	}

	public static ResponseEntity<HttpResponseMessage<Void>> buildResponse(MessagesEnum message, HttpStatus status) {
		return ResponseEntity.status(status).body(new HttpResponseMessage<Void>(message.name(),
				MessagesUtil.buildMessage(message.getMessage()), message.getLevel(), null));
	}

	public static ResponseEntity<HttpResponseMessage<String>> buildErrorResponse(InventoryHttpException ex) {

		var response = new HttpResponseMessage<String>();
		response.setCode(ex.getErrorCode());
		response.setLevel(MessageLevel.ERROR);
		response.setMessage(ex.getMessage());

		return ResponseEntity.status(ex.getHttpCode()).body(response);
	}
}
