package com.hoaiduc.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller

public class HomeAdminController
{
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView homePage()
    {
        ModelAndView modelAndView=new ModelAndView("admin/home");
        return  modelAndView;
    }

}
