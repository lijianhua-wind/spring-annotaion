package com.lijianhua.service;

import com.lijianhua.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author 李建华
 * @create 2022/10/29 15:16
 * @description 自己写
 * @since 1.0
 */
@Service
public class BookService {

    @Qualifier("bookDAO")
    @Autowired(required=false)
    private BookDAO bookDAO;

    public void print() {
        System.out.println("bookDAO：" + bookDAO);
    }
}
