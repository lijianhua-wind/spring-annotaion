package com.lijianhua.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author 李建华
 * @create 2022/10/30 11:50
 * @description 自己写
 * @since 1.0
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("Cat...constructor...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Cat...destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat...afterPropertiesSet...");
    }
}
