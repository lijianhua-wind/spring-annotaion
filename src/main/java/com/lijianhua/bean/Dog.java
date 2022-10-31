package com.lijianhua.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 李建华
 * @create 2022/10/30 14:18
 * @description 自己写
 * @since 1.0
 */
@Component
public class Dog implements ApplicationContextAware {

    ApplicationContext applicationContext;

    public Dog() {
        System.out.println("Dog...constructor...");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init() {
        System.out.println("Dog...init...");
    }

    //容器移除对象之前
    @PreDestroy
    public void destroy() {
        System.out.println("Dog...destroy...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
