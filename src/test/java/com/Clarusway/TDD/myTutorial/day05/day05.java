package com.Clarusway.TDD.myTutorial.day05;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class day05 {
//
//    @BeforeClass // Test anotation methodları çalışmadan önce buna iat setup metodu çalışır
//    public void setUp()  {
//        baseURI = "http://restapi.adequateshop.com"; // sürekli yazmaktan kurtulduk
//
//    }
    @Test
    public void test1(){

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", 270321)
                .when()
                .get("/api/Customer/{id}")
                .then()
                .extract().response();


        int id= response.path("id");
       String name= response.path("name");

       Assert.assertEquals(id,270321);
       Assert.assertEquals(name,270321);


    }
    @Test
    public void pathWithList(){


        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/Customer")
                .then()
                .extract().response();
        int id1= response.path("id[0]");
        System.out.println("id1 = " + id1);

        List<Integer> idList=response.path("id");
        System.out.println("idList = " + idList);

        int lastID= response.path("id[-1]");
        System.out.println("lastID = " + lastID);

        response.prettyPrint();

    }

    @Test
    public void pathComplex(){

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/Feed/GetNewsFeed")
                .then()
                .extract().response();

        String location1= response.path("data[0].location");
        System.out.println("location1 = " + location1);

        response.prettyPrint();

    }

    @Test
    public void semiComplex() {

        baseURI = "https://b8f6b4fe-d407-4b27-ae74-b9deabe941ca.mock.pstmn.io";


        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/semiComplex")
                .then()
                .extract().response();

        String message = response.path("message");
        System.out.println("message = " + message);

        String user_profileName= response.path("user_profile.name");
        System.out.println("user_profileName = " + user_profileName);


        String mom1= response.path("user_profile.Data[0].mom_name");
        System.out.println("mom1 = " + mom1);

        String dad2=response.path("user_profile.Data[1].dad_name");
        System.out.println("dad2 = " + dad2);


        System.out.println("-------------");
        System.out.println("\n");
        response.prettyPrint();
    }
    @Test
    public void getProject() {

        baseURI = "https://app.asana.com";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("project_gid", "1205562491164471")
                .header("authorization", "Bearer 1/1205562726254993:aff98f0a02a9afbfe7ffff7bb90825d2")
                .when()
                .get("/api/1.0/projects/{project_gid}")
                .then()
                .extract().response();


        String followerName = response.path("data.followers[0].name");
        System.out.println("followerName = " + followerName);


        response.prettyPrint();
    }

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
    @Test
    public void advancedExtraction() {


        RestAssured.baseURI = "https://run.mocky.io/v3/ae3df516-5f31-43db-aa6e-eef438c08620";


        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then().extract().response();

        int maxAge = response.path("data.employees.age.max()");// path("groovy language from java")
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

//***************************************//
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

        int evaRating1 = response.jsonPath().getInt("data.products[0].reviews.find { it.user.contains('Eva') }.rating");
        System.out.println("evaRating1 = " + evaRating1);

        int evaRating = response.jsonPath().getInt("data.products[0].reviews.find {it.user.equals('Eva')}.rating");
        System.out.println("evaRating = " + evaRating);


        response.prettyPrint();
    }


}
