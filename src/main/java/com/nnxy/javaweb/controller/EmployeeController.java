package com.nnxy.javaweb.controller;

import com.nnxy.javaweb.entity.Employee;
import com.nnxy.javaweb.entity.EmployeeMove;
import com.nnxy.javaweb.service.EmployeeService;
import com.nnxy.javaweb.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    EmployeeMove employeeMove=new EmployeeMove();
    @RequestMapping("/queue")
    public @ResponseBody Map<String,Object> queue(Page page){
//        查询第1条到第10条的数据的sql是：select * from table limit 0,10;
// ->对应我们的需求就是查询第一页的数据：select * from table limit (1-1)*10,10;
//
//        查询第10条到第20条的数据的sql是：select * from table limit 10,10;
// ->对应我们的需求就是查询第二页的数据：select * from table limit (2-1)*10,10;
//getpage是得到跳转前端分页的第几页，getlimit是得到一页显示多少条数据
       page.setPage( ((page.getPage()-1)*page.getLimit()));
        List<Employee> list=employeeService.queue(page);
        Map<String,Object>map=new HashMap<>();

        //通过查询表中全部数据获取条数
        Integer number=employeeService.count();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", number);
        map.put("data", list);
        System.out.println(map);

        return map;
    }

    @RequestMapping("/movequeue")
    //部门调整信息
    public @ResponseBody Map<String,Object> movequeue(){
        List<EmployeeMove> list=employeeService.movequeue();
        Map<String,Object>map=new HashMap<>();
        int number=list.size();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", number);
        map.put("data", list);
        System.out.println(map);
        return map;
    }
    @RequestMapping("/add")
    public String add(String id,String name,String sex,String age,
                                  String department,String nation,String birthday,
                                  String education,String number,String bankid,String address){

        int intage=Integer.parseInt(age);//因为age是int类型，所以需要把string转成int
        Employee e=new Employee();
        e.setId(id);
        e.setName(name);
        e.setSex(sex);
        e.setAge(intage);
        e.setDepartment(department);
        e.setNation(nation);
        e.setBirthday(birthday);
        e.setEducation(education);
        e.setDepartment(department);
        e.setNumber(number);
        e.setBankid(bankid);
        e.setAddress(address);
        System.out.println("--------------");
        System.out.println(e);
        employeeService.add(e);
        return "redirect:http://101.200.193.98:8080/html/queue.html";
    }
    @RequestMapping("/del")
    @ResponseBody
    public String del(String id){
        System.out.printf(id);
        Integer flag=employeeService.del(id);
        if(flag>0){
            return "success";

        }else
            return "error";
    }

    @RequestMapping("/getid")
    @ResponseBody
    public void getid(String id,String name,String department){
        employeeMove.setId(id);
        employeeMove.setName(name);
        employeeMove.setOldDepartment(department);
    }

    @RequestMapping("/getdepart")
    public String getdepart(String department,String because){
        employeeMove.setNewDepartment(department);
        employeeMove.setBecause(because);
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        employeeMove.setTime(dateString);
        System.out.println(employeeMove);
        //实现移动
        Boolean b=employeeService.move(employeeMove);
        //往调整的数据库里面加这次部门调动的数据
        employeeService.moveadd(employeeMove);
        return "redirect:http://101.200.193.98:8080/html/queue.html";
    }
}
