package com.hoaiduc.controller.web;

import com.hoaiduc.core.dto.CartDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product-checkout")

public class CheckOutController
{
    @GetMapping
    public ModelAndView Default(HttpSession httpSession, ModelMap modelMap)
    {
        ModelAndView modelAndView=new ModelAndView("product/checkout");
        if(null!=httpSession.getAttribute("cart"))
        {
            List<CartDTO> cartDTOList=(List<CartDTO>)httpSession.getAttribute("cart");
            modelMap.addAttribute("checkout",cartDTOList);
        }
        return modelAndView;
    }
}
