package com.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_Name")
    private String firstNmae;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name="email")
    private String email;

    //define constructor
    public Employee(){

    }

    public Employee(String firstNmae, String lastName, String email) {
        this.firstNmae = firstNmae;
        this.lastName = lastName;
        this.email = email;
    }
//define setter&getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstNmae() {
        return firstNmae;
    }

    public void setFirstNmae(String firstNmae) {
        this.firstNmae = firstNmae;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //define toString

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstNmae='" + firstNmae + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
