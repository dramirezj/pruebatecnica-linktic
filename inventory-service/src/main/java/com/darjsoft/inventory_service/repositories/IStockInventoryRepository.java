package com.darjsoft.inventory_service.repositories;

import org.springframework.data.repository.CrudRepository;

import com.darjsoft.inventory_service.entities.StockInventoryEntity;

public interface IStockInventoryRepository extends CrudRepository<StockInventoryEntity, Long> {

}
