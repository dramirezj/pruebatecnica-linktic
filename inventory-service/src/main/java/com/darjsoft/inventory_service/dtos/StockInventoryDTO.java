package com.darjsoft.inventory_service.dtos;

import java.time.LocalDate;

import com.darjsoft.inventory_service.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class StockInventoryDTO {
	
	private Long id;
	@JsonProperty(value = "id producto")
	private Long productId;
	@JsonProperty(value = "cantidad")
	private Long quantity;
	@JsonFormat(pattern = DateUtil.DATE_FORMAT)
	@JsonProperty(value = "fecha creacion")
	private LocalDate createAt;
	@JsonFormat(pattern = DateUtil.DATE_FORMAT)
	@JsonProperty(value = "fecha actualizacion")
	private LocalDate updateAt;

}
