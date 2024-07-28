package com.creamybites.creamy_bites_server.dao;

import com.creamybites.creamy_bites_server.constants.Weight;

public class ItemsDao {
	
	private Long itemId;
	
	private String flavour;
	
	private String imageSrc;
	
	private Weight weight;
	
	private Float price;

	public ItemsDao(Long itemId, String flavour, String imageSrc, Weight weight, Float price) {
		this.itemId = itemId;
		this.flavour = flavour;
		this.imageSrc = imageSrc;
		this.weight = weight;
		this.price = price;
	}

	public ItemsDao() {
		
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getFlavour() {
		return flavour;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemsDao [itemId=" + itemId + ", flavour=" + flavour + ", imageSrc=" + imageSrc + ", weight=" + weight
				+ ", price=" + price + "]";
	}
	
	
	
	

}
