package com.Clarusway.TDD.myTutorial.day04;

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

        Assert.assertEquals(id1, 270704);

        String lastName = response.path("name[-1]"); // Gelen listeki son elemani bulabilmemiz icin - isaretini kullanabiliriz.
        System.out.println("response.path(\"name[-2]\") = " + response.path("name[-2]")); // Gelen listeki sondan ikinci elemani
        System.out.println("lastName = " + lastName);


        List<Integer> expectedDatabaseUserIDs = Arrays.asList(270704, 270702, 270701, 270700, 270699,
                270698, 270697, 270696, 270695, 270694, 270693, 270692, 270691, 270690, 270689, 270688, 270687, 270686, 270685, 270684);

        List<Integer> idList = response.path("id"); // Gelen list seklindeki response index vermedigimiz durumda list refrance bagliyabiliyoruz.
        System.out.println("idList = " + idList);

        Assert.assertEquals(idList,expectedDatabaseUserIDs);



        System.out.println("\n");
        System.out.println("--------------------------------");
        response.prettyPrint();
    }


}






























