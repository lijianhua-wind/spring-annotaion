package com.lijianhua.test;

import com.lijianhua.bean.Person;
import com.lijianhua.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 李建华
 * @create 2022/10/29 14:47
 * @description 自己写
 * @since 1.0
 */
public class MainTest {

    public static void main(String[] args) {
        //以前使用配置文件开发使用的容器
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("classpath:bean.xml");
//        Object person = context.getBean("person");
//        System.out.println(person); //Person {name='张三', age=18}

        //注解开发使用的容器，传入配置类的class对象
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
        Person per = applicationContext.getBean(Person.class);
        System.out.println(per); //Person{name='lisi', age=99}

        //获取bean的id
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name); //person
        }
    }
}
