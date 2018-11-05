package com.hoaiduc.core.dto;

import java.util.Set;

public class BillDTO
{
    private int idBill;
    private String customerName;
    private String phoneNumber;
    private String addressDelivery;
    private int statuss;
    private String dateFounded;
    private String note;
    private Set<DetailBillDTO> listDetailBillDTO;
    private EmployeeDTO employeeDTO;

    public EmployeeDTO getEmployeeDTO()
    {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public int getIdBill()
    {
        return idBill;
    }

    public void setIdBill(int idBill)
    {
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

    public int getStatuss() {
        return statuss;
    }

    public void setStatuss(int statuss) {
        this.statuss = statuss;
    }

    public String getDateFounded() {
        return dateFounded;
    }

    public void setDateFounded(String dateFounded) {
        this.dateFounded = dateFounded;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<DetailBillDTO> getListDetailBillDTO() {
        return listDetailBillDTO;
    }

    public void setListDetailBillDTO(Set<DetailBillDTO> listDetailBillDTO) {
        this.listDetailBillDTO = listDetailBillDTO;
    }
}
