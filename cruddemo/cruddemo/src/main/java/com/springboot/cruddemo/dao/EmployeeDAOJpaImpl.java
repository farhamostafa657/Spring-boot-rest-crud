package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDao{
    //define field for entitymaneger
    private EntityManager entityManager;

    //set up,constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;

    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
        List<Employee>employees=theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //getEmployee
        Employee theEmployee=entityManager.find(Employee.class,theId);
        //return Emplouee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee=entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theID) {
     Employee emp=entityManager.find(Employee.class,theID);
     entityManager.remove(emp);
    }
}
