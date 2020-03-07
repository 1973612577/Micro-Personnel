package com.nnxy.javaweb;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        String s="-110";
        int i=Integer.parseInt(s);
        System.out.println(i);
        Date d=new Date();
        //使用SimpleDateFormat的对象里面的方法将Date转成字符串类型
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(d);
        System.out.println(d);
        System.out.println("*********************");
        System.out.println(dateString);
    }
}
