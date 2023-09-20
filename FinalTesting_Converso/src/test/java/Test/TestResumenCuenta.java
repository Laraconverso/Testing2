package Test;

import Pages.OverviewPage;
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

public class TestResumenCuenta {

    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_RESUMEN_CUENTA.html");
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
    void AperturadecuentaExitosa() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de resumen de cuenta Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        OverviewPage overviewPage = new OverviewPage(driver, wait);
        overviewPage.setup();
        overviewPage.url("https://parabank.parasoft.com/parabank/index.htm");
        test.log(Status.PASS, "Ingreso a la pagina exitoso.");
        overviewPage.writeUser("usuariodepruebas1");
        overviewPage.writePassword("password");
        overviewPage.clickLoginBtn();
        overviewPage.clickAccountsOverview();
        assertTrue(overviewPage.getBalanceMsj().contains("*Balance includes deposits that may be subject to holds"));
        test.log(Status.PASS, "Se visualizó el resumen de cuentas exitosamente.");
    }
    @AfterEach
    public void close() {
        OverviewPage overviewPage = new OverviewPage(driver, wait);
        overviewPage.close();
    }
    @AfterAll
    public static void closeReport() {
        extent.flush();
    }
}