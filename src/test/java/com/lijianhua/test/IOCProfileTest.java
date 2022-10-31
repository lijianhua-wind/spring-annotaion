package com.lijianhua.test;

import com.lijianhua.config.MainConfigOfAutowired;
import com.lijianhua.config.MainConfigOfProfile;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 李建华
 * @date 2022/10/31
 * @comment
 */
public class IOCProfileTest {

    @Test
    void test01() {
        //二. 使用代码的方式切换环境
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        //1. 创建一个applicationContext
        //2. 设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("dev");
        //3. 注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4. 启动刷新容器
        applicationContext.refresh();
        printBeans(applicationContext);
        //关闭容器
        applicationContext.close();
    }

    private void printBeans(ApplicationContext applicationContext) {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
