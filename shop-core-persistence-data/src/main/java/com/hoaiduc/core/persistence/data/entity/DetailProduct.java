package com.hoaiduc.core.persistence.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="detailproduct")
public class DetailProduct  implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDetailProduct;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idProduct")
	private Product idProduct;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idSize")
	private Size size;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idColorProduct")
	private ColorProduct colorProduct;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="idDetailProduct")
	List<DetailBill> listDetailBill;

	@OneToOne
	@JoinColumn(name="idImageProduct")
	private ImageProduct imageProduct;

	public ImageProduct getImageProduct() {
		return imageProduct;
	}

	public void setImageProduct(ImageProduct imageProduct) {
		this.imageProduct = imageProduct;
	}

	public List<DetailBill> getListDetailBill() {
		return listDetailBill;
	}

	public void setListDetailBill(List<DetailBill> listDetailBill) {
		this.listDetailBill = listDetailBill;
	}

	private int amount;
	private String dateAdded;
	public ColorProduct getColorProduct() {
		return colorProduct;
	}
	public void setColorProduct(ColorProduct colorProduct) {
		this.colorProduct = colorProduct;
	}
	public int getIdDetailProduct() {
		return idDetailProduct;
	}
	public void setIdDetailProduct(int idDetailProduct) {
		this.idDetailProduct = idDetailProduct;
	}
	public Product getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Product idProduct) {
		this.idProduct = idProduct;
	}
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	
}
