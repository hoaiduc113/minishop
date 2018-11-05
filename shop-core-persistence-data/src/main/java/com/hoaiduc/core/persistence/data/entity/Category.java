package com.hoaiduc.core.persistence.data.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "categoryproducts")
public class Category 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategoryProducts;
	private String categoryName;
	private String categoryImage;
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="idProduct")
	private List<Product> listProduct;


	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public int getIdCategoryProducts() {
		return idCategoryProducts;
	}
	public void setIdCategoryProducts(int idCategoryProducts) {
		this.idCategoryProducts = idCategoryProducts;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}
	
}
