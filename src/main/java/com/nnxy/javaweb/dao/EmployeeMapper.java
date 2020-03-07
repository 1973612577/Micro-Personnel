package com.nnxy.javaweb.dao;

import com.nnxy.javaweb.entity.Employee;
import com.nnxy.javaweb.entity.EmployeeMove;
import com.nnxy.javaweb.util.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    @Select("select * from employee limit #{page},#{limit}")
    List<Employee> queue(Page page);
    @Select("select count(1) from employee")
    Integer count();

    @Select("select * from employeemove order by time desc")
    List<EmployeeMove> movequeue();

    @Insert("insert into employee(id,name,sex,age,department,nation," +
            "birthday,education,number,bankid,address)values(#{id},#{name}," +
            "#{sex},#{age},#{department},#{nation},#{birthday},#{education},#{number},#{bankid},#{address})")
     Integer add(Employee employee);

    @Insert("insert into employeemove(id,name,oldDepartment,newDepartment,because,time)" +
            "values(#{id},#{name},#{oldDepartment},#{newDepartment},#{because},#{time})")
    Integer moveadd(EmployeeMove employeeMove);

    @Delete("delete from employee where  id=#{id}")
    Integer deflag(String id);

    @Update("update employee set department=#{newDepartment} where id=#{id}")
    Integer move(EmployeeMove employeeMove);


}
