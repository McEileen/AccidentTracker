package com.emsn.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Sql(value = {"/clean-database.sql"})
public class CarControllerTest {
    @Before
    public void setUp() throws Exception {
        RestAssured.port = 8001;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    // GET /api/persons
    public void shouldGetAllTheCars() throws Exception {
        get("/api/cars")
                .then()
                .statusCode(200)
                .body("numberOfElements", is(2));
    }

    @Test
    // GET /api/persons/:id
    public void shouldGetASingleCar() throws Exception {
        get("/api/cars/1")
                .then()
                .statusCode(200)
                .body("make", is("Toyota"));
    }

    @Test
    // POST /api/persons
    public void shouldCreateACar() throws Exception {
        Map<String, Object> json = new HashMap<>();
        json.put("make", "Toyota");
        json.put("model", "CRV");
        json.put("year", 1997);
        json.put("person_id", 1);
        given().
                contentType(ContentType.JSON).
                body(json).
                when().
                post("/api/cars")
                .then()
                .statusCode(200)
                .body("id", is(3));
    }
}