package com.nhnacademy.mvc.config;

import com.nhnacademy.mvc.Base;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
        basePackageClasses = Base.class,
        excludeFilters = @ComponentScan.Filter(Controller.class)
)
public class RootConfig {
}
