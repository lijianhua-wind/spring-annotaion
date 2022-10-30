package com.lijianhua.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author 李建华
 * @create 2022/10/29 17:29
 * @description 自己写
 * @since 1.0
 */
public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //判断是否为Linux系统
        return context.getEnvironment().getProperty("os.name").contains("Linux");
    }
}
