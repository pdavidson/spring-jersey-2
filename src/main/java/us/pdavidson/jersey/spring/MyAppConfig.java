package us.pdavidson.jersey.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    @Bean
    MySpringBean mySpringBean() {
        return new MySpringBean();
    }
}
