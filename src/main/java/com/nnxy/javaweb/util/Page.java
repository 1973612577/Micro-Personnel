package com.nnxy.javaweb.util;

public class Page {//工具类
    private Integer page;//页码的参数名称，默认：page
    private Integer limit;//每页数据量的参数名，默认：limit

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }
}
