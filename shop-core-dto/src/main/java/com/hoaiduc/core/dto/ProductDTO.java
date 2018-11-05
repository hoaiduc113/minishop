package com.hoaiduc.core.dto;

import com.hoaiduc.core.persistence.data.entity.Category;

import java.util.List;

public class ProductDTO
{
    private int idProduct;
    private String productName;
    private String price ;
    private String describes;
    private String image;
    private String gender;
    private CategoryDTO categoryDTO;
    private List<DetailProductDTO> listDetailProductDTO;

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public List<DetailProductDTO> getListDetailProductDTO() {
        return listDetailProductDTO;
    }

    public void setListDetailProductDTO(List<DetailProductDTO> listDetailProductDTO) {
        this.listDetailProductDTO = listDetailProductDTO;
    }

    public int getIdProduct()
    {
        return idProduct;
    }

    public void setIdProduct(int idProduct)
    {
        this.idProduct = idProduct;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
