package org.sang;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@Configuration
//@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(value = {"org.sang.controller"})
//@ComponentScan(basePackages = {})
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,classes = TypeExcludeFilter.class),@ComponentScan.Filter(type =FilterType.CUSTOM,classes = AutoConfigurationExcludeFilter.class)})
public class  LiuApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiuApplication.class, args);
    }
}
