package com.lijianhua.conditional;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否为windows系统
 * @author 李建华
 * @create 2022/10/29 17:16
 * @description 自己写
 * @since 1.0
 */
public class WindowsCondition implements Condition {

    /**
     * ConditionContext：判断条件能使用的上下文（环境）
     * AnnotatedTypeMetadata：注释信息
     * @param context the condition context
     * @param metadata the metadata of the {@link org.springframework.core.type.AnnotationMetadata class}
     * or {@link org.springframework.core.type.MethodMetadata method} being checked
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //是否window系统
        //1. 能获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2. 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3. 获取环境信息
        Environment environment = context.getEnvironment();
        //4. 获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        //可以判断容器中bean注册情况，也可以给容器中注册bean
        boolean person = registry.containsBeanDefinition("person");
        //判断是否为windows系统
        String osName = environment.getProperty("os.name");
        assert osName != null;
        return osName.contains("Windows");
    }
}
