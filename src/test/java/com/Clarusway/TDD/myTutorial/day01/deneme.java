package com.Clarusway.TDD.myTutorial.day01;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class deneme {
    public static void main(String[] args) {
        System.out.println("working");
    }


    @Test

    public void test1(){

       RestAssured.given()// (request) -- vermek istediğimiz bilgiler


                .when()// (get-post-put-delete) -- yapmak istediğimiz işlem


                .then();// (Assortion) -- kontrol işleminin gercekleştiği yer

    }
    @Test

    public void test2(){

        Response response= RestAssured.given()// (request) -- vermek istediğimiz bilgiler
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)

                .when()// (get-post-put-delete) -- yapmak istediğimiz işlem

                .get("http://restapi.adequateshop.com/api/Customer")

                .then()// (Assortion) -- kontrol işleminin gercekleştiği yer
                .extract().response(); // validatableresponse return eder

        response.prettyPeek();

    }
}
