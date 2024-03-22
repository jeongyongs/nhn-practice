package com.nhnacademy.jpa.config;

import com.nhnacademy.jpa.Base;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
@ComponentScan(
        basePackageClasses = Base.class,
        excludeFilters = @ComponentScan.Filter(Controller.class)
)
public class RootConfig {
    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName("org.h2.Driver");
        basicDataSource.setUrl("jdbc:h2:~/dev/nhn-practice/mvc-jpa/db;" +
                "INIT=RUNSCRIPT from 'classpath:/script/schema.sql'");
        basicDataSource.setUsername("sa");
        basicDataSource.setPassword("");

        basicDataSource.setInitialSize(200);
        basicDataSource.setMaxTotal(200);
        basicDataSource.setMinIdle(200);
        basicDataSource.setMaxIdle(200);

        basicDataSource.setTestOnBorrow(true);
        basicDataSource.setTestOnReturn(true);
        basicDataSource.setTestWhileIdle(true);

        return basicDataSource;
    }
}
