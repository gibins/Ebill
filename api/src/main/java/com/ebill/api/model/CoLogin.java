package com.ebill.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity  
@Table(name="co_login") 
public class CoLogin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1413358976071392996L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	@Column(name="id")
	private Long lid;
	
	@Column(name="username" )
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;

	public CoLogin(Long id, String userName, String password, String role) {
		this.lid = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public Long getLid() {
		return lid;
	}

	public void setLid(Long lid) {
		this.lid = lid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
}
