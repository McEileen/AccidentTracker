package com.emsn.models;

import com.emsn.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;


public class PersonTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

//    @Test
//    public void shouldCreateAnInstanceOfPerson() throws Exception {
//        Person t = new Person();
//        assertThat(t, instanceOf(Person.class));
//    }


    @Test
    public void shouldGetAndSetIdOnPerson() throws Exception {
        Person p = new Person();
        p.setId(3);
        assertEquals(3, p.getId());
    }


    @Test
    public void shouldGetAndSetNameOnPerson() throws Exception {
        Person t = new Person();
        t.setName("Henrietta");
        assertEquals("Henrietta", t.getName());
    }

    @Test
    public void shouldGetAndSetAgeOnPerson() throws Exception {
        Person t = new Person();
        t.setAge(17);
        assertEquals(17, t.getAge());
    }

    @Test
    public void shouldGetAndSetGenderOnPerson() throws Exception {
        Person t = new Person();
        t.setGender("F");
        assertEquals("F", t.getGender());
    }

    @Test
    public void shouldGetAndSetPayment() throws Exception {
        Person t = new Person();
        t.setPayment(50.00);
        assertEquals(50.00, t.getPayment(), 0.00);
    }
    
}