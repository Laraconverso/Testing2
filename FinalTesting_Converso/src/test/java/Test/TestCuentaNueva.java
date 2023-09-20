package Test;

import Pages.NewAccountPage;
import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCuentaNueva {

    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_CUENTA_NUEVA.html");
    static ExtentReports extent;
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public static void setupReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
    }


    @Test
    void testCuentaNuevaExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de apertura de cuenta nueva Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        NewAccountPage newAccountPage = new NewAccountPage(driver, wait);
        newAccountPage.setup();
        newAccountPage.url("https://parabank.parasoft.com/parabank/index.htm");
        test.log(Status.PASS, "Ingreso exitoso a la pagina.");
        newAccountPage.writeUsername("usuariodepruebas1");
        newAccountPage.writePassword("password");
        newAccountPage.clickLoginBtn();
        newAccountPage.openNewAccount();
        newAccountPage.selectAccountType();
        newAccountPage.clickSubmitNewAcc();
        assertTrue(newAccountPage.getSucccessMsj().contains( "Congratulations, your account is now open."));
        test.log(Status.PASS, "Se realizó la apertura de la cuenta exitosamente.");
    }


    @AfterEach
    public void close() {
        NewAccountPage newAccountPage = new NewAccountPage(driver, wait);
        newAccountPage.close();
    }

    @AfterAll
    public static void closeReport() {
        extent.flush();
    }


}