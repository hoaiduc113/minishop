package com.hoaiduc.controller.web;

import com.hoaiduc.core.constant.CoreConstant;
import com.hoaiduc.core.dto.EmployeeDTO;
import com.hoaiduc.core.dto.ProductDTO;
import com.hoaiduc.core.persistence.data.entity.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class HomeController
{
    RestTemplate restTemplate=new RestTemplate();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage(HttpSession httpSession, ModelMap modelMap)
    {
        UriComponentsBuilder builder=UriComponentsBuilder.fromHttpUrl(CoreConstant.LINK+"product/")
        .queryParam("id",0);
        List<LinkedHashMap<String,Object>>  List;
        Set<ProductDTO> productDTOList=new HashSet<ProductDTO>();
        ModelAndView modelAndView=new ModelAndView("web/home");
        if(httpSession.getAttribute("user")!=null)
        {
            EmployeeDTO employeeDTO=(EmployeeDTO) httpSession.getAttribute("user");
            String theFirstChacracter=employeeDTO.getEmail().substring(0,1);
            modelMap.addAttribute("chacracter",theFirstChacracter);
        }
        List=restTemplate.getForObject(builder.toUriString(), List.class);

        for(LinkedHashMap<String,Object> productDTO:List)
        {
            ProductDTO dto=new ProductDTO();
            dto.setDescribes(productDTO.get("describes").toString());
            dto.setGender(productDTO.get("gender").toString());
            dto.setIdProduct(Integer.parseInt(productDTO.get("idProduct").toString()));
            dto.setImage(productDTO.get("image").toString());
            dto.setPrice(productDTO.get("price").toString());
            dto.setProductName(productDTO.get("productName").toString());
            productDTOList.add(dto);

        }
        modelMap.addAttribute("listproduct",productDTOList);
        modelMap.addAttribute("paging",paging());
        return modelAndView;

    }
    //pagination
    private double paging()
    {
        List<LinkedHashMap<String,Object>>  List;
        List=restTemplate.getForObject(CoreConstant.LINK+"paging",List.class);
        double number= Math.ceil((double) List.size() / CoreConstant.MAXPAGINATION);
        if(number>= CoreConstant.MAXPAGINATION)
        {
            return CoreConstant.MAXPAGINATION;
        }

        return number;
    }
}
