package com.darjsoft.inventory_service.dtos;

import java.time.LocalDate;

import com.darjsoft.inventory_service.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StockInventoryDTO {
	
	private Long id;
	@JsonProperty(value = "id producto")
	private Long product_id;
	@JsonProperty(value = "cantidad")
	private Long quantity;
	@JsonFormat(pattern = DateUtil.DATE_FORMAT)
	@JsonProperty(value = "fecha creacion")
	private LocalDate createAt;
	@JsonFormat(pattern = DateUtil.DATE_FORMAT)
	@JsonProperty(value = "fecha actualizacion")
	private LocalDate updateAt;

}
