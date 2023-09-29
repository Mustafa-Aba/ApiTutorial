package com.Clarusway.TDD.Lesson.Day5;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ComplexResponseExtraction {


    @Test
    public void extraction() {

        baseURI = "https://b8f6b4fe-d407-4b27-ae74-b9deabe941ca.mock.pstmn.io";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/complex/body")
                .then()
                .extract().response();


        List<String> skills = response.path("company.employees[0].skills");
        System.out.println("skills = " + skills);




        response.prettyPrint();
    }


}
