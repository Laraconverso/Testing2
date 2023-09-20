package TestBack;

import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.*;
import org.testng.Assert;

import com.google.gson.JsonObject;

import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class POSTTest {
    @Test
    public void postReqRes() {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("name", "SERGIOP");
        requestBody.addProperty("job", "Teacher");

        given()
                .contentType("application/json")
                .body(requestBody)
                .post("https://reqres.in/api/users")
                .then().statusCode(201)
                .log().status()
                .log().body();
    }

    @Test
    public void postTest_2() {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("name", "SERGIOPACE");
        requestBody.addProperty("job", "Student");

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("https://reqres.in/api/users")
                .then().statusCode(201)
                .log().status()
                .body("name", equalTo("SERGIOPACE"))
                .body("createdAt", containsString("2023-09-05"))
                .log().body();
    }

    @Test
    public void postTest_3() {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("name", "SERGIO");
        requestBody.addProperty("job", "leader");

        Response response = given().contentType("application/json").body(requestBody)
                .post("https://reqres.in/api/users");

        Assert.assertEquals(201, response.statusCode());

        System.out.println("EL NOMBRE DADO DE ALTA ES: " + response.jsonPath().getString("name"));
        System.out.println("EL TRABAJO DADO DE ALTA ES: " + response.jsonPath().getString("job"));
        System.out.println("EL SERVICIO SE TARDO: " + response.getTime() + " MILISEGUNDOS");
    }

    @Test
    public void loginTest_Fallido() {
        String urlReqRes = "https://reqres.in/api";
        String pathLogin = "/login";
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("email", "space@space.com");

        Response response = given().contentType("application/json").body(requestBody)
                .post(urlReqRes + pathLogin);

        Assert.assertEquals(400, response.statusCode());
        response.then().body("error", equalTo("Missing password"));

        String error = response.jsonPath().getString("error");

        System.out.println("EL MENSAJE DE ERROR ES: " + error);
        System.out.println("EL CODIGO DE RESPUESTA ES: " + response.statusCode());
        System.out.println("EL SERVICIO SE TARDO: " + response.getTime() + " MILISEGUNDOS");
    }

    @Test
    public void loginTest_Fallido2() {
        String urlReqRes = "https://reqres.in/api";
        String pathLogin = "/login";
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("email", "space@space.com");

        Response response = given().body(requestBody)
                .post(urlReqRes + pathLogin);

        Assert.assertEquals(400, response.statusCode());
        response.then().body("error", equalTo("Missing email or username"));

        String error = response.jsonPath().getString("error");

        System.out.println("EL MENSAJE DE ERROR ES: " + error);
        System.out.println("EL CODIGO DE RESPUESTA ES: " + response.statusCode());
        System.out.println("EL SERVICIO SE TARDO: " + response.getTime() + " MILISEGUNDOS");
    }

}