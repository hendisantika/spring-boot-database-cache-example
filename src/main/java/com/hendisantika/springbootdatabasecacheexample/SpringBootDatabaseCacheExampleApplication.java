package com.hendisantika.springbootdatabasecacheexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching      // to enable spring cache
public class SpringBootDatabaseCacheExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDatabaseCacheExampleApplication.class, args);
    }
}
