package com.hoaiduc.core.persistence.data.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hoaiduc.core.persistence.data.entity.Roll;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="employee")
public class Employee
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idemployee;
	private String fullname;
	private String address;
	private String email;
	private String password;

	//when i update current table ,these another table all of update
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idRoll")
	private Roll roll;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="idemployee")
	List<Bill> listBill;

	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Roll getRoll() {
		return roll;
	}
	public void setRoll(Roll roll) {
		this.roll = roll;
	}
	public int getIdemployee() {
		return idemployee;
	}

	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}

//	public Set<Bill> getListBill() {
//		return listBill;
//	}
//
//	public void setListBill(Set<Bill> listBill) {
//		this.listBill = listBill;
//	}
}
