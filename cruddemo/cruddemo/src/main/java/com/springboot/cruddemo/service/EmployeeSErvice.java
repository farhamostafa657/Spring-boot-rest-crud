package com.springboot.cruddemo.service;

import com.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeSErvice {
    List<Employee> findAll();
    Employee findById(int theId);

    Employee save(Employee theEmployee);
    void deleteById(int theID);
}
