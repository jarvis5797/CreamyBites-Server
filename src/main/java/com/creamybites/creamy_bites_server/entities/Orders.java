package com.creamybites.creamy_bites_server.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import com.creamybites.creamy_bites_server.constants.AddOn;
import com.creamybites.creamy_bites_server.constants.AmountStatus;
import com.creamybites.creamy_bites_server.constants.OrderStatus;
import com.creamybites.creamy_bites_server.constants.Rating;
import com.creamybites.creamy_bites_server.constants.Size;
import com.creamybites.creamy_bites_server.constants.Type;
import com.creamybites.creamy_bites_server.constants.Variant;
import com.creamybites.creamy_bites_server.constants.Weight;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private Set<Items> items;
	
	@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private Users user;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	private Float totalAmount;
	
	@Enumerated(EnumType.STRING)
	private AmountStatus totalAmountStatus;
	
	@Enumerated(EnumType.STRING)
	private AmountStatus advanceAmountStatus;
	
	private Time preprationTime;
	
	@JsonIgnore
	private Date createdAt;
	
	@JsonIgnore
	private Date updatedAt;
}
