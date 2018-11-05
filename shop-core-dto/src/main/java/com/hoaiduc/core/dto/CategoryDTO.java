package com.hoaiduc.core.dto;

import java.util.Set;

public class CategoryDTO
{
    private int idCategoryProducts;
    private String categoryName;
    private String categoryImage;
    Set<ProductDTO> listProduct;

    public int getIdCategoryProducts()
    {
        return idCategoryProducts;
    }

    public void setIdCategoryProducts(int idCategoryProducts)
    {
        this.idCategoryProducts = idCategoryProducts;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public Set<ProductDTO> getListProduct() {
        return listProduct;
    }

    public void setListProduct(Set<ProductDTO> listProduct) {
        this.listProduct = listProduct;
    }
}
