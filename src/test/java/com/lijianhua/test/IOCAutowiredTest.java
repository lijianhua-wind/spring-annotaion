package com.lijianhua.test;

import com.lijianhua.bean.Boss;
import com.lijianhua.bean.Car;
import com.lijianhua.config.MainConfigOfAutowired;
import com.lijianhua.config.MainConfigOfLifeCycle;
import com.lijianhua.dao.BookDAO;
import com.lijianhua.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 李建华
 * @create 2022/10/30 16:15
 * @description 自己写
 * @since 1.0
 */
public class IOCAutowiredTest {
    @Test
    void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        //测试是否注入成功
//        Boss boss = applicationContext.getBean(Boss.class);
//        System.out.println(boss.getCar() == applicationContext.getBean(Car.class));
//
//        System.out.println(boss.getCar() == applicationContext.getBean(BookDAO.class).getCar());
        //关闭容器
        applicationContext.close();
    }
}
