package com.hoaiduc.core.service.impl;

import com.hoaiduc.core.convert.DetailProductConvert;
import com.hoaiduc.core.dao.DetailProductDao;
import com.hoaiduc.core.dto.DetailProductDTO;
import com.hoaiduc.core.persistence.data.entity.DetailProduct;
import com.hoaiduc.core.service.DetailProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailProductServiceImpl implements DetailProductService
{
    @Autowired
    DetailProductDao detailProductDao;
    @Autowired
    DetailProductConvert detailProductConvert;
    public DetailProductDTO updateDetailProduct(int detailProductID,int amount)
    {
        DetailProduct detailProducts=detailProductDao.updateDetailProduct(detailProductID,amount);

        return detailProductConvert.convertDetailProductDTO(detailProducts);
    }

    public DetailProduct findByID(int id) {
        DetailProduct detailProduct=detailProductDao.findByID(id);
        return detailProduct;
    }

    public DetailProductDTO update(DetailProduct detailProduct) {
        DetailProduct currentDetailProduct=detailProductDao.update(detailProduct);

        return detailProductConvert.convertDetailProductDTO(currentDetailProduct);
    }
}
