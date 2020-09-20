package com.yujian.spring01.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
    @RequestMapping("/show")
    public String showInfo(){
        String str=null;
        str.length();
        return "index";
    }

    @RequestMapping("/show2")
    public String showInfo2(){
        int a=10/0;
        return "index";
    }

    /**
     * ExceptionHandle
     * java.lang.ArithmeticException:处理自述异常
     *该方法需要返回一个ModelAndView目的是可以让我们封装异常信息以及视图的指定
     * 参数Exception e:会将产生异常对象注入到方法中
     */

    @ExceptionHandler(value = java.lang.ArithmeticException.class)
    public ModelAndView arithmeticExceptionHandle(Exception e){
        ModelAndView mv =new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error1");
        return mv;
    }

    /**
     * ExceptionHandle
     * java.lang.NullPointerException.class:处理空指针异常
     *该方法需要返回一个ModelAndView目的是可以让我们封装异常信息以及视图的指定
     * 参数Exception e:会将产生异常对象注入到方法中
     */

    @ExceptionHandler(value = java.lang.NullPointerException.class)
    public ModelAndView nullPointerException(Exception e){
        ModelAndView mv =new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error2");
        return mv;
    }

}
