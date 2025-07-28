package com.darjsoft.inventory_service.services;

import java.util.List;

import org.mapstruct.Mapper;

import com.darjsoft.inventory_service.dtos.StockInventoryDTO;
import com.darjsoft.inventory_service.entities.StockInventoryEntity;

@Mapper
public interface IStockInventoryMapper {

	StockInventoryDTO entityToDto(StockInventoryEntity stockInventoryEntity);

	List<StockInventoryDTO> entityToDto(List<StockInventoryEntity> stockInventoryEntities);

	StockInventoryEntity dtoToEntity(StockInventoryDTO stockInventoryDto);

}
