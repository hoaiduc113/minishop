package com.hoaiduc.core.dto;

import java.io.Serializable;
import java.util.Set;

public class EmployeeDTO implements Serializable
{
    private int idemployee;
    private String fullname;
    private String address;
    private String email;
    private String password;
    private RollDTO rollDTO;
    private Set<BillDTO> listBillDTO;

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

    public RollDTO getRollDTO() {
        return rollDTO;
    }

    public void setRollDTO(RollDTO rollDTO) {
        this.rollDTO = rollDTO;
    }

    public int getIdemployee() {
        return idemployee;
    }

    public void setIdemployee(int idemployee) {
        this.idemployee = idemployee;
    }

    public Set<BillDTO> getListBillDTO() {
        return listBillDTO;
    }

    public void setListBillDTO(Set<BillDTO> listBillDTO) {
        this.listBillDTO = listBillDTO;
    }
}

