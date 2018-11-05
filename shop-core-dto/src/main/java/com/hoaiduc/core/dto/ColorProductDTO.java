package com.hoaiduc.core.dto;
import java.util.Set;
public class ColorProductDTO
{
    private int idColorProduct;
    private String colorName;
    Set<DetailProductDTO> listDetailProductDTO;
    public int getIdColorProduct()
    {
        return idColorProduct;
    }

    public void setIdColorProduct(int idColorProduct) {
        this.idColorProduct = idColorProduct;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Set<DetailProductDTO> getListDetailProductDTO() {
        return listDetailProductDTO;
    }

    public void setListDetailProductDTO(Set<DetailProductDTO> listDetailProductDTO) {
        this.listDetailProductDTO = listDetailProductDTO;
    }
}
