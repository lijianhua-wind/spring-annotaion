package com.lijianhua.config;

import com.lijianhua.bean.Color;
import com.lijianhua.bean.ColorFactoryBean;
import com.lijianhua.bean.Person;
import com.lijianhua.bean.Red;
import com.lijianhua.conditional.LinuxCondition;
import com.lijianhua.conditional.MyImportBeanDefinitionRegistrar;
import com.lijianhua.conditional.MyImportSelector;
import com.lijianhua.conditional.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author 李建华
 * @create 2022/10/29 16:15
 * @description 自己写
 * @since 1.0
 */
@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//import导入组件，id默认是组件的全类名
public class MainConfig2 {

    //默认为单实例

    /**
     * 能取的值
     * ConfigurableBeanFactory.SCOPE_PROTOTYPE, prototype
     * ConfigurableBeanFactory.SCOPE_SINGLETON, singleton
     * org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST, request
     * org.springframework.web.context.WebApplicationContext.SCOPE_SESSION, session
     * <p>
     * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。
     * 每次获取的时候才会调用方法创建对象
     * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中，
     * 以后每次获取就是直接从容器(map.get())中拿
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     * 其他两个不会用到
     * <p>
     * 懒加载
     */
    //    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Lazy
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加person......");
        return new Person("张三", 25);
    }

    /**
     * @Conditional：按照一定的条件进行判断，满足条件给容器中注册bean 如果系统是windows，给容器中注册("bill")
     * 如果系统是linux系统，给容器中注册("linus")
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02() {
        return new Person("linus", 48);
    }


    //注册factoryBean组件
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
