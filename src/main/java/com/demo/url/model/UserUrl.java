package com.demo.url.model;

import java.io.Serializable;

public class UserUrl implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;

	public String name;

	public String url;
	
	public String shorturl;

//	private int amount;

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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	


	public String getShorturl() {
		return shorturl;
	}

	public void setShorturl(String shorturl) {
		this.shorturl = shorturl;
	}

	@Override
	public String toString() {
		return getId() + "," + getName() + "," + getUrl() + "," + getShorturl();
	}

	
	
}
