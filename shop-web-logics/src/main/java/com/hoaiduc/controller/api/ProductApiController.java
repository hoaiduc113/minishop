package com.hoaiduc.controller.api;

import com.hoaiduc.core.constant.CoreConstant;
import com.hoaiduc.core.dto.DetailProductDTO;
import com.hoaiduc.core.dto.ProductDTO;
import com.hoaiduc.core.service.impl.ProductSeriveceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ajax/api/",produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductApiController
{
    @Autowired
    ProductSeriveceImp productSeriveceImp;
    @GetMapping("product")
    public ResponseEntity<List<ProductDTO>> get(@RequestParam("id") int id)
    {
        return ResponseEntity.ok().body(productSeriveceImp.listProduct(id, CoreConstant.MAXIEM));
    }
    @GetMapping("paging")
    public  ResponseEntity<List<ProductDTO>> paging()
    {
        return ResponseEntity.ok().body(productSeriveceImp.paging());
    }
    @GetMapping("productbyid" )
    public ResponseEntity<ProductDTO> getProductById(@RequestParam("id") int id)
    {
        return ResponseEntity.ok().body(productSeriveceImp.getProductById(id));
    }
//    @GetMapping("detailproduct")
//    public ResponseEntity<ProductDTO> getIdDetailProduct(@PathVariable("id")int id ,@PathVariable(required=false,name="sizename") String sizename,@PathVariable(required=false,name="colorname") String colorName)
//    {
//       return ResponseEntity.ok().body(productSeriveceImp.getIdDetailProduct(id,sizename,colorName));
//    }
    @PostMapping("detailproduct")
    public ResponseEntity<ProductDTO> getIdDetailProduct(@RequestBody DetailProductDTO dto)
    {
        return ResponseEntity.ok().body(productSeriveceImp.getIdDetailProduct(dto.getIdProduct().getIdProduct(),dto.getSizeDTO().getSizeName(),dto.getColorProductDTO().getColorName()));
    }
}
