package com.hoaiduc.core.persistence.data.entity;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name ="bill")
public class Bill 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBill;
	private String customerName;
	private String phoneNumber;
	private String addressDelivery;
	private int statuss;
	private String dateFounded;
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="idBill" )
	List<DetailBill> listDetailBill;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idemployee")
	private Employee idemployee;

	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddressDelivery() {
		return addressDelivery;
	}
	public void setAddressDelivery(String addressDelivery) {
		this.addressDelivery = addressDelivery;
	}
	public String getDateFounded() {
		return dateFounded;
	}
	public void setDateFounded(String dateFounded) {
		this.dateFounded = dateFounded;
	}
	public Employee getIdemployee() {
		return idemployee;
	}

    public int getStatuss() {
        return statuss;
    }

    public void setStatuss(int statuss) {
        this.statuss = statuss;
    }

    public void setIdemployee(Employee idemployee) {
		this.idemployee = idemployee;
	}

	public List<DetailBill> getListDetailBill() {
		return listDetailBill;
	}

	public void setListDetailBill(List<DetailBill> listDetailBill) {
		this.listDetailBill = listDetailBill;
	}
}
