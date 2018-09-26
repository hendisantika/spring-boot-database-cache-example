package com.hendisantika.springbootdatabasecacheexample.service;

import com.hendisantika.springbootdatabasecacheexample.entity.Employee;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-database-cache-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/09/18
 * Time: 07.14
 * To change this template use File | Settings | File Templates.
 */
public interface EmployeeService {
    List<Employee> findAll();

    Employee save(Employee employee);

    void delete(long employeeId);
}
