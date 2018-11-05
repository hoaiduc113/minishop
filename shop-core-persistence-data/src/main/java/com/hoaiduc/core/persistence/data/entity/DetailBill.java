package com.hoaiduc.core.persistence.data.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="detailbill")
public class DetailBill implements Serializable
{
	@EmbeddedId
	DetailBillId detailBillId;
	private int amount;
	private String price;
	public DetailBillId getDetailBillId() {
		return detailBillId;
	}
	public void setDetailBillId(DetailBillId detailBillId) {
		this.detailBillId = detailBillId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
