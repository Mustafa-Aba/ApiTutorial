package com.Clarusway.TDD.myTutorial.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ComplexBody {


    @Test
    public void complexBody1() {

        baseURI = "http://restapi.adequateshop.com";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParam("page", 55)
                .when()
                .get("/api/Tourist")
                .then()
                .extract().response();

        int pageNumber = response.path("page");
        Assert.assertEquals(pageNumber, 55);

        String firstDataName = response.path("data.tourist_name[0]");
        System.out.println("firstDataName = " + firstDataName);



        response.prettyPrint();


    }
}
