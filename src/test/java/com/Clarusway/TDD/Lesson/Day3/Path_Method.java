package com.Clarusway.TDD.Lesson.Day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class Path_Method {


    @Test
    public void test1() {

        baseURI = "http://restapi.adequateshop.com";


        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", 269511)
                .when()
                .get("/api/Customer/{id}")
                .then()
                .extract().response();


        int id = response.path("id");
    //    System.out.println("id = " + id);

        String name = response.path("name");
    //    System.out.println("name = " + name);


        String email = response.path("email");
 //       System.out.println("email = " + email);

        String location = response.path("location");
      //  System.out.println("location = " + location);




        Assert.assertEquals(id, 269511);
        Assert.assertEquals(name, "Mike");
        Assert.assertEquals(email, "mike12@gmail.com");
        Assert.assertEquals(location, "Paris");



    //    response.prettyPrint();
    }


}
