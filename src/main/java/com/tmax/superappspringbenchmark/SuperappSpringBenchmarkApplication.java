package com.tmax.superappspringbenchmark;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SuperappSpringBenchmarkApplication implements CommandLineRunner {
    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(SuperappSpringBenchmarkApplication.class, args);
    }

    @Override
    public void run(String[] args) throws Exception {
        System.out.println("port : " + env.getProperty("server.tomcat.port"));
        System.out.println("keep-alive-timeout : " + env.getProperty("server.tomcat.keep-alive-timeout"));
        System.out.println("max-keep-alive-requests : " + env.getProperty("server.tomcat.max-keep-alive-requests"));
        System.out.println("max-connections : " + env.getProperty("server.tomcat.max-connections"));
        System.out.println("max-threads : " + env.getProperty("server.tomcat.max-threads"));
    }
}
