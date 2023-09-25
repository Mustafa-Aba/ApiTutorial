package com.Clarusway.TDD.Lesson.Day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class BasicDataExtraction {


    @Test
    public void path1() {

        baseURI = "http://restapi.adequateshop.com";


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

        baseURI = "http://restapi.adequateshop.com";


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
}
