package com.emsn.models;

import com.emsn.enums.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {
    private int id;
    private String name;
    private int age;
    private String gender;
    private double payment;
    private List<Car> cars;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Person() {
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    @JsonManagedReference
    public List<Car> getCars() {return cars;}
    public void setCars(List<Car> cars) {this.cars = cars;}

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
