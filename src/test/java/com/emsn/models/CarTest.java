package com.emsn.models;

import org.apache.catalina.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldGetAndSetIdOnCar() throws Exception {
        Car p = new Car();
        p.setId(3);
        assertEquals(3, p.getId());
    }


    @Test
    public void shouldGetAndSetMakeOnCar() throws Exception {
        Car t = new Car();
        t.setMake("Henrietta");
        assertEquals("Henrietta", t.getMake());
    }

    @Test
    public void shouldGetAndSetModelOnCar() throws Exception {
        Car t = new Car();
        t.setModel("Kia");
        assertEquals("Kia", t.getModel());
    }

    @Test
    public void shouldGetAndSetYearOnCar() throws Exception {
        Car t = new Car();
        t.setYear(1990);
        assertEquals(1990, t.getYear());
    }


}