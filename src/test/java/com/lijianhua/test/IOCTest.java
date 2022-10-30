package com.lijianhua.test;

import com.lijianhua.bean.Blue;
import com.lijianhua.bean.Color;
import com.lijianhua.bean.Person;
import com.lijianhua.config.MainConfig;
import com.lijianhua.config.MainConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import java.util.Map;

/**
 * @author 李建华
 * @create 2022/10/29 15:17
 * @description 自己写
 * @since 1.0
 */
public class IOCTest {

    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void testImport() {
        printBeans();
//        Blue bean = applicationContext.getBean(Blue.class);
//        System.out.println(bean);
        //工厂bean获取的是调用getObject创建的对象，只在获取bean的时候才会调用getObject方法
        Color bean = (Color) applicationContext.getBean("colorFactoryBean");
        Color bean2 = (Color) applicationContext.getBean("colorFactoryBean");
        System.out.println(bean.getClass()); //class com.lijianhua.bean.Color
        System.out.println(bean == bean2); //设置为单实例，true，设置为多实例，false
        //获取工厂bean本身，在注册工厂bean的id前加&号
        /*
            为什么呢？看源码，FACTORY_BEAN_PREFIX的前缀就是&
            public interface BeanFactory {
            String FACTORY_BEAN_PREFIX = "&";
         */
        Object factoryBean = applicationContext.getBean("&colorFactoryBean");
        System.out.println(factoryBean.getClass());  //class com.lijianhua.bean.ColorFactoryBean
    }

    //打印所有定义的bean的name
    private void printBeans() {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        //获取容器中所有bean的name
        for (String name : names) {
            System.out.println(name);
            /*
            org.springframework.context.annotation.internalConfigurationAnnotationProcessor
            org.springframework.context.annotation.internalAutowiredAnnotationProcessor
            org.springframework.context.annotation.internalCommonAnnotationProcessor
            org.springframework.context.event.internalEventListenerProcessor
            org.springframework.context.event.internalEventListenerFactory
            mainConfig
            bookController
            bookDAO
            bookService
            person
             */
        }
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("容器初始化完成");
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);
//        String[] names = applicationContext.getBeanDefinitionNames();
        //获取容器中所有bean的name
//        for (String name : names) {
//            System.out.println(name);
//        }

//        Object person = applicationContext.getBean("person");
//        Object person2 = applicationContext.getBean("person");
//        System.out.println(person2 == person); //默认为单实例：true
    }

    @Test
    void test03() {
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值：获取操作系统名 Windows 10
        String osName = environment.getProperty("os.name"); //
        System.out.println(osName);
        for (String name : names) {
            System.out.println(name);
        }

        Map<String, Person> map = applicationContext.getBeansOfType(Person.class);
        System.out.println(map);
    }
}
