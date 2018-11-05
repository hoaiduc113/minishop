package com.hoaiduc.controller.admin;

import com.hoaiduc.core.constant.CoreConstant;
import com.hoaiduc.core.dto.CategoryDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin-product")

public class AddProductController {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ModelAndView homePage(ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView("admin/product/product");
        List<CategoryDTO> categoryDTOList = restTemplate.getForObject(CoreConstant.LINK + "categorys", List.class);
        modelMap.addAttribute("listcategory", categoryDTOList);
        return modelAndView;
    }
}

