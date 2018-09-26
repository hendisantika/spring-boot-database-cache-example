package com.hendisantika.springbootdatabasecacheexample.controller;

import com.hendisantika.springbootdatabasecacheexample.entity.Employee;
import com.hendisantika.springbootdatabasecacheexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-database-cache-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/09/18
 * Time: 07.18
 * To change this template use File | Settings | File Templates.
 */
@RestController     // for rest response
public class EmployeeController {
    @Autowired
    private CacheManager cacheManager;      // autowire cache manager

    @Autowired
    private EmployeeService employeeService;

    // to add new employee
    @RequestMapping(value = "save", method = RequestMethod.POST)     // or user @GetMapping
    public Employee save(Employee employee) {
        return employeeService.save(employee);
    }

    // list of all employee
    @RequestMapping(value = "listEmployee", method = RequestMethod.GET)   // or use @GetMapping
    public java.util.List<Employee> listEmployee() {
        return employeeService.findAll();
    }

    // delete specific employee using employee id
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)        // or use @DeleteMapping
    public void delete(@RequestParam("id") long id) {
        employeeService.delete(id);
    }

    // clear all cache using cache manager
    @RequestMapping(value = "clearCache")
    public void clearCache() {
        for (String name : cacheManager.getCacheNames()) {
            cacheManager.getCache(name).clear();
        }
    }
}