package com.creamybites.creamy_bites_server.entities;


import java.util.Date;
import java.util.List;

import com.creamybites.creamy_bites_server.constants.AddOn;
import com.creamybites.creamy_bites_server.constants.Rating;
import com.creamybites.creamy_bites_server.constants.Size;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items")
@NoArgsConstructor
@Data
@AllArgsConstructor
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
	
	@Enumerated(EnumType.STRING)
	private Size size;
	
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
	
	
}
