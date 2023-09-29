package com.Clarusway.TDD.Lesson.Day5;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class AdvancedExtraction {

    @Test
    public void advancedExtraction() {


        RestAssured.baseURI = "https://run.mocky.io/v3/ae3df516-5f31-43db-aa6e-eef438c08620";


        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then().extract().response();

        int maxAge = response.path("data.employees.age.max()");
        System.out.println("maxAge = " + maxAge);

        int minAge = response.path("data.employees.age.min()");
        System.out.println("minAge = " + minAge);

        List<String> nameList = response.path("data.employees.name");
        System.out.println("nameList = " + nameList);
        nameList.size();

        int sizeEmployees = response.path("data.employees.size()");
        System.out.println("sizeEmployees = " + sizeEmployees);

        int sumAges = response.path("data.employees.age.sum()");
        System.out.println("sumAges = " + sumAges);


        List<Integer> listAge = response.jsonPath().getList("data.employees.age");
        System.out.println("listAge = " + listAge);


        BigDecimal avgAges = response.path("data.employees.age.average()");
        System.out.println("avgAges = " + avgAges);


        List<Integer> evenAges = response.jsonPath().getList("data.employees.findAll { it.age % 2 == 0 }.age ");
        System.out.println("evenAges = " + evenAges);

        List<String> evenName = response.jsonPath().getList("data.employees.findAll { it.age % 2 == 0 }.name");
        System.out.println("evenName = " + evenName);

        String jhonDepartment = response.jsonPath().getString("data.employees.find { it.name.contains('John')  }.department");
        System.out.println("jhonDepartment = " + jhonDepartment);

     //   int evaRating = response.jsonPath().getInt("data.products[0].reviews.find { it.user.contains('Eva') }.rating");


        int evaRating = response.jsonPath().getInt("data.products[0].reviews.find {it.user.equals('Eva')}.rating");
        System.out.println("evaRating = " + evaRating);


        response.prettyPrint();
    }






}
