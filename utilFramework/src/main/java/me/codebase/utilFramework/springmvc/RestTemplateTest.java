package me.codebase.utilFramework.springmvc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;


@Configuration
//@EnableWebMvc
public class RestTemplateTest {

    static AnnotationConfigApplicationContext context = null;

    public static void main(String[] args) throws IOException {
        context = new AnnotationConfigApplicationContext();
        context.scan("me.codebase.utilFramework.springmvc");
        context.start();
        System.out.println(System.in.read());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
