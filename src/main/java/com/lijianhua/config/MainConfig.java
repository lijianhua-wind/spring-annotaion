package com.lijianhua.config;

import com.lijianhua.bean.Person;
import com.lijianhua.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author 李建华
 * @create 2022/10/29 14:50
 * @description 自己写
 * @since 1.0
 */
//配置类 == 配置文件
@Configuration  //告诉spring这是一个配置类
@ComponentScans(value = {
        @ComponentScan(value = {"com.lijianhua"}, excludeFilters = {
                //排除@Controller的组件
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,
//                classes = {Controller.class})
        }, includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION,
//                        classes = Controller.class),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
//                        classes = BookService.class),
                @ComponentScan.Filter(type = FilterType.CUSTOM,
                        classes = MyTypeFilter.class)
        }, useDefaultFilters = false)
})
//@ComponentScan
// 1. value：指定要扫描的包
// 2. excludeFilters：指定规则排除组件
// 3. includeFilters：指定扫描的时候只需要哪些组件，
// 还需要配置useDefaultFilters为false，不然默认扫描所有组件。
//@ComponentScan可以重复多配置几个，也可以使用
//@ComponentScans配置多个@componentScan
public class MainConfig {

    //给容器中注册一个bean
    @Bean("person")
    public Person person01() {
        return new Person("lisi", 99);
    }
}
