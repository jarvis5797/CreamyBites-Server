package com.creamybites.creamy_bites_server.entities;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.creamybites.creamy_bites_server.constants.AddOn;
import com.creamybites.creamy_bites_server.constants.Rating;
import com.creamybites.creamy_bites_server.constants.Type;
import com.creamybites.creamy_bites_server.constants.Variant;
import com.creamybites.creamy_bites_server.constants.Weight;
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
	
	private String image1;
	
	private String image2;
	
	private String image3;
	
	private String image4;
	
	@Enumerated(EnumType.STRING)
	private Weight weight;
	
	private String description;
	
	private Float price;
	
	@Enumerated(EnumType.STRING)
	private List<AddOn> add_ons;
	
	@Enumerated(EnumType.STRING)
	private Variant variant;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Enumerated(EnumType.STRING)
	private Rating rating;
	
	@JsonIgnore
	private Date createdAt;
	
	@JsonIgnore
	private Date updatedAt;
	

	

	

	public Items(Long itemId, String flavour, String image1, String image2, String image3, String image4, Weight weight,
			String description, Float price, List<AddOn> add_ons, Variant variant, Type type, Rating rating,
			Date createdAt, Date updatedAt) {
		super();
		this.itemId = itemId;
		this.flavour = flavour;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.weight = weight;
		this.description = description;
		this.price = price;
		this.add_ons = add_ons;
		this.variant = variant;
		this.type = type;
		this.rating = rating;
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

	

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
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
	
	

	public Variant getVariant() {
		return variant;
	}

	public void setVariant(Variant variant) {
		this.variant = variant;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
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
		return "Items [itemId=" + itemId + ", flavour=" + flavour + ", image1=" + image1 + ", image2=" + image2
				+ ", image3=" + image3 + ", image4=" + image4 + ", weight=" + weight + ", description=" + description
				+ ", price=" + price + ", add_ons=" + add_ons + ", variant=" + variant + ", type=" + type + ", rating="
				+ rating + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	

	
	
	
	
}
