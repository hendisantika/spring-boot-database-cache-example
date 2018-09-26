package com.hendisantika.springbootdatabasecacheexample.repository;

import com.hendisantika.springbootdatabasecacheexample.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-database-cache-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/09/18
 * Time: 07.13
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAll();
}