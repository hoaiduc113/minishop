package com.hoaiduc.core.convert;

import com.hoaiduc.core.dto.*;
import com.hoaiduc.core.persistence.data.entity.ColorProduct;
import com.hoaiduc.core.persistence.data.entity.DetailProduct;
import com.hoaiduc.core.persistence.data.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProductConvert
{
    private ModelMapper modelMapper=new ModelMapper();
    public List<ProductDTO> covertEmployeeDTO(List<Product> list)
    {
        List<ProductDTO> productDTOList=new ArrayList<ProductDTO>();
        ProductDTO productDTO=null;
        for(Product product:list)
        {
            productDTO=new ProductDTO();
            modelMapper.map(product,productDTO);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }
    public ProductDTO covertProductDTO(Product product)
    {
        ProductDTO productDTO=new ProductDTO();
        ColorProductDTO colorProductDTO=null;
        SizeDTO sizeDTO=null;
        ImageProductDTO imageProductDTO=null;
        List<DetailProductDTO> listDetailProductDTO=new ArrayList<DetailProductDTO>();
        DetailProductDTO detailProductDTO=null;
        for(DetailProduct item:product.getListDetailProduct())
        {
            colorProductDTO=new ColorProductDTO();
            sizeDTO=new SizeDTO();
            detailProductDTO=new DetailProductDTO();
            imageProductDTO=new ImageProductDTO();
            modelMapper.map(item.getColorProduct(),colorProductDTO);
            modelMapper.map(item.getSize(),sizeDTO);
            modelMapper.map(item.getImageProduct(),imageProductDTO);
            detailProductDTO.setColorProductDTO(colorProductDTO);
            detailProductDTO.setSizeDTO(sizeDTO);
            int idDetailProduct=item.getIdDetailProduct();
            int amount=item.getAmount();
            String dateAdded=item.getDateAdded();
            detailProductDTO.setIdDetailProduct(idDetailProduct);
            detailProductDTO.setAmount(amount);
            detailProductDTO.setDateAdded(dateAdded);
            detailProductDTO.setImageProductDTO(imageProductDTO);
            listDetailProductDTO.add(detailProductDTO);
        }
        productDTO.setListDetailProductDTO(listDetailProductDTO);
        modelMapper.map(product,productDTO);
        return productDTO;
    }
        public ProductDTO convertFindByProperty(Product product)
    {
        ProductDTO productDTO=new ProductDTO();
        modelMapper.map(product,productDTO);
        return productDTO;
    }
}
