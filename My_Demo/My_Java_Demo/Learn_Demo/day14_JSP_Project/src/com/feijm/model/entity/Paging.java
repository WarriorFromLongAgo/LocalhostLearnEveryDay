package com.feijm.model.entity;

import java.util.List;

public class Paging<T> {
//    数据总条数
    private Integer totalCount;
//    分页数
    private Integer pageCount;
//    当前所在页
    private Integer currentPage;
//    数据
    private List<T> studentList;
//    每一页显示的数量
    private Integer pageShowAnCount;

    public Paging() {
    }

    public Paging(Integer totalCount, Integer pageCount, Integer currentPage, List<T> studentList, Integer pageShowAnCount) {
        this.totalCount = totalCount;
        this.pageCount = pageCount;
        this.currentPage = currentPage;
        this.studentList = studentList;
        this.pageShowAnCount = pageShowAnCount;
    }

    @Override
    public String toString() {
        return "Paging {" +
                "totalCount=" + totalCount +
                ", pageCount=" + pageCount +
                ", currentPage=" + currentPage +
                ", studentList=" + studentList +
                ", pageShowAnCount=" + pageShowAnCount +
                '}';
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<T> studentList) {
        this.studentList = studentList;
    }

    public Integer getPageShowAnCount() {
        return pageShowAnCount;
    }

    public void setPageShowAnCount(Integer pageShowAnCount) {
        this.pageShowAnCount = pageShowAnCount;
    }
}
