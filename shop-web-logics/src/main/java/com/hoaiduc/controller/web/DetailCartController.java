package com.hoaiduc.controller.web;

import com.hoaiduc.core.dto.CartDTO;
import com.hoaiduc.core.dto.EmployeeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product-cart")
public class DetailCartController
{
        @GetMapping
        public ModelAndView Default(HttpSession httpSession, ModelMap modelMap)
        {
            ModelAndView modelAndView=new ModelAndView("product/cart");
            if(null!=httpSession.getAttribute("cart"))
            {
                List<CartDTO> listDetailCart=(List<CartDTO>)httpSession.getAttribute("cart");
                modelMap.addAttribute("detailcart",listDetailCart);

            }
            if(httpSession.getAttribute("user")!=null)
            {
                EmployeeDTO employeeDTO=(EmployeeDTO) httpSession.getAttribute("user");
                modelMap.addAttribute("iduer",employeeDTO.getIdemployee());
            }
            return modelAndView;
        }
}
