package com.dpi.projectutil;


import com.yyc.ycloud.base.serviceproxy.config.EnableServiceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableServiceProxy
public class ProjectUtilApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectUtilApplication.class, args);
    }

    @Bean(name = "restTemplateRemote")
    public RestTemplate restTemplateRemote(){
        return  new RestTemplate();
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }


}
