package com.nnxy.javaweb.service;

import com.nnxy.javaweb.dao.WagesMapper;
import com.nnxy.javaweb.entity.Employee;
import com.nnxy.javaweb.entity.Wages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WagesService {
    @Autowired
    WagesMapper wagesMapper;
    public void add(Wages wages){
        Integer i= wagesMapper.add(wages);
        System.out.println(i);
    }

    public List<Wages> queue(){
        List<Wages>list= new ArrayList<>();
        list=wagesMapper.queue();
        return list;
    }
}
