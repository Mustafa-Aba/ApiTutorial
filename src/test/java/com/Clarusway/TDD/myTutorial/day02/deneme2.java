package com.Clarusway.TDD.myTutorial.day02;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class deneme2 {
    public static void main(String[] args) {
        System.out.println("working");
    }


    @Test

    public void getTest1(){

        /*
         * Given accept type is Json
         * And Id parameter value is 3
         * When user sends GET request to /api/users/{id}
         * Then response status code should be 200
         * And response content-type: application/json
         * And "emma.wong@reqres.in" should be in response payload
         */

        Response response= RestAssured.given()// (request) -- vermek istediğimiz bilgiler
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)

                .when()// (get-post-put-delete) -- yapmak istediğimiz işlem

                .get("https://reqres.in/api/users/3");



        response.prettyPeek();

        Assert.assertEquals(response.statusCode(),200);
        //Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        Assert.assertTrue(response.getBody().asString().contains("emma.wong@reqres.in"));






    }
}
