package com.nnxy.javaweb.controller;

import com.nnxy.javaweb.dao.AdminMapper;
import com.nnxy.javaweb.entity.Admin;
import com.nnxy.javaweb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminLoginController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String login(String adminname,String adminpwd){
        Admin admin=new Admin();
        admin.setAdminname(adminname);
        admin.setAdminpwd(adminpwd);
        System.out.println(admin);
        Boolean f=adminService.login(admin);
        if(f){
            return "redirect:http://101.200.193.98:8080/html/queue.html";
        }else
            return "redirect:http://101.200.193.98:8080/html/Error.html";
    }
}
