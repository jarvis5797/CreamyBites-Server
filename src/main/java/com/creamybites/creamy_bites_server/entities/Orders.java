package com.creamybites.creamy_bites_server.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import com.creamybites.creamy_bites_server.constants.AmountStatus;
import com.creamybites.creamy_bites_server.constants.OrderStatus;
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

@Entity
@Table(name = "orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private Set<Items> items;
	
	@ManyToOne
	@JoinColumn(name= "user")
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

	public Orders(Long orderId, Set<Items> items, OrderStatus orderStatus, Float totalAmount,
			AmountStatus totalAmountStatus, AmountStatus advanceAmountStatus, Time preprationTime, Date createdAt,
			Date updatedAt) {
		this.orderId = orderId;
		this.items = items;
		this.orderStatus = orderStatus;
		this.totalAmount = totalAmount;
		this.totalAmountStatus = totalAmountStatus;
		this.advanceAmountStatus = advanceAmountStatus;
		this.preprationTime = preprationTime;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Orders() {
		
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public AmountStatus getTotalAmountStatus() {
		return totalAmountStatus;
	}

	public void setTotalAmountStatus(AmountStatus totalAmountStatus) {
		this.totalAmountStatus = totalAmountStatus;
	}

	public AmountStatus getAdvanceAmountStatus() {
		return advanceAmountStatus;
	}

	public void setAdvanceAmountStatus(AmountStatus advanceAmountStatus) {
		this.advanceAmountStatus = advanceAmountStatus;
	}

	public Time getPreprationTime() {
		return preprationTime;
	}

	public void setPreprationTime(Time preprationTime) {
		this.preprationTime = preprationTime;
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
		return "Orders [orderId=" + orderId + ", items=" + items + ", totalAmount=" + totalAmount + ", preprationTime="
				+ preprationTime + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
}
