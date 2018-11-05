package com.hoaiduc.core.dto;

public class DetailBillDTO
{
    private int amount;
    private String price;
    private DetailBillIdDTO detailBillIdDTO;

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

    public DetailBillIdDTO getDetailBillIdDTO() {
        return detailBillIdDTO;
    }

    public void setDetailBillIdDTO(DetailBillIdDTO detailBillIdDTO) {
        this.detailBillIdDTO = detailBillIdDTO;
    }
}
