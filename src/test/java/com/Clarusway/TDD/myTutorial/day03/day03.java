package com.Clarusway.TDD.myTutorial.day03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class day03 {

    public static void main(String[] args) {
        System.out.println("working");
    }

    @Test
    public void Path_Param_Test() {

        baseURI = "https://reqres.in"; //import static io.restassured.RestAssured.baseURI; yapılabilir

        Response response = given()//import static io.restassured.RestAssured.given; yapılabilir
                .contentType(ContentType.JSON)
                .pathParam("id", 3)
                .when()
                .get("/api/users/{id}")//RestAssured.baseURI="https://reqres.in"; tanımlandığından sadece "/api/users" yazmamız yeterli
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

    }

    @Test
    public void Path_Method() {
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
        System.out.println("id = " + id);//logger.info("id = " + id);

        String name = response.path("name");
        System.out.println("name = " + name);


        String email = response.path("email");
        System.out.println("email = " + email);

        String location = response.path("location");
        System.out.println("location = " + location);

        Assert.assertEquals(id, 269511);
        Assert.assertEquals(name, "Mike");
        Assert.assertEquals(email, "mike12@gmail.com");
        Assert.assertEquals(location, "Paris");

        response.prettyPrint();
    }


    @Test
    public void Query_Param_Test() {

        baseURI = "http://restapi.adequateshop.com";

        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("page", 1)
                .when()
                .get("/api/Tourist")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        response.prettyPeek();

        // For loop kullanım örneği
//        for (int i = 1; i < 627; i++) {
//            Response response1 = given()
//                    .contentType(ContentType.JSON)
//                    .queryParams("page",i)
//                    .when()
//                    .get("/api/Tourist")
//                    .then()
//                    .extract().response();
//            Assert.assertEquals(response1.statusCode(), 200);
//            Assert.assertEquals(response1.contentType(), "application/json; charset=utf-8");
//        }

    }

    @Test
    public void query_Params_With_Map() {

        baseURI = "https://b8f6b4fe-d407-4b27-ae74-b9deabe941ca.mock.pstmn.io";

        Map<String, Object> myQuery = new HashMap<>();// sıralama önemli olmadığından hız için Hashmap tercih edildi.
        // Map myQuery = new HashMap<>();// boylede yapılabilir Map<Object,Object> olur

        myQuery.put("keyword", "computer");
        myQuery.put("category", "phones");

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParams(myQuery)
                .when()
                .get("/search")
                .then()
                .extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        response.prettyPeek();
    }


}
