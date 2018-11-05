package com.hoaiduc.core.dto;
import java.util.List;
public class DetailProductDTO
{
    private int idDetailProduct;
    private ProductDTO idProduct;
    private SizeDTO sizeDTO;
    private ColorProductDTO colorProductDTO;
    private int amount;
    private String dateAdded;
    private List<DetailBillDTO> listDetailBillDTO;
    private ImageProductDTO imageProductDTO;

    public ImageProductDTO getImageProductDTO() {
        return imageProductDTO;
    }

    public void setImageProductDTO(ImageProductDTO imageProductDTO) {
        this.imageProductDTO = imageProductDTO;
    }

    public int getIdDetailProduct()
    {
        return idDetailProduct;
    }

    public void setIdDetailProduct(int idDetailProduct) {
        this.idDetailProduct = idDetailProduct;
    }

    public ProductDTO getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(ProductDTO idProduct) {
        this.idProduct = idProduct;
    }

    public SizeDTO getSizeDTO() {
        return sizeDTO;
    }

    public void setSizeDTO(SizeDTO sizeDTO) {
        this.sizeDTO = sizeDTO;
    }

    public ColorProductDTO getColorProductDTO() {
        return colorProductDTO;
    }

    public void setColorProductDTO(ColorProductDTO colorProductDTO) {
        this.colorProductDTO = colorProductDTO;
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

    public List<DetailBillDTO> getListDetailBillDTO() {
        return listDetailBillDTO;
    }

    public void setListDetailBillDTO(List<DetailBillDTO> listDetailBillDTO) {
        this.listDetailBillDTO = listDetailBillDTO;
    }
}
