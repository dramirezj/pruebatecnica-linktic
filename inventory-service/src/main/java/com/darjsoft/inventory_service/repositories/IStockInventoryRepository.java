package com.darjsoft.inventory_service.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.darjsoft.inventory_service.entities.StockInventoryEntity;

public interface IStockInventoryRepository extends CrudRepository<StockInventoryEntity, Long> {
	
	@EntityGraph(attributePaths = { "user" })
	Page<StockInventoryEntity> findAll(Pageable pageable);
	
	@Query(name = "findByFilter", value = "SELECT t FROM StockInventoryEntity t WHERE t.productId = :productId")
	Page<StockInventoryEntity> findByFilter(Pageable pageable, @Param("product_id") Long id);
	
	@Query(name = "deleteById", value = "SELECT t FROM StockInventoryEntity t WHERE t.productId = :productId")
	Optional<StockInventoryEntity> delete(Long productId);

}
