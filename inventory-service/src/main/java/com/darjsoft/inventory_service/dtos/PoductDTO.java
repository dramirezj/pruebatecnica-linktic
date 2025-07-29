package com.darjsoft.inventory_service.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class PoductDTO {
	
	private Long id;
	@JsonProperty(value = "Nombre")
	private String name;
	@JsonProperty(value = "Precio")
	private BigDecimal price;
	@JsonProperty(value = "Descripci\\u00f3n")
	private String description;

}
