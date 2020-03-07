package com.nnxy.javaweb.service;

import com.nnxy.javaweb.dao.AdminMapper;
import com.nnxy.javaweb.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
    public Boolean login(Admin admin){
        Integer flag=adminMapper.flag(admin);
        System.out.println(flag);
        if(flag>0)
            return true;
        else
            return false;
    }
}
