package TestBack;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

import com.google.gson.JsonObject;

import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class PUTTest {
    @Test
    public void putReqRes() {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("name", "NUEVOPACE");
        requestBody.addProperty("job", "CAMBIADO");

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("https://reqres.in/api/users/2")
                .then().statusCode(200)
                .log().status()
                .log().body();
    }

    @Test
    public void put_2() {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("name", "NUEVOPACE");
        requestBody.addProperty("job", "CAMBIADO");

        Response responseBody = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("https://reqres.in/api/users/2");

        responseBody.then().statusCode(200)
                .body("name", equalTo("NUEVOPACE"))
                .body("updatedAt", containsString("2023-09-05"));

        System.out.println("EL NOMBRE MODIFICADO ES: " + responseBody.jsonPath().getString("name"));
        System.out.println("EL TRABAJO MODIFICADO ES: " + responseBody.jsonPath().getString("job"));
        System.out.println("EL CÓDIGO DE RESPUESTA ES: " + responseBody.statusCode());
        System.out.println("EL SERVICIO SE TARDO: " + responseBody.getTime() + " MILISEGUNDOS");
    }
}
