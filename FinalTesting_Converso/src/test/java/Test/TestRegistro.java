package Test;

import Pages.RegisterPage;
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

public class TestRegistro {
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_REGISTRO.html");
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
    void testRegistroExitoso() throws  InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Registro Exitoso");
        test.log(Status.INFO, "Inicia el test");
        RegisterPage registerPage = new RegisterPage(driver,wait);
        registerPage.setup();
        registerPage.url("https://parabank.parasoft.com/parabank/index.htm");
        test.log(Status.PASS, "Se ingreso a la pagina de manera exitosa.");
        registerPage.clickRegister();
        test.log(Status.PASS, "Se ingreso a la pagina de registro exitosamente.");
        registerPage.writeFirstName("Prueba");
        registerPage.writeLastName("UNO");
        registerPage.writeAddress("adressdeprueba");
        registerPage.writeCity("ciudad1");
        registerPage.writeState("estados");
        registerPage.writeZipCode("22");
        registerPage.writeTelephone("123456");
        registerPage.writeSsn("2245");
        registerPage.writeUsername("usuariodepruebas1");
        registerPage.writePassword("password");
        registerPage.confirmPassword("password");
        registerPage.submit();
        assertTrue(registerPage.getRegisteredMsj().equals("Your account was created successfully. You are now logged in."));
        test.log(Status.PASS, "Mensaje:  "+ registerPage.getRegisteredMsj() );
        test.log(Status.PASS, "Registro de usuario exitoso.");
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