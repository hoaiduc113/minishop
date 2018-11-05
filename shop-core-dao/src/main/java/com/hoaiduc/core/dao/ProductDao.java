package com.hoaiduc.core.dao;

import com.hoaiduc.core.data.dao.GenericDao;
import com.hoaiduc.core.persistence.data.entity.Product;

import java.util.Map;

public interface ProductDao extends GenericDao<Integer, Product>
{
    Product getProductById(int id);
    Product getIdDetailProduct(int idProduct,String sizeName,String colorName);
}
