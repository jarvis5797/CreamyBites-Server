package com.creamybites.creamy_bites_server.entities;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.creamybites.creamy_bites_server.constants.AddOn;
import com.creamybites.creamy_bites_server.constants.Rating;
import com.creamybites.creamy_bites_server.constants.Size;
import com.creamybites.creamy_bites_server.constants.Type;
import com.creamybites.creamy_bites_server.constants.Variant;
import com.creamybites.creamy_bites_server.constants.Weight;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "carts")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Carts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private Set<Items> items;
	
	private float totalPrice;
	
	@OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false ) 
    private Users users;
	
	@JsonIgnore
	private Date createdAt;
	
	@JsonIgnore
	private Date updatedAt;

	
}
