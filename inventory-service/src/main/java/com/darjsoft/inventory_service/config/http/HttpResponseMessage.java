package com.darjsoft.inventory_service.config.http;

import com.darjsoft.inventory_service.util.message.MessageLevel;
import com.darjsoft.inventory_service.util.message.MessagesEnum;
import com.darjsoft.inventory_service.util.message.MessagesUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponseMessage<T> {
	
	private String code;

	private String message;

	private MessageLevel level;

	private T content;

	public HttpResponseMessage(MessagesEnum messageEnum, T content) {
		this.code = messageEnum.name();
		this.message = MessagesUtil.buildMessage(messageEnum);
		this.level = messageEnum.getLevel();
		this.content = content;
	}

}
