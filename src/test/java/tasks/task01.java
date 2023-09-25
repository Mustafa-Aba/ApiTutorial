package tasks;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class task01 {
    /*
        Given
            http://api.zippopotam.us/ES/01001
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin  "country": "Spain" içerdiğini doğrula


     */

    public static void main(String[] args) {

    }

    @Test
    public void test01() {

        String baseUri = "http://api.zippopotam.us/ES/01001";

        Response response = given() // request ler buraya yazılır
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when() // http methodlar
                .get(baseUri)
                .then().extract().response(); // kontrol gercekleştiği return  validatableresponse

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().get("country"), "Spain");
    }
    @Test
    public void test02() {

        String BASE_URI = "http://api.zippopotam.us/ES/01001";

        Response response = RestAssured.given() // request ler buraya yazılır
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParams("country", "Spain")
                .when() // http methodlar
                .get(BASE_URI)
                .then().extract().response(); // kontrol gercekleştiği return  validatableresponse

        Assert.assertEquals(response.statusCode(),200);

    }

}
