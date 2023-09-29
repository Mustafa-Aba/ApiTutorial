package com.Clarusway.TDD.Lesson.Day6;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class NewYorkTimes_TopStories_Home {


    String token = "aXuKTczQxN0se3bikElcJAq0Bo5p5Xd3";

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://api.nytimes.com/svc";
    }


    @Test
    public void getHome() {


        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParams("api-key", token)
                .pathParam("section", "home")
                .when()
                .get("/topstories/v2/{section}.json")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("status", is("OK"))
               // .body("results[0].url", is("https://www.nytimes.com/2023/09/23/nyregion/bob-menendez-indictment-bribery-investigation.html"))
               // .body("results.size()", equalTo(33))
                .body("results.published_date", everyItem(startsWith("2023")) )





                .extract().response();





        int size = response.path("results.size()");
        System.out.println("size = " + size);


        response.prettyPeek();
    }


}
