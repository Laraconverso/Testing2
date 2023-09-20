package Test;

import Pages.RegisterPage;
import Pages.TransferPage;
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

public class TestTransferirFondos {

    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_TRANSFERIR_FONDOS.html");
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
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    @Test
    void testTransferenciaExitosa() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de transferencia Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        TransferPage transferPage = new TransferPage(driver, wait);
        transferPage.setup();
        transferPage.url("https://parabank.parasoft.com/parabank/index.htm");
        test.log(Status.PASS, "Ingreso a la pagina exitoso");
        transferPage.writeUser("usuariodepruebas1");
        transferPage.writePassword("password");
        transferPage.clickLoginBtn();
        transferPage.clickTransferFunds();
        transferPage.writeQuantity("500");
        transferPage.selectDestination();
        transferPage.clickSubmit();
        assertTrue(transferPage.getSuccessMsj().contains( "Transfer Complete!"));
        test.log(Status.PASS, "Transferencia realizada con exito.");

    }

    @AfterEach
    public void close() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void closeReport() {
        extent.flush();
    }

}