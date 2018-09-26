package com.hendisantika.springbootdatabasecacheexample.service;

import com.hendisantika.springbootdatabasecacheexample.entity.Employee;
import com.hendisantika.springbootdatabasecacheexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Cacheable(value = "employees")           // it will cache result and key name will be "employees"
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @CacheEvict(value = "employees", allEntries = true)      // It will clear cache when delete any employee to database
    public void delete(long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        employee.ifPresent(employee1 -> employeeRepository.deleteById(employeeId));
    }

    @Override
    @CacheEvict(value = "employees", allEntries = true)       // It will clear cache when new employee save to database
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}