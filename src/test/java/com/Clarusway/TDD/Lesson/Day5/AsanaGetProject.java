package com.Clarusway.TDD.Lesson.Day5;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AsanaGetProject {


    @Test
    public void getProject() {

        baseURI = "https://app.asana.com";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("project_gid", 1205559894337547l)
                .header("authorization", "Bearer 1/1205499783701562:fdbd84e64b537174381567109bb742b5")
                .when()
                .get("/api/1.0/projects/{project_gid}")
                .then()
                .extract().response();


        String followerName = response.path("data.followers[0].name");
        System.out.println("followerName = " + followerName);





        response.prettyPrint();
    }




}
