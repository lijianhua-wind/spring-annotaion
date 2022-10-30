package com.lijianhua.conditional;

import com.lijianhua.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义ImportBeanDefinitionRegistrar
 *
 * @author 李建华
 * @create 2022/10/29 22:17
 * @description 自己写
 * @since 1.0
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata：当前类的注解信息
     * BeanDefinitionRegistry：BeanDefinition注册类：
     * 把所有需要添加到容器中的bean：调用
     * BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     *
     * @param importingClassMetadata annotation metadata of the importing class
     * @param registry               current bean definition registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.lijianhua.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.lijianhua.bean.Blue");
        //如果容器中存在id为com.lijianhua.bean.Red和com.lijianhua.bean.Blue的组件，
        //注册RainBow
        if (red && blue) {
            //指定bean定义信息：（bean的类型，bean的scope）创建RootBeanDefinition对象
            RootBeanDefinition rainBow = new RootBeanDefinition(RainBow.class);
            //注册一个bean，指定bean名
            registry.registerBeanDefinition("rainBow", rainBow);
        }
    }
}
