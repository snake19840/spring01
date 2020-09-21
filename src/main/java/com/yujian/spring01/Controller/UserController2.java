package com.yujian.spring01.Controller;


import com.yujian.spring01.Entity.Users;
import com.yujian.spring01.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jpa")
public class UserController2 {
    @Autowired
 private UserService userService;
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page, @ModelAttribute("users") Users users){

        return page;
    }

    @RequestMapping("/findById")
    public String findById(Users users, Model model){
        System.out.println("-------------------");
        System.out.println(users.getId());

        System.out.println(this.userService.findUserById(users.getId()));
        System.out.println(this.userService.findUserById(users.getId()));
        Users u=this.userService.findUserById(users.getId());
        model.addAttribute("success" ,u);
        return "input2";
    }





}
