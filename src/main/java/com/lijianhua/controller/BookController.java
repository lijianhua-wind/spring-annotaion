package com.lijianhua.controller;

import com.lijianhua.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 李建华
 * @create 2022/10/29 15:15
 * @description 自己写
 * @since 1.0
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
