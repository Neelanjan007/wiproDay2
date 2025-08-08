package com.neelanjan.consumer.entity;

public class Food {
    private Long id;
    @Override
	public String toString() {
		return "Food [id=" + id + ", itemName=" + itemName + ", price=" + price + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	private String itemName;
    private Double price;

}
