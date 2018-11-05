package com.hoaiduc.core.service.impl;

import com.hoaiduc.core.convert.ProductConvert;
import com.hoaiduc.core.daoimpl.ProducDaoImp;
import com.hoaiduc.core.dto.ProductDTO;
import com.hoaiduc.core.persistence.data.entity.Product;
import com.hoaiduc.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductSeriveceImp implements ProductService
{
    @Autowired
    ProducDaoImp producDaoImp;
    @Autowired
    ProductConvert productCovert;
    public List<ProductDTO> listProduct(int begin, int end)
    {
        List<Product> product=producDaoImp.getProduct(begin,end);
        return productCovert.covertEmployeeDTO(product);
    }
    public List<ProductDTO> paging()
    {
        List<Product> list=producDaoImp.findAll();
        return productCovert.covertEmployeeDTO(list);
    }

    public ProductDTO getProductById(int id)
    {
        Product product=producDaoImp.getProductById(id);
        return productCovert.covertProductDTO(product);
    }

    public ProductDTO getIdDetailProduct(int idProduct, String sizeName, String colorName) {
        Product product=producDaoImp.getIdDetailProduct(idProduct,sizeName,colorName);
        return productCovert.covertProductDTO(product);
    }

    public Object[] searchProduct(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        Object[] objects=producDaoImp.findByProperty(property,sortExpression,sortDirection,offset,limit,null);
        List<ProductDTO> productDTOList=new ArrayList<ProductDTO>();
        for (Product item:(List<Product>) objects[1])
        {
            ProductDTO productDTO=productCovert.convertFindByProperty(item);
            productDTOList.add(productDTO);
        }
        objects[1]=productDTOList;
        return objects;

    }


}
