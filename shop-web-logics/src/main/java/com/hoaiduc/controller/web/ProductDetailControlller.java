package com.hoaiduc.controller.web;

import com.hoaiduc.core.constant.CoreConstant;
import com.hoaiduc.core.dto.CartDTO;
import com.hoaiduc.core.dto.DetailProductDTO;
import com.hoaiduc.core.dto.EmployeeDTO;
import com.hoaiduc.core.dto.ProductDTO;
import com.hoaiduc.core.persistence.data.entity.Product;
import com.hoaiduc.core.service.impl.ProductSeriveceImp;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/product-detail")
@SessionAttributes("cart")
public class ProductDetailControlller
{
    @Autowired
    ProductSeriveceImp productSeriveceImp;
    private RestTemplate restTemplate=new RestTemplate();
    private  int idDetailProduct;
    @GetMapping("/{idproduct}")
    public ModelAndView Default(@PathVariable int idproduct, ModelMap modelMap, HttpSession httpSession)
    {
        modelMap.addAttribute("idproduct",idproduct);
        ModelAndView modelAndView=new ModelAndView("product/product");
        UriComponentsBuilder builder=UriComponentsBuilder.fromHttpUrl(CoreConstant.LINK+"productbyid/")
                .queryParam("id",idproduct);
        ProductDTO detailProductDTO=restTemplate.getForObject(builder.toUriString(), ProductDTO.class);
        List<DetailProductDTO> listDetailProductDTO=detailProductDTO.getListDetailProductDTO();
        for(DetailProductDTO productDTO:listDetailProductDTO)
        {
            idDetailProduct=productDTO.getIdDetailProduct();
            break;
        }
        if(httpSession.getAttribute("cart")!=null)
        {
            List<CartDTO> listCart=( List<CartDTO>)httpSession.getAttribute("cart");
            modelMap.addAttribute("listcart",listCart);
            modelMap.addAttribute("numbercar",listCart.size());
        }
        if(httpSession.getAttribute("user")!=null)
        {
            EmployeeDTO employeeDTO=(EmployeeDTO) httpSession.getAttribute("user");
            modelMap.addAttribute("iduer",employeeDTO.getIdemployee());
            System.out.print("idemployee"+employeeDTO.getIdemployee());
        }
        modelMap.addAttribute("detailproduct",listDetailProductDTO);
        modelMap.addAttribute("product",detailProductDTO);
        modelMap.addAttribute("idDetailProduct",idproduct);
        Map<String,Object> properties= buildMapProperties();
        Object[] objects=productSeriveceImp.searchProduct(properties,null,null,0,0);
        return modelAndView;
    }
    private Map<String,Object> buildMapProperties()
    {
        Map<String,Object> properties=new HashMap<String, Object>();
        Product product=new Product();
        product.setProductName("quần");
        properties.put("productName","quần");
        return properties;
    }

}
