package com.hoaiduc.core.dto;

import com.hoaiduc.core.persistence.data.entity.DetailProduct;

import java.util.Set;

public class SizeDTO
{
    private int idSize;
    private String sizeName;
    Set<DetailProductDTO> listDetailProductDTO;
    public int getIdSize()
    {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Set<DetailProductDTO> getListDetailProductDTO() {
        return listDetailProductDTO;
    }

    public void setListDetailProductDTO(Set<DetailProductDTO> listDetailProductDTO) {
        this.listDetailProductDTO = listDetailProductDTO;
    }
}
