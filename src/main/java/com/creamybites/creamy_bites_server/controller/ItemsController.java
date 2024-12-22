package com.creamybites.creamy_bites_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creamybites.creamy_bites_server.entities.Items;
import com.creamybites.creamy_bites_server.serviceImpl.ItemServiceImpl;


@RestController
@RequestMapping("/api/v1")
public class ItemsController {

	@Autowired
	private ItemServiceImpl itemServiceImpl;
	
	@CrossOrigin
	@PostMapping("/addItem")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<?> saveItem(@RequestBody Items item){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(itemServiceImpl.addItem(item));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item not added");
			}
	}
	
	@CrossOrigin
	@GetMapping("/getItems")
	public ResponseEntity<?> getAllItems(){
		return ResponseEntity.status(HttpStatus.OK).body(itemServiceImpl.getAllItems());
	}
	
	@CrossOrigin
	@GetMapping("/getItemById/{id}")
	public ResponseEntity<?> getItemById(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(itemServiceImpl.getItem(id));
	}
	
	@CrossOrigin
	@PutMapping("editItem/{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<?> editItem(@PathVariable("id") Long id , @RequestBody Items item){
		return ResponseEntity.status(HttpStatus.OK).body(itemServiceImpl.editItem(id, item));
	}
	
	@CrossOrigin
	@DeleteMapping("deleteItem/{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<?> deleteItem(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(itemServiceImpl.deleteItem(id));
	}
	
}