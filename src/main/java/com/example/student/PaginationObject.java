package com.example.student;

import java.util.List;

public class PaginationObject<T> {
    private List<T> list;
    private Integer totalPage;


    public PaginationObject(List<T> list, Integer totalPage) {
        this.list = list;
        this.totalPage = totalPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }



    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
