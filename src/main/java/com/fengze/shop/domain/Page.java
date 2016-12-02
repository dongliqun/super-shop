package com.fengze.shop.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页模型类
 * @param <T>
 */
@Data
public class Page<T> {
    private int totalPage;     // total pages 总页数
    private int pageSize = 2; // page Size 每页显示页数
    private int totalRecord;   // total record 总记录(每个页面显示的信息个数之和)
    private int currentPage = 1;  // current page 当前页
    private int startIndex; // 上一页
    private List<T> list = new ArrayList<T>();  // page data
    private int startPage; //首页
    private int endPage; //尾页


    public Page(int currentPage, int totalRecord) {
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
// 总页数=(总记录数+每页显示页数-1)/每页显示页数
        this.totalPage = (this.totalRecord + this.pageSize - 1) / this.pageSize;
//
        // get data from startIndex in DB
        this.startIndex = (this.currentPage - 1) * this.pageSize;

        if (this.totalPage < 10) {
            this.startPage = 1;
            this.endPage = this.totalPage;
        } else {
            this.startPage = currentPage - 4;
            this.endPage = currentPage + 5;

            if (this.startPage < 1) {
                this.startPage = 1;
                this.endPage = 10;
            }

            if (this.endPage > this.totalPage) {
                this.endPage = this.totalPage;
                this.startPage = this.totalPage - 9;
            }
        }
    }


}
