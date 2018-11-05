package com.hoaiduc.core.persistence.data.entity;

import java.util.Set;

public class JsonProduct 
{
private int idProduct;
	
	private String productName;
	private String price ;
	private String describes;
	private String image;
	private String gender;
	Set<DetailProduct> listDetailProduct;
	Set<Promotion> listPromotion;
	private Category category;
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Set<DetailProduct> getListDetailProduct() {
		return listDetailProduct;
	}
	public void setListDetailProduct(Set<DetailProduct> listDetailProduct) {
		this.listDetailProduct = listDetailProduct;
	}
	public Set<Promotion> getListPromotion() {
		return listPromotion;
	}
	public void setListPromotion(Set<Promotion> listPromotion) {
		this.listPromotion = listPromotion;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
