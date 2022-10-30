package com.lijianhua.test;

import com.lijianhua.bean.Car;
import com.lijianhua.config.MainConfig2;
import com.lijianhua.config.MainConfigOfLifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 李建华
 * @create 2022/10/30 11:32
 * @description 自己写
 * @since 1.0
 */
public class IOCLifeCycleTest {

    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

    @Test
    void testLifeCycle() {
        System.out.println("容器创建完成");
        //关闭容器
        applicationContext.close();
    }
}
