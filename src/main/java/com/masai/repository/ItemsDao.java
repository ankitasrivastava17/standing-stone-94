package com.masai.repository;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsDao extends JpaRepository<Item, Integer>
{

	public List<Item> findByItemName(String itemName);

}
