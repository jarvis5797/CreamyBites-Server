package com.creamybites.creamy_bites_server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.creamybites.creamy_bites_server.dao.ItemsDao;
import com.creamybites.creamy_bites_server.entities.Items;


public interface ItemService {

	public String addItem(Items item); 
	
	public List<ItemsDao> getAllItems();
	
}
