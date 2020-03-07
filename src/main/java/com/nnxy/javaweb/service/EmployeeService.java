package com.nnxy.javaweb.service;

import com.nnxy.javaweb.dao.EmployeeMapper;
import com.nnxy.javaweb.entity.Employee;
import com.nnxy.javaweb.entity.EmployeeMove;
import com.nnxy.javaweb.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> queue(Page page){
        List<Employee>list= new ArrayList<>();
        list=employeeMapper.queue(page);
        return list;
    }
    public List<EmployeeMove> movequeue(){
        List<EmployeeMove>list= new ArrayList<>();
        list=employeeMapper.movequeue();
        return list;
    }
    public void add(Employee employee){
        Integer i= employeeMapper.add(employee);
        System.out.println(i);
    }
    public void moveadd(EmployeeMove employeeMove){
        Integer i= employeeMapper.moveadd(employeeMove);
        System.out.println(i);
    }
    public Integer del(String id){
        Integer i= employeeMapper.deflag(id);
        System.out.println("service:"+i);
        return i;
    }


    public Boolean move(EmployeeMove employeeMove){
        Integer f=employeeMapper.move(employeeMove);
        if(f>0){
            return true;
        }else
            return false;
    }

    public int count() {//调用这个获得数据库中的总条数方便分页条数的划分
        Integer n=employeeMapper.count();
        return n;
    }
}
