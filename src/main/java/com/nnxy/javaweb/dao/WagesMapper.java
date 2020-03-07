package com.nnxy.javaweb.dao;

import com.nnxy.javaweb.entity.Employee;
import com.nnxy.javaweb.entity.Wages;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WagesMapper {

    @Insert("insert into wages(id,name,basicWage,matters,detailed,operation," +
            "finalWage,time)values(#{id},#{name}," +
            "#{basicWage},#{matters},#{detailed},#{operation},#{finalWage},#{time})")
    Integer add(Wages wages);

    @Select("select * from wages order by tip desc")
    List<Wages> queue();
}
