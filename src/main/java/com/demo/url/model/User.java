package com.demo.url.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String password;

	private int amount;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return getId() + "," + getName() + "," + getPassword();
	}

	
	
}
