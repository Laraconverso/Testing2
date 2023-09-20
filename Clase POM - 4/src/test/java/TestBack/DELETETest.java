package TestBack;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class DELETETest {
    @Test
    public void DeleteTest_01() {
        Response responseBody = given().delete("https://reqres.in/api/users/12");
        Assert.assertEquals(responseBody.statusCode(), 204);

        System.out.println("EL CÓDIGO DE RESPUESTA ES: " + responseBody.statusCode()
                + " QUE ASEGURA QUE SE HAYA DADO DE BAJA EL USUARIO");
        System.out.println("EL SERVICIO SE TARDO " + responseBody.getTime() + " MILISEGUNDOS EN RESPONDER");
    }

    @Test
    public void DeleteTest_02() {
        String urlReqRes = "https://reqres.in/api";
        String pathUser = "/users/";
        String usuario = "15";
        Response responseBody = given().delete(urlReqRes + pathUser + usuario);
        Assert.assertEquals(responseBody.statusCode(), 204);

        System.out.println("EL CÓDIGO DE RESPUESTA ES: " + responseBody.statusCode()
                + " QUE ASEGURA QUE SE HAYA DADO DE BAJA EL USUARIO " + usuario);
        System.out.println("EL SERVICIO SE TARDO " + responseBody.getTime() + " MILISEGUNDOS EN RESPONDER");
    }
}
