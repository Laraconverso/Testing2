package Test;

import Pages.RegisterPage;
import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRegistro {
    public WebDriver driver;
    public WebDriverWait wait;
    ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES.html");
    ExtentReports extent;

    @BeforeEach
    public void setUp() throws InterruptedException {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setup();
        registerPage.url("http://testing.ctd.academy/");
    }

    @Test
    @Tag("REGISTRO")
    public void RegistroExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Registro Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        registerPage.clickCrearCuenta();
        test.log(Status.PASS, "Ingreso en el formulario de Registro");

        registerPage.escribirNombre("Sergio");
        registerPage.escribirApellido("Pace");
        registerPage.escribirCorreo("prueba00004@gmail.com");
        registerPage.escribirContraseña("123456");
        registerPage.escribirRepetirContraseña("123456");
        test.log(Status.PASS, "Ingreso todos los datos del Registro");

        registerPage.clickRegistrarse();
        String mensajeCorrecto = registerPage.cuentaCreadaGracias();
        assertTrue(mensajeCorrecto.equals("¡Cuenta registrada con éxito!"));

        String mensajeCorrecto2 = registerPage.cuentaCreadaExito();
        assertTrue(mensajeCorrecto2.equals("Te enviamos un email para confirmar tu cuenta"));
        test.log(Status.PASS, "Validación de Registro Exitoso");
    }

    @Test
    @Tag("REGISTRO")
    public void RegistroFallidoMailRepetido() throws InterruptedException {
        ExtentTest test = extent.createTest("Registro Fallido por correo ya usado");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        registerPage.clickCrearCuenta();
        test.log(Status.PASS, "Ingreso en el formulario de Registro");

        registerPage.escribirNombre("Sergio");
        registerPage.escribirApellido("Pace");
        registerPage.escribirCorreo("prueba00004@gmail.com");
        registerPage.escribirContraseña("123456");
        registerPage.escribirRepetirContraseña("123456");
        test.log(Status.PASS, "Ingreso todos los datos del Registro");

        registerPage.clickRegistrarse();
        String mensajeCorrecto = registerPage.cuentaCreadaGracias();
        assertTrue(mensajeCorrecto.equals("¡Cuenta registrada con éxito!"));

        test.log(Status.PASS, "Validación de Registro Exitoso");
    }

    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
        extent.flush();
    }
}
