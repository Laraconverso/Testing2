package TestBack;

import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GETTest {
    @Test
    public void getReqRes() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    public void getReqRes_1() {
        Response resGet = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(resGet.getBody().asString());
        System.out.println(resGet.getStatusCode());
        System.out.println(resGet.getHeader("content-type"));
        System.out.println(resGet.getHeader("Date"));
        System.out.println(resGet.getTime());
    }

    @Test
    public void getTest() {
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7))
                .body("data.email[0]", equalTo("michael.lawson@reqres.in"))
                .log().status()
                .log().body(false);
    }

    @Test
    public void getTest_2() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        int statusCode = response.statusCode();
        JsonPath body = response.jsonPath();
        String mail_0 = body.getString("data.email[0]");
        String nombre_0 = body.getString("data.first_name[0]");

        Assert.assertEquals(mail_0, "michael.lawson@reqres.in");
        Assert.assertEquals(nombre_0, "Michael");
        Assert.assertEquals(statusCode, 200);

        System.out.println(statusCode);
        System.out.println(mail_0);
        System.out.println(nombre_0);
    }
}