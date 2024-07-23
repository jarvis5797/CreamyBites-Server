package com.creamybites.creamy_bites_server.entities;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import com.creamybites.creamy_bites_server.constants.AddOn;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Items {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	
	private String flavour;
	
	private byte[] image;
	
	private Float weight;
	
	private String description;
	
	private Float price;
	
	@Enumerated(EnumType.STRING)
	private List<AddOn> add_ons;
	
	@JsonIgnore
	private Date createdAt;
	
	@JsonIgnore
	private Date updatedAt;

	public Items(Long itemId, String flavour, byte[] image, Float weight, String description, Float price,
			List<AddOn> add_ons, Date createdAt, Date updatedAt) {
		this.itemId = itemId;
		this.flavour = flavour;
		this.image = image;
		this.weight = weight;
		this.description = description;
		this.price = price;
		this.add_ons = add_ons;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Items() {
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<AddOn> getAdd_ons() {
		return add_ons;
	}

	public void setAdd_ons(List<AddOn> add_ons) {
		this.add_ons = add_ons;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", flavour=" + flavour + ", image=" + Arrays.toString(image) + ", weight="
				+ weight + ", description=" + description + ", price=" + price + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	
	
}
