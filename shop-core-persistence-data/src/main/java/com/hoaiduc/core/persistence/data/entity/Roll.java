package com.hoaiduc.core.persistence.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="roll")
public class Roll 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRoll;
	private String rollName;
	
	public int getIdRoll() {
		return idRoll;
	}
	public void setIdRoll(int idRoll) {
		this.idRoll = idRoll;
	}
	public String getRollName() {
		return rollName;
	}
	public void setRollName(String rollName) {
		this.rollName = rollName;
	}
	
	
	
}
