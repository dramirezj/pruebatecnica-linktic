package com.darjsoft.inventory_service.services;

import org.mapstruct.factory.Mappers;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darjsoft.inventory_service.config.cache.CacheConstants;
import com.darjsoft.inventory_service.dtos.StockInventoryDTO;
import com.darjsoft.inventory_service.entities.StockInventoryEntity;
import com.darjsoft.inventory_service.repositories.IStockInventoryRepository;
import com.darjsoft.inventory_service.util.Pager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockInventoryServiceImpl implements IStockInventoryService {
	
	private final IStockInventoryRepository stockInventoryRepository;
	private final IStockInventoryMapper mapper = Mappers.getMapper(IStockInventoryMapper.class);

	@Transactional(readOnly = true)
	@Override
	@CachePut(value = CacheConstants.INVENTORY_CACHE)
	public Pager<StockInventoryEntity> all(Integer pageNumber, Integer pageSize) {
		var response = stockInventoryRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("id").descending()));
		return new Pager<>(response.getContent(), response.getTotalElements(), response.getTotalPages());
	}

	@Transactional(readOnly = true)
	@Override
	@CachePut(value = CacheConstants.INVENTORY_CACHE)
	public Pager<StockInventoryEntity> findByFilter(Long id, Integer pageNumber, Integer pageSize) {
		return null;
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value = CacheConstants.INVENTORY_CACHE, allEntries = true)
	})
	public StockInventoryDTO save(StockInventoryDTO stockInventoryDto) {
		return null;
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value = CacheConstants.INVENTORY_CACHE, allEntries = true)
	})
	public StockInventoryDTO update(StockInventoryDTO stockInventoryDto) {
		return null;
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value = CacheConstants.INVENTORY_CACHE, allEntries = true)
	})
	public StockInventoryDTO delete(Long id) {
		return null;
	}

}
