package com.neelanjan.consumer.entity;

import java.util.List;

public class Restaurant {
    @Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", location=" + location + ", menu=" + menu + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Food> getMenu() {
		return menu;
	}
	public void setMenu(List<Food> menu) {
		this.menu = menu;
	}
	private Long id;
    private String name;
    private String location;
    private List<Food> menu;

   
}

