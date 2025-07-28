package com.darjsoft.inventory_service.services;

import com.darjsoft.inventory_service.dtos.StockInventoryDTO;
import com.darjsoft.inventory_service.entities.StockInventoryEntity;
import com.darjsoft.inventory_service.util.Pager;

public interface IStockInventoryService {

	Pager<StockInventoryEntity> all(Integer pageNumber, Integer pageSize);

	Pager<StockInventoryEntity> findByFilter(Long id, Integer pageNumber, Integer pageSize);

	StockInventoryDTO save(StockInventoryDTO stockInventoryDto);

	StockInventoryDTO update(StockInventoryDTO stockInventoryDto);

	StockInventoryDTO delete(Long id);

}
