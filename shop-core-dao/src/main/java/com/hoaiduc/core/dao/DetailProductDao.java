package com.hoaiduc.core.dao;

import com.hoaiduc.core.data.dao.GenericDao;
import com.hoaiduc.core.persistence.data.entity.DetailProduct;

public interface DetailProductDao extends GenericDao<Integer, DetailProduct>
{
    DetailProduct updateDetailProduct(int detailProductID,int amount);
}
