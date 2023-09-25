package com.Clarusway.TDD.myTutorial.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RecapPathQuery {


    @Test
    public void path() {

        baseURI = "http://restapi.adequateshop.com";


        Response response = given()  // Shirli birinci kelimem
                .contentType(ContentType.JSON) // Gonderdigim body nin Json dilinde oldugunu soyluyorum.
                .accept(ContentType.JSON) // Gelen response un Json dilinde gelmesini soyluyorum.
                .pathParam("id", 270223) // End point icersinde ki degerin degismesini bu method sayesinde yapiyorum.
                .when() // Shirli ikinci gelimem   Given ile arasinda gondermek istedigim bilgileri koyuyorum.
                .get("/api/Customer/{id}") // Hangi request yapcagimi belirtiyorum
                .then() // Shirli ucuncu kelimem When ile arasinda methodumu belirtiyorum  Then den sonra assertion islemlerini yapiyorum
                .extract().response(); // Then kelimesinden sonra Response responsa baglama islemi yapmamami sagliyor.


        int id = response.path("id"); // Path method ile responsun icersinde ki id yi disariya cikarttik
        Assert.assertEquals(id, 270223); // Kontrol noktasinda testing gecip gecmedigini belirledik gelen deger ve bekledigimiz deger

        String name = response.path("name");
        Assert.assertEquals(name, "Shakeel");

        String email = response.path("email");
        Assert.assertEquals(email, "shakeel@gmail.com");


        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertTrue(response.headers().hasHeaderWithName("Date"));


        //   response.prettyPeek(); // Gelen responsun ciktisini header ile birlikte almamizi sagliyor.
        response.prettyPeek(); // Gelen responsun sadece bodysinin ciktisini almamizi sagliyor.

    }


    @Test
    public void querParam() {
        baseURI = "http://restapi.adequateshop.com";


        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParam("city","london")
                .when()
                .get("/api/Metadata/GetUsersByParam")
                .then()
                .extract().response();

        response.prettyPrint();
    }
}
