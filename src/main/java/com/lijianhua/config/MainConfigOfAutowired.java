package com.lijianhua.config;

import com.lijianhua.bean.Car;
import com.lijianhua.bean.Red;
import com.lijianhua.dao.BookDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配
 *          Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值
 * 1. @AutoWired：自动注入：
 *      1）、默认优先按照类型去容器中找对应的组件：applicationContext.getBean(BookDAO.class);找到就赋值。
 *      2）、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找。
 *           applicationContext.getBean("bookDAO");
 *      3）、@Qualifier("bookDAO2")：使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 *      4）、自动装配默认一定要将属性赋值好，没有就会报错；
 *           可以使用@Autowired(required=false);
 *      5）、@Primary：让Spring进行自动装配的时候，默认使用首选（标注了@Primary注解）的bean，
 *           但是@Qualifier指定id的优先级大于@Primary。
 *
 *      BookService{
 *          @Qualifier("bookDAO2")
 *          @Autowired(required=false)
 *          BookDAO bookDAO;
 *      }
 * @author 李建华
 * @create 2022/10/30 16:12
 * @description 自己写
 * @since 1.0
 */
@Configuration
@ComponentScan(basePackages = {"com.lijianhua.controller",
        "com.lijianhua.dao", "com.lijianhua.service", "com.lijianhua.bean"})
public class MainConfigOfAutowired {

    @Bean("bookDAO2")
    @Primary
    public BookDAO bookDAO(Car car) {
        System.out.println("我造的车" + car);
        BookDAO bookDAO = new BookDAO();
        bookDAO.setMark("2");
        bookDAO.setCar(car);
        return bookDAO;
    }

    @Bean
    public Red red() {
        return new Red();
    }
}
