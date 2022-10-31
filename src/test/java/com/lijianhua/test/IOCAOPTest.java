package com.lijianhua.test;

import com.lijianhua.aop.MathCalculator;
import com.lijianhua.config.MainConfigOfAOP;
import com.lijianhua.config.MainConfigOfLifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 李建华
 * @date 2022/10/31
 * @comment
 */
public class IOCAOPTest {



    @Test
    void testLifeCycle() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        System.out.println("容器创建完成");
        MathCalculator calculator
                = applicationContext.getBean(MathCalculator.class);
        System.out.println(calculator.div(1, 1));
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
