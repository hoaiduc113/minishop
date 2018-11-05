package com.hoaiduc.controller.api;

import com.hoaiduc.core.dto.DetailProductDTO;
import com.hoaiduc.core.persistence.data.entity.DetailProduct;
import com.hoaiduc.core.service.impl.DetailProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ajax/api/",produces = MediaType.APPLICATION_JSON_VALUE)
public class DetailProductApiController
{
    @Autowired
    DetailProductServiceImpl detailProductService;
    @PutMapping("detailproducts")
    public ResponseEntity<DetailProductDTO> update(@RequestParam("id") int id, @RequestBody DetailProductDTO detailProductDTO)
    {

        DetailProduct currentDetailProduct=detailProductService.findByID(id);
        if(currentDetailProduct==null)
        {
            return new ResponseEntity<DetailProductDTO>(HttpStatus.NOT_FOUND);
        }

        int amount=(currentDetailProduct.getAmount())-(detailProductDTO.getAmount());
        currentDetailProduct.setAmount(amount);
        DetailProductDTO myDetailProductDTO=detailProductService.update(currentDetailProduct);
        return new ResponseEntity<DetailProductDTO>(myDetailProductDTO,HttpStatus.OK);
    }

}
