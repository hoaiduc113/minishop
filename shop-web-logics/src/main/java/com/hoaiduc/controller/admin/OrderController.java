package com.hoaiduc.controller.admin;

import com.hoaiduc.core.constant.CoreConstant;
import com.hoaiduc.core.dto.BillDTO;
import com.hoaiduc.core.dto.DetailBillDTO;
import com.hoaiduc.core.persistence.data.entity.DetailProduct;
import com.hoaiduc.core.service.impl.BillServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin-order")
public class OrderController
{
    @Autowired
    BillServiceImp billServiceImp;
    RestTemplate restTemplate=new RestTemplate();

    @GetMapping
    public ModelAndView Default(HttpSession httpSession, ModelMap modelMap)
    {
        ModelAndView modelAndView=new ModelAndView("admin/product/order");
        List<BillDTO> billDTOList=restTemplate.getForObject(CoreConstant.LINK+"limitbills",List.class);
        if(billDTOList!=null)
        {

            modelMap.addAttribute("listbill",billDTOList);
        }
    //    List<DetailProduct> detailProducts=billServiceImp.findDetailBillByID(23);
        return  modelAndView;
    }
}
