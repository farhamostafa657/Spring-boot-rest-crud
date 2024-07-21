package com.springboot.cruddemo.service;

import com.springboot.cruddemo.dao.EmployeeReposetry;
import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeSErvice{
    private EmployeeReposetry employeeReposetry;
    @Autowired
    public EmployeeServiceImpl(EmployeeReposetry theEmployeeReposetry){
        employeeReposetry=theEmployeeReposetry;
    }
    @Override
    public List<Employee> findAll() {
        return employeeReposetry.findAll();
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeReposetry.findById(theId);
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }else {
            throw new RuntimeException("emmployee not found "+theId );
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeReposetry.save(theEmployee);
    }

    @Override
    public void deleteById(int theID) {
        employeeReposetry.deleteById(theID);
    }
}
