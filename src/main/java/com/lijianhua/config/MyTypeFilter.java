package com.lijianhua.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义  TypeFilter 供 ComponentScan：FilterType.CUSTOM使用
 *
 * @author 李建华
 * @create 2022/10/29 15:53
 * @description 自己写
 * @since 1.0
 */
public class MyTypeFilter implements TypeFilter {

    /**
     * 会扫描到@ComponentScan指定包的所有类
     *
     * @param metadataReader        读取到的当前正在扫描的类的信息。the metadata reader for the target class
     * @param metadataReaderFactory 可以获取到其他类的信息。a factory for obtaining metadata readers
     *                              for other classes (such as superclasses and interfaces)
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前正在扫描的类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源（如类的路径）
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("-->" + className);
        //如果className包含er，就扫描
        return className.contains("er");
    }
}
