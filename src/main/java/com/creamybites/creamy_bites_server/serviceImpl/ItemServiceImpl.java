package com.creamybites.creamy_bites_server.serviceImpl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creamybites.creamy_bites_server.dao.ItemsDao;
import com.creamybites.creamy_bites_server.entities.Items;
import com.creamybites.creamy_bites_server.repository.ItemsRepository;
import com.creamybites.creamy_bites_server.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemsRepository itemsRepository;

	@Override
	public String addItem(Items item) {
		Date date = new Date();
		item.setCreatedAt(date);
		item.setUpdatedAt(date);
		itemsRepository.save(item);
		return "Item added";
	}

	@Override
	public List<ItemsDao> getAllItems() {
		List<Items> items = itemsRepository.findAll();
		List<ItemsDao> itemsDaos = new ArrayList<>();
		for(Items item : items) {
			ItemsDao itemsDao = new ItemsDao();
			itemsDao.setFlavour(item.getFlavour());
			itemsDao.setImageSrc(item.getImage());
			itemsDao.setItemId(item.getItemId());
			itemsDao.setPrice(item.getPrice());
			itemsDao.setWeight(item.getWeight());
			itemsDaos.add(itemsDao);
		}
		return itemsDaos;
	}
	

}
