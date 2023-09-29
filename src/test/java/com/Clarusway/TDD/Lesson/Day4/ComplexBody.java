package com.Clarusway.TDD.Lesson.Day4;

import io.restassured.RestAssured;
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

    @Test
    public void test2(){

        Response response = given()
                .accept(ContentType.JSON)// ben sana request gönderdiğimde sadece JSON kabul ediyorum
                .contentType(ContentType.JSON) // JSON göndercem hemde
                //bu ikisini en baştan söylüyoruz
                .when()
                .get("https://reqres.in/api/users")
                //artık gideceği nooktayı belirtiyorum
                .then()
                .extract().response();


        response.prettyPrint();
    }
}
