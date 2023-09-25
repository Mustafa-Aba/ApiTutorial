package myWorks;

import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API_GetRequest {
    public static void main(String[] args) {

    }
    @Test
    public void get01(){
      String url="https://jsonplaceholder.typicode.com/posts/44";
      JSONObject expectBody = new JSONObject();
      expectBody.put("userId",5);
      expectBody.put("title","expected body");

      Response response=given().when().get(url);

        response.prettyPeek();

    }


}
