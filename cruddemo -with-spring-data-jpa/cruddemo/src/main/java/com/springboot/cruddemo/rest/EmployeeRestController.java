package com.springboot.cruddemo.rest;

import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeSErvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeSErvice employeeSErvice;
    @Autowired
    public EmployeeRestController(EmployeeSErvice theEmployeeSErvice){
        employeeSErvice=theEmployeeSErvice;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeSErvice.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee=employeeSErvice.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Employee not fount - "+employeeId);
        }
        return theEmployee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //also just incase they pass an id in JSON...set id to 0
        //this is to force a save of new item ...insted of update
        theEmployee.setId(0);
        Employee dbEmployee=employeeSErvice.save(theEmployee);
        return  dbEmployee;
    }
    //add mapping for put /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee=employeeSErvice.save(theEmployee);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{theID}")
    public String deleteEmployee(@PathVariable int theID){
        Employee theEmployee=employeeSErvice.findById(theID);
        if(theEmployee==null){
            throw new RuntimeException("Employee id not found - "+theID);
        }
        employeeSErvice.deleteById(theID);
        return "Deleted Employee id - "+theID;
    }
}
