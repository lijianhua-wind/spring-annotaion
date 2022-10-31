package com.lijianhua.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 李建华
 * @date 2022/10/31
 * @comment
 */
@Component
public class Boss {

    private Car car;

    public Boss() {
        System.out.println("boss...无参构造器...");
    }

//    @Autowired
    public Boss(/*@Autowired*/ Car car) {
        System.out.println("boss...有参构造器...");
        this.car = car;
    }


    public Car getCar() {
//        System.out.println("get方法。。。。。");
        return car;
    }

    @Autowired
    public void setCar(/*@Autowired*/ Car car) {
        System.out.println("boss...set方法");
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
