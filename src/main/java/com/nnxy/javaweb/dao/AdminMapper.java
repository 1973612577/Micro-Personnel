package com.nnxy.javaweb.dao;

import com.nnxy.javaweb.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {
    @Select("select count(1) from admin where adminname= #{adminname} and adminpwd=#{adminpwd}")
    Integer flag(Admin admin);
}
