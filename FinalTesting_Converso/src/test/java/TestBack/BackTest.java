package TestBack;

import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;


import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BackTest {
    static ExtentSparkReporter info = new ExtentSparkReporter("target/BACKEND_TEST.html");
    static ExtentReports extent;

    String urlBase = "https://parabank.parasoft.com/parabank/";
    String username = "usuariodepruebas1";
    String password = "password";
    String customerId = "18539";
    String accountId = "28218";


    @BeforeAll
    public static void setupReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }



    //registro
    @Test
    @Order(1)
    public void testRegistroURL() {
        given()
                .get(urlBase +"register.htm")
                .then()
                .statusCode(200)
                .log().body();
    }


    @Test
    @Order(2)
    public void testCrearCuenta(){
        given()
                .auth()
                .basic(username, password)
                .post(urlBase +"servicess_proxy/bank/createAccount?customerId=" +customerId+"&newAccountType=1&fromAccountId="+accountId)
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }

    //overview
    @Test
    @Order(3)
    public void testOverviewAcc() {
        given()
            .auth()
            .basic(username, password)
            .get("overview.htm")
            .then()
            .statusCode(200)
            .log().body();
    }

    @Test
    @Order(4)
    public void testTranferFunds() {
        given()
                .auth()
                .basic(username, password)
                .get("services_proxy/bank/transfer?fromAccountId=" + accountId +"&toAccountId=28329&amount=200")
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }


    @Test
    @Order(5)
    public void testActivityAcc() {
        given()
                .auth().basic(username, password)
                .get(urlBase + "services_proxy/bank/accounts/"+accountId+"/transactions/month/All/type/All")
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }


    @AfterAll
    public static void closeReport() {
        extent.flush();
    }

}