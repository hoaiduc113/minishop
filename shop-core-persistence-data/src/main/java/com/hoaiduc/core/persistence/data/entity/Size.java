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

@Entity(name="size")
public class Size 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSize;
	private String sizeName;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="idSize")
	private List<DetailProduct> listDetailProduct;


	public List<DetailProduct> getListDetailProduct() {
		return listDetailProduct;
	}

	public void setListDetailProduct(List<DetailProduct> listDetailProduct) {
		this.listDetailProduct = listDetailProduct;
	}

	public int getIdSize() {
		return idSize;
	}
	public void setIdSize(int idSize) {
		this.idSize = idSize;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	
}
