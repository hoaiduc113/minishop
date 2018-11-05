package com.hoaiduc.core.convert;

import com.hoaiduc.core.dto.DetailProductDTO;
import com.hoaiduc.core.persistence.data.entity.DetailProduct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DetailProductConvert
{
    private ModelMapper modelMapper=new ModelMapper();
    public DetailProductDTO convertDetailProductDTO(DetailProduct detailProduct)
    {
        DetailProductDTO detailProductDTO=new DetailProductDTO();
        detailProductDTO.setIdDetailProduct(detailProduct.getIdDetailProduct());
        detailProductDTO.setAmount(detailProduct.getAmount());
        return detailProductDTO;

    }
}
