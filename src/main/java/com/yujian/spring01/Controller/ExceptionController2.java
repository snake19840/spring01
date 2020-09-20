package com.yujian.spring01.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController2 {
    @RequestMapping("/showUsers")
    public String showUsers(){
        String str=null;
        str.length();
        return "index";
    }

    @RequestMapping("/showUsers2")
    public String showUsers2(){
       int a=100/0;
        return "index";
    }

}
