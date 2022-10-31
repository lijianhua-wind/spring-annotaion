package com.lijianhua.bean;

import org.springframework.stereotype.Component;

/**
 * @author 李建华
 * @create 2022/10/30 11:30
 * @description 自己写
 * @since 1.0
 */
@Component
public class Car {

    public Car() {
        System.out.println("Car constructor....");
    }

    public void init() {
        System.out.println("Car init....");
    }

    public void destroy() {
        System.out.println("Car destroy....");
    }


}
