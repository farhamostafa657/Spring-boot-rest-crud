package com.crm.demo.entity;

public class Student {
    private String firtName;
    private String lastName;

    public Student(){

    }

    public Student(String firtName, String lastName) {
        this.firtName = firtName;
        this.lastName = lastName;

    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
