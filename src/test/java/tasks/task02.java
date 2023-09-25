package tasks;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class task02 {
    /*
      Given
            https://reqres.in/api/users/2
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body de
        "data.email": "jaaaanet.weaver@reqres.in"
        "first_name":"Janet",
        "last_name":"Weaver"
            olduğu doğrula
     */

    @Test
    public void test1(){
        String base_url="https://reqres.in/api/users/2";

        Response response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParam("data.email","jaaaanet.weaver@reqres.in")
                .queryParam("first_name","Janet")
                .queryParam("first_name","Janet")
                .when()
                .get(base_url)
                .then().extract().response();

        Assert.assertEquals(response.getStatusCode(),200);
    }

@Test
    public void test2(){
        String base_url="https://reqres.in/api/users/2";

        Map<String,Object> myQuery = new HashMap<>();

        myQuery.put("data.email","jaaaanet.weaver@reqres.in");
        myQuery.put("first_name","Janet");
        myQuery.put("last_name","Weaver");

        Response response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParams(myQuery)
                .when()
                .get(base_url)
                .then().extract().response();

        Assert.assertEquals(response.getStatusCode(),200);

        response.prettyPrint();
    }
    @Test
    public void test3(){
        String base_url="https://reqres.in/api/users/2";
        Response response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(base_url)
                .then().extract().response();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().get("data.email"),"jaaaanet.weaver@reqres.in");
        Assert.assertEquals(response.jsonPath().get("first_name"),"Janet");
        Assert.assertEquals(response.jsonPath().get("last_name"),"Weaver");

    }
    @Test
    public void test4(){
        String base_url="https://reqres.in/api/users/2";
        Response response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(base_url)
                .then().extract().response();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.path("data.email"),"jaaaanet.weaver@reqres.in");
        Assert.assertEquals(response.path("first_name"),"Janet");
        Assert.assertEquals(response.path("last_name"),"Weaver");

    }




}
