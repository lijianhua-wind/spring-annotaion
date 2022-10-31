package com.lijianhua.test;

import com.lijianhua.config.MainConfigOfLifeCycle;
import com.lijianhua.config.MainConfigOfPropertyValues;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author 李建华
 * @create 2022/10/30 15:28
 * @description 自己写
 * @since 1.0
 */
public class IOCPropertyValueTest {
    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test() {
        System.out.println("容器创建完成");
        printBeans();
        Object person = applicationContext.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
        //关闭容器
        applicationContext.close();
    }

    //打印所有定义的bean的name
    private void printBeans() {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
