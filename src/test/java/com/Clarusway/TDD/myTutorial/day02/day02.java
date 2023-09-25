package com.Clarusway.TDD.myTutorial.day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class day02 {

    public static void main(String[] args) {
        System.out.println("working");
    }


    @Test

    public void autoInitial() {

        Response response = RestAssured.given()// (request) -- vermek istediğimiz bilgiler
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                //.pathParam("id",3)
                .when()// (get-post-put-delete) -- yapmak istediğimiz işlem
                .get("http://restapi.adequateshop.com/api/Customer")
                .then().extract().response();

//        response.prettyPeek();
//        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

        String responseBody = response.asString();
        //System.out.println("responseBody = " + responseBody);

        boolean bodyIdCheck = responseBody.contains("270469");
        System.out.println("test = " + bodyIdCheck);

        Assert.assertTrue(bodyIdCheck);

        boolean dateAssert = response.headers().hasHeaderWithName("Date");
        Assert.assertTrue(dateAssert);
        System.out.println("dateAssert = " + dateAssert);


    }

    @Test
    public void test2() {

        /*
         * Given accept type is Json
         * And Id parameter value is 3
         * When user sends GET request to /api/users/{id}
         * Then response status code should be 200
         * And response content-type: application/json
         * And "emma.wong@reqres.in" should be in response payload
         */


        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

        String responseString = response.asString();

        Assert.assertTrue(responseString.contains("emma.wong@reqres.in"));

        //Assert.assertTrue(response.jsonPath().get("data.email"), "emma.wong@reqres.in");

        response.prettyPeek();


    }

}
