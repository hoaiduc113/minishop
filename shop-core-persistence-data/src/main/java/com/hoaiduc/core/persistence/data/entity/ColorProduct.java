package com.hoaiduc.core.persistence.data.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="colorproduct")
public class ColorProduct 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idColorProduct;
	private String colorName;
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="idColorProduct")
	private List<DetailProduct> listDetailProduct;

	public List<DetailProduct> getListDetailProduct() {
		return listDetailProduct;
	}

	public void setListDetailProduct(List<DetailProduct> listDetailProduct) {
		this.listDetailProduct = listDetailProduct;
	}

	public int getIdColorProduct() {
		return idColorProduct;
	}
	public void setIdColorProduct(int idColorProduct) {
		this.idColorProduct = idColorProduct;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	
	
}
