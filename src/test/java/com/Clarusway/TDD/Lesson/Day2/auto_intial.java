package com.Clarusway.TDD.Lesson.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class auto_intial {


    @Test
    public void test1() {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("http://restapi.adequateshop.com/api/Customer")
                .then()
                .extract().response();


        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");


        String responseBody = response.asString();

        boolean bodyIdCheck = responseBody.contains("269512");

        Assert.assertTrue(bodyIdCheck);

        boolean dateAssert = response.headers().hasHeaderWithName("Date");

        Assert.assertTrue(dateAssert);

        response.prettyPeek();

    }


    @Test
    public void test2() {


        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

        String responseString = response.asString();

        Assert.assertTrue(responseString.contains("emma.wong@reqres.in"));


        response.prettyPeek();

    }






}
