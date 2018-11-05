package com.hoaiduc.core.persistence.data.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduct;
	private String productName;
	private String price ;
	private String describes;
	private String image;
	private String gender;
	//table detailproduct
	//difference between  eager and lazy
	// lazy: fetch when needed
	//eager:fetch when immediately
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="idProduct")
	private List<DetailProduct> listDetailProduct;
	
	
	//table detailpromotion
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="detailpromotion",
	joinColumns= {@JoinColumn(name="idProduct",referencedColumnName="idProduct")},
	inverseJoinColumns= {@JoinColumn(name="idPromotion",referencedColumnName="idPromotion")}
	)	
	private List<Promotion> listPromotion;
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="idCategoryProducts")
	private Category category;

	public List<DetailProduct> getListDetailProduct() {
		return listDetailProduct;
	}

	public void setListDetailProduct(List<DetailProduct> listDetailProduct) {
		this.listDetailProduct = listDetailProduct;
	}

	public List<Promotion> getListPromotion() {
		return listPromotion;
	}

	public void setListPromotion(List<Promotion> listPromotion) {
		this.listPromotion = listPromotion;
	}

	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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
	
	
}
