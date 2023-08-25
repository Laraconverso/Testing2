package Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.LoginPage;

public class TestLogin {
    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_LOGIN.html");
    static ExtentReports extent;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.setup();
        loginPage.url("http://testing.ctd.academy/");
    }

    @Test
    @Tag("LOGIN")
    public void LoginExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Login Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.clickLogin();
        test.log(Status.PASS, "Ingresar a la pagina de Login");

        loginPage.escribirCorreo("prueba0003@gmail.com");
        loginPage.escribirContraseña("123456");
        test.log(Status.PASS, "Completar los datos del Login");

        loginPage.loguearse();
        String usuarioLogueado = loginPage.usuarioLogueado();
        if (usuarioLogueado.equals("Sergio Pace")) {
            test.log(Status.PASS, "Validación de Ingreso Exitoso");
        } else {
            test.log(Status.FAIL, "Validación de Ingreso Fallida");
        }
    }

    @Test
    @Tag("LOGIN")
    public void LoginCredencialesInvalidas() throws InterruptedException {
        ExtentTest test = extent.createTest("Login Credenciales Inválidas");
        test.log(Status.INFO, "Comienza el Test");
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.clickLogin();
        test.log(Status.PASS, "Ingresar a la pagina de Login");

        loginPage.escribirCorreo("prueba003@gmail.com");
        loginPage.escribirContraseña("123456");
        test.log(Status.PASS, "Completar los datos del Login con mail erroneo");

        loginPage.loguearse();
        String invalido = loginPage.credencialesInvalidas();
        if (invalido.equals("Sus credenciales son inválidas Por favor, vuelva a intentarlo")) {
            test.log(Status.PASS, "Mensaje de Credenciales Inválidas exitoso");
        } else {
            test.log(Status.FAIL, "Mensaje de Credenciales Inválidas fallida");
        }
    }

    @Test
    @Tag("LOGIN")
    public void LoginContraseñaCorta() throws InterruptedException {
        ExtentTest test = extent.createTest("Login Contraseña de menos de 6 Caracteres");
        test.log(Status.INFO, "Comienza el Test");
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.clickLogin();
        test.log(Status.PASS, "Ingresar a la pagina de Login");

        loginPage.escribirCorreo("prueba0003@gmail.com");
        loginPage.escribirContraseña("123");
        test.log(Status.PASS, "Completar los datos del Login con contraseña menor a 6 Caracteres");

        loginPage.loguearse();
        String contraseñaCorta = loginPage.campoObligatorio();
        if (contraseñaCorta.equals("La contraseña debe tener más de 6 caracteres")) {
            test.log(Status.PASS, "Mensaje de contraseña corta exitoso");
        } else {
            test.log(Status.FAIL, "Mensaje de contraseña corta fallida");
        }
    }

    @AfterEach
    public void cerrar() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
