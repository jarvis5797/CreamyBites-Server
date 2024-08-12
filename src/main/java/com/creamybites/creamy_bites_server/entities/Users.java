package com.creamybites.creamy_bites_server.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.creamybites.creamy_bites_server.constants.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Users implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private String userName;
	
	private String email;
	
	private String password;
	
	private String sector;
	
	private String flatName;
	
	private Long phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Carts cart;
	
	
	@JsonIgnore
	private Date createdAt;
	
	@JsonIgnore
	private Date updatedAt;

	public Users(Long userId, Role role, String userName, String email, String password, String sector,
			String flatName, Long phoneNumber, Carts cart, Date createdAt, Date updatedAt) {
		this.userId = userId;
		this.role = role;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.sector = sector;
		this.flatName = flatName;
		this.phoneNumber = phoneNumber;
		this.cart = cart;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Users() {
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getFlatName() {
		return flatName;
	}

	public void setFlatName(String flatName) {
		this.flatName = flatName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Carts getCart() {
		return cart;
	}

	public void setCart(Carts cart) {
		this.cart = cart;
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
		return "Users [userId=" + userId + ", role=" + role + ", userName=" + userName + ", email=" + email
				+ ", password=" + password + ", sector=" + sector + ", flatName=" + flatName + ", phoneNumber="
				+ phoneNumber + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getUsername() {
		return email;
	}
	
	@Override
	  public boolean isAccountNonExpired() {
	      return true;
	  }

	  @Override
	  public boolean isAccountNonLocked() {
	      return true;
	  }

	  @Override
	  public boolean isCredentialsNonExpired() {
	      return true;
	  }

	  @Override
	  public boolean isEnabled() {
	      return true;
	  }
	

}
