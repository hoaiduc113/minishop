package com.hoaiduc.core.service;

import com.hoaiduc.core.dto.DetailProductDTO;
import com.hoaiduc.core.persistence.data.entity.DetailProduct;

public interface DetailProductService
{
    DetailProductDTO updateDetailProduct(int detailProductID,int  amount);
    DetailProduct    findByID(int id);
    DetailProductDTO update(DetailProduct detailProduct);

}
