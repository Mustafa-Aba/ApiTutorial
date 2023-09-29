package com.Clarusway.TDD.Lesson.Day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Path_And_Query_Param {

    @Test
    public void test3() {

        baseURI = "https://reqres.in";


        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id", 3)
                .when()
                .get("/api/users/{id}")
                .then()
                .extract().response();


        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");


        response.prettyPeek();
    }


    // Base url degisti
    @Test
    public void test4() {

        baseURI = "http://restapi.adequateshop.com";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParams("page", 627)
                .when()
                .get("/api/Tourist")
                .then()
                .extract().response();


        response.prettyPrint();
    }


    @Test
    public void test5() {

        baseURI = "https://b8f6b4fe-d407-4b27-ae74-b9deabe941ca.mock.pstmn.io";

        Map<String,Object> myQuery = new HashMap<>();

        myQuery.put("keyword","computer");
        myQuery.put("category","phones");



        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParams(myQuery)
                .when()
                .get("/search")
                .then()
                .extract().response();


        response.prettyPeek();
    }



}
