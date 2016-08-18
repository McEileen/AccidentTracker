package com.emsn.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    private int id;
    private String make;
    private String model;
    private int year;
    private Person person;


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    public Person getPerson() {return person;}
    public void setPerson(Person person) {this.person = person;}

    public Car() {
    }

//    public Car(String make, String model, int year) {
//        this(make, model, year, null);
//    }
//
//    public Car(String make, String model, int year, Person person) {
//        this.make = make;
//        this.model = model;
//        this.year = year;
//        this.person = person;
//    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
