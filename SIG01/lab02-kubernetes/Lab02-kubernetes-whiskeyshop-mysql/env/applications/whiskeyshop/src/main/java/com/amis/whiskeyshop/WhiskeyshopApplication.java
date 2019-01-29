package com.amis.whiskeyshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@SpringBootApplication
public class WhiskeyshopApplication implements CommandLineRunner {

    @Autowired
    private Environment environment;

    @Autowired
    DataSource dataSource;

    private static String serverPort;

    @Override
    public void run(String... args) throws Exception {
        serverPort = System.getProperty("server.port");
        System.out.println("\n----main----");

        System.out.println("----System Properties from VM Arguments----");
        System.out.println("server.port: " + serverPort);
        System.out.println("----Program Arguments----");
        for (String arg: args) {
            System.out.println(arg);
        }

        if (environment != null) {
            getActiveProfiles();
            System.out.println("----Environment Properties----");
            System.out.println("spring.datasource.url: " + environment.getProperty("spring.datasource.url"));
            System.out.println("spring.datasource.username: " + environment.getProperty("spring.datasource.username"));
            System.out.println("spring.datasource.password: " + environment.getProperty("spring.datasource.password"));
            System.out.println("spring.jpa.database-platform: " + environment.getProperty("spring.jpa.database-platform"));
            System.out.println("spring.jpa.hibernate.ddl-auto: " + environment.getProperty("spring.jpa.hibernate.ddl-auto"));
        }

        if (dataSource != null) {
            System.out.println("dataSource: " + dataSource);
        }
        System.out.println("------------");
    }

    public static void main(String[] args) {
        SpringApplication.run(WhiskeyshopApplication.class, args);
    }

    private void getActiveProfiles() {
        for (final String profileName : environment.getActiveProfiles()) {
            System.out.println("Currently active profile - " + profileName);
        }
    }
}
