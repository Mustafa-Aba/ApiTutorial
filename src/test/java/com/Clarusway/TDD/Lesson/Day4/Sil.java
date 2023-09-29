package com.Clarusway.TDD.Lesson.Day4;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class Sil {
    @Test
    public void test1() {

        RestAssured.baseURI = "https://b8f6b4fe-d407-4b27-ae74-b9deabe941ca.mock.pstmn.io"; // url created by postman mock service

        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/complex/body")
                .then()
                .statusCode(200)
                .extract().response();


        List<String> employees1Skills = response.path("company.employees[0].skills");
        System.out.println("employees1Skills = " + employees1Skills);

        List<String> pythonContainSkills = response.path("company.employees.findAll{ it.skills.contains('Python') }.skills");
        System.out.println("pythonContainSkills = " + pythonContainSkills);

        String employees1Name = response.path("company.employees.find{ it.id == 101}.name");
        System.out.println("employees1Name = " + employees1Name);


        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");
        response.path("");


        response.prettyPrint();
    }
}
