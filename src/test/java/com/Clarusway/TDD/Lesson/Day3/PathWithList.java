package com.Clarusway.TDD.Lesson.Day3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PathWithList {

    @Test
    public void pathWithList() {

        baseURI = "http://restapi.adequateshop.com";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/Customer")
                .then()
                .extract().response();


        int id1 = response.path("id[0]");  // Response list olan payloadlardan data cekip alabilmemiz icin index kullaniyoruz [Index]
        System.out.println("id1 = " + id1);

        int id4 = response.path("id[3]");
        System.out.println("id4 = " + id4);

        Assert.assertEquals(id1, 270230);

        String lastName = response.path("name[-1]"); // Gelen listeki son elemani bulabilmemiz icic - isaretini kullanabiliriz.
        System.out.println("lastName = " + lastName);


        List<Integer> databaseUserIDs = Arrays.asList(270230, 270229, 270227, 270226, 270224, 270223, 270221, 270219, 269615, 269611, 269609, 269605, 269604, 269596, 269595, 269594, 269593, 269592, 269591, 269590);

        List<Integer> idList = response.path("id"); // Gelen list seklindeki response index vermedigimiz durumda list refrance bagliyabiliyoruz.
        System.out.println("idList = " + idList);

        Assert.assertEquals(idList,databaseUserIDs);



        System.out.println("\n");
        System.out.println("--------------------------------");
        response.prettyPrint();
    }


}






























