package com.lijianhua.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Color类的factoryBean
 * @author 李建华
 * @create 2022/10/30 10:59
 * @description 自己写
 * @since 1.0
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    //返回一个color对象，这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    //是否为单例？
    //true：这个bean是单实例，在容器中保存一份
    //false：多实例，每次获取都会创建一个新的bean
    @Override
    public boolean isSingleton() {
        return true;
    }
}
