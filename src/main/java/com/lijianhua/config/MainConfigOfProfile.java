package com.lijianhua.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.lijianhua.bean.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.stream.Stream;

/**
 * @author 李建华
 * @date 2022/10/31
 * @comment
 */
@Profile("dev")
@PropertySource(value = {"classpath:dbconfig.properties"})
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private String driver;

    @Bean
    public Yellow yellow() {
        return new Yellow();
    }



    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String password) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(user);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        druidDataSource.setDriverClassName(driver);
        return druidDataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String password) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(user);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/student_manager?serverTimezone=UTC");
        druidDataSource.setDriverClassName(driver);
        return druidDataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String password) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(user);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/mybatis_plus?serverTimezone=UTC");
        druidDataSource.setDriverClassName(driver);
        return druidDataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.driver = resolver.resolveStringValue("${db.driver}");
    }
}
