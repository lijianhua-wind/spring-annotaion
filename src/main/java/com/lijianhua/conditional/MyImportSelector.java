package com.lijianhua.conditional;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * 自定义importSelector，自定义逻辑返回需要导入的组件
 *
 * @author 李建华
 * @create 2022/10/29 21:57
 * @description 自己写
 * @since 1.0
 */
public class MyImportSelector implements ImportSelector {

    /**
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return 导入到容器中的组件全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //返回blue，yellow类
        return new String[]{"com.lijianhua.bean.Blue", "com.lijianhua.bean.Yellow"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return ImportSelector.super.getExclusionFilter();
    }
}
