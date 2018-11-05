package com.hoaiduc.core.service;

import com.hoaiduc.core.dto.ProductDTO;
import com.hoaiduc.core.persistence.data.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService
{
    List<ProductDTO> listProduct(int begin,int end);
    List<ProductDTO> paging();
    ProductDTO getProductById(int id);
    ProductDTO getIdDetailProduct(int idProduct, String sizeName, String colorName);
    Object[] searchProduct(Map<String,Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
}
