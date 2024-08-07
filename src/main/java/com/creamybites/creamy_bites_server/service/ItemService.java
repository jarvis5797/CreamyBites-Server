package com.creamybites.creamy_bites_server.service;

import java.util.List;


import com.creamybites.creamy_bites_server.dao.ItemsDao;
import com.creamybites.creamy_bites_server.entities.Items;


public interface ItemService {

	public String addItem(Items item); 
	
	public List<ItemsDao> getAllItems();
	
	public Items getItem(Long id);
	
	public String editItem(Long id , Items item);
	
	public String deleteItem(Long id);
	
}
