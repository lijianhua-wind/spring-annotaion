package com.lijianhua.dao;

import org.springframework.stereotype.Repository;

/**
 * @author 李建华
 * @create 2022/10/29 15:16
 * @description 自己写
 * @since 1.0
 */
@Repository
public class BookDAO {

    private String mark = "1";

    public BookDAO() {
    }

    public BookDAO(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "BookDAO{" +
                "mark='" + mark + '\'' +
                '}';
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
