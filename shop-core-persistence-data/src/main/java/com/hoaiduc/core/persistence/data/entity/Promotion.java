package com.hoaiduc.core.persistence.data.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ValueGenerationType;

@Entity(name="promotion")
public class Promotion 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPromotion;
	private String promotionName;
	private String startTime;
	private String endTime;
	private String describes;
	private String promotionImage;
	private int price;
//	referencedColumnName is a foreign key 
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="detailpromotion",
	joinColumns= {@JoinColumn(name="idPromotion",referencedColumnName="idPromotion")},
	inverseJoinColumns= {@JoinColumn(name="idProduct",referencedColumnName="idProduct")}
	)
    private List<Product> listProduct;

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public int getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	public String getPromotionImage() {
		return promotionImage;
	}
	public void setPromotionImage(String promotionImage) {
		this.promotionImage = promotionImage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
