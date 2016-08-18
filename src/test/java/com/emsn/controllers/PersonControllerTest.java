package com.emsn.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Sql(value = {"/clean-database.sql"})
public class PersonControllerTest {
    @Before
    public void setUp() throws Exception {
        RestAssured.port = 8001;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    // GET /api/persons
    public void shouldGetAllThePersons() throws Exception {
        get("/api/persons")
                .then()
                .statusCode(200)
                .body("id", is(2));
    }

    @Test
    // GET /api/persons/:id
    public void shouldGetASinglePerson() throws Exception {
        get("/api/persons/1")
                .then()
                .statusCode(200)
                .body("name", is("Bob"));
    }

////    will finish this test after creating join relationships
//    @Test
//    // GET /api/persons/:id
//    public void givenASinglePerson_returnPersonsCars() throws Exception {
//        get("/api/persons/1")
//                .then()
//                .statusCode(200)
//                .body("content.cars[0].id", is(1));
//    }

    @Test
    // POST /api/persons
    public void shouldCreateAPerson() throws Exception {
        Map<String, Object> json = new HashMap<>();
        json.put("name", "John");
        json.put("age", 19);
        json.put("gender", "M");
        json.put("payment", "50.00");

        given().
                contentType(ContentType.JSON).
                body(json).
                when().
                post("/api/persons")
                .then()
                .statusCode(200)
                .body("id", is(3));
    }
}