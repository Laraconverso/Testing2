package Test;

import Pages.ActivityPage;
import Pages.NewAccountPage;
import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestActividadCuenta {

    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_ACTIVIDAD_CUENTA.html");
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
    void testActividadCuenta() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de actividad de cuenta Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        ActivityPage activityPage = new ActivityPage(driver, wait);
        activityPage.setup();
        activityPage.url("https://parabank.parasoft.com/parabank/index.htm");
        test.log(Status.PASS, "Ingreso a la pagina exitoso");
        activityPage.writeUser("usuariodepruebas1");
        activityPage.writePassword("password");
        activityPage.clickLoginBtn();
        activityPage.clickAccountsOverview();
        assertTrue(activityPage.getBalanceMsj().contains( "*Balance includes deposits that may be subject to holds"));
        test.log(Status.PASS, "Se visualizó el detalle de balance de cuentas exitosamente.");
        activityPage.clickAccountNumber();
        assertTrue(activityPage.getAccountDetilsMsj().contains("Account Details"));
        test.log(Status.PASS, "Titulo 'Account Details' visualizado exitosamente.");
        activityPage.chooseActivityperiod();
        activityPage.chooseActivityType();
        activityPage.clickSubmit();
        test.log(Status.PASS, "Test de actividad de cuenta finalizado exitosamente.");
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