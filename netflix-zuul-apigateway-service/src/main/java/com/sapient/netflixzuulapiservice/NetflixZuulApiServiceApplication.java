package com.sapient.netflixzuulapiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class NetflixZuulApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixZuulApiServiceApplication.class, args);
    }

}
