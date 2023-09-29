package com.Clarusway.TDD.Lesson.Day5;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class BasicDataExtraction {

    @BeforeClass
    public void setUp() {
        baseURI = "http://restapi.adequateshop.com";
    }


    @Test
    public void path1() {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", 270321)
                .when()
                .get("/api/Customer/{id}")
                .then()
                .extract().response();

        int id = response.path("id");
        String name = response.path("name");

        Assert.assertEquals(id, 270321);

        response.prettyPrint();
    }


    @Test
    public void pathWithList() {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/Customer")
                .then()
                .extract().response();

        int id1 = response.path("id[0]");
        System.out.println("id1 = " + id1);

        List<Integer> idList = response.path("id");
        System.out.println("idList = " + idList);

        int lastID = response.path("id[-1]");
        System.out.println("lastID = " + lastID);


        response.prettyPrint();
    }


    @Test
    public void pathComplex() {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/Feed/GetNewsFeed")
                .then()
                .extract().response();

        String location1 = response.path("data[0].location");
        System.out.println("location1 = " + location1);

        response.prettyPrint();
    }


    @Test
    public void semiComplex() {
        baseURI = "https://b8f6b4fe-d407-4b27-ae74-b9deabe941ca.mock.pstmn.io";


        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/semiComplex")
                .then()
                .extract().response();

        String message = response.path("message");
        System.out.println("message = " + message);

        String user_profileName= response.path("user_profile.name");
        System.out.println("user_profileName = " + user_profileName);


        String mom1= response.path("user_profile.Data[0].mom_name");
        System.out.println("mom1 = " + mom1);





        System.out.println("-------------");
        System.out.println("\n");
        response.prettyPrint();
    }





}
