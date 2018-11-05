package com.hoaiduc.core.dto;

import java.util.Set;

public class ImageProductDTO
{
    private int idImageProduct;
    private String image;
    private Set<DetailProductDTO> listDetailProductDTO;

    public int getIdImageProduct()
    {
        return idImageProduct;
    }

    public void setIdImageProduct(int idImageProduct) {
        this.idImageProduct = idImageProduct;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<DetailProductDTO> getListDetailProductDTO() {
        return listDetailProductDTO;
    }

    public void setListDetailProductDTO(Set<DetailProductDTO> listDetailProductDTO) {
        this.listDetailProductDTO = listDetailProductDTO;
    }
}
