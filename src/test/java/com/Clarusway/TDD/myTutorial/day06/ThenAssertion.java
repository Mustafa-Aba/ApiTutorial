package com.Clarusway.TDD.myTutorial.day06;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ThenAssertion {

    @Test
    public void thenAssertion() {

        baseURI = "http://restapi.adequateshop.com";

        Response response = given()

                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)

                .when()

                .get("/api/Tourist")
                .then()// then den sonra assertion yapılır. Hamcrest metodları kullanılır

                .statusCode(200)
                .header("Pragma", "no-cache")
                .header("Date", is(not(nullValue())))
                .body("page",is(1))
                .body("data[0].tourist_name",equalTo("ezgi6445"))
                .body("data[2].tourist_email",is("Jessie_Veum65@gmail.com"))
                .extract().response();

        //2. yol
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.headers().hasHeaderWithName("Pragma"));
        Assert.assertTrue(response.headers().hasHeaderWithName("Date"));

        int pageNo=response.path("page");
        Assert.assertEquals(pageNo,1);

        String touristName=response.path("data[0].tourist_name");
        Assert.assertEquals(touristName,"ezgi6445");



        response.prettyPrint();
    }
}
