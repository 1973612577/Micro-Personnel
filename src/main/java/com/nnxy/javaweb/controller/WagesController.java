package com.nnxy.javaweb.controller;

import com.nnxy.javaweb.entity.Employee;
import com.nnxy.javaweb.entity.Wages;
import com.nnxy.javaweb.service.WagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WagesController {
    @Autowired
    WagesService wagesService;
    @RequestMapping("/wagesQueue")
    public @ResponseBody
    Map<String,Object> queue(){
        List<Wages> list=wagesService.queue();
        Map<String,Object>map=new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 1000);
        map.put("data", list);
        System.out.println(map);
        return map;
    }

    @RequestMapping("/wagesAdd")
    public String add(String id,String name,String basicWage,String matters,
                      String detailed,String operation,String finalWage
                      ){
        Wages wages=new Wages();
        wages.setId(id);
        wages.setName(name);
        wages.setBasicWage(basicWage);
        wages.setMatters(matters);
        wages.setDetailed(detailed);
        wages.setOperation(operation);
        wages.setFinalWage(finalWage);
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        wages.setTime(dateString);
        System.out.println(wages);
        wagesService.add(wages);
        return "redirect:http://101.200.193.98:8080/html/wages.html";
    }
}
