package com.hendisantika.springbootdatabasecacheexample;

import com.hendisantika.springbootdatabasecacheexample.entity.Employee;
import com.hendisantika.springbootdatabasecacheexample.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching      // to enable spring cache
public class SpringBootDatabaseCacheExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDatabaseCacheExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(EmployeeRepository repo) {
        return args -> {
            repo.save(new Employee(1L, "Uzumaki Naruto", "Hokage"));
            repo.save(new Employee(2L, "Uchiha Sasuke", "Jounin"));
            repo.save(new Employee(3L, "Haruno Sakura", "Jounin"));
            repo.save(new Employee(4L, "Hatake Kakashi", "Ex-Hokage"));
        };
    }
}
