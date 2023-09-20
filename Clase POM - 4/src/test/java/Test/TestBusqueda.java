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

import Pages.SearchPage;

public class TestBusqueda {
    public WebDriver driver;
    public WebDriverWait wait;

    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_BUSQUEDA.html");
    static ExtentReports extent;

    @BeforeAll
    public static void setupReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.setup();
        searchPage.url("http://testing.ctd.academy/");
    }

    @Test
    @Tag("BUSQUEDA")
    public void BusquedaExitosa() throws InterruptedException {
        ExtentTest test = extent.createTest("Busqueda Exitosa Punta del Este");
        test.log(Status.INFO, "Comienza el Test");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.escribirCiudad("este");
        searchPage.clickBuscar();
        test.log(Status.PASS, "Realiza Busqueda en Punta del Este");

        String mensajeCorrecto = searchPage.obtenerResultadoBusqueda();
        assertTrue(mensajeCorrecto.equals("CASA DE PLAYA\nVilla Kantounes Studio Ostria"));
        test.log(Status.PASS, "Validación de Busqueda Exitosa - Villa Kantounes");
    }

    @Test
    @Tag("BUSQUEDA")
    public void BusquedaExitosa_2() throws InterruptedException {
        ExtentTest test = extent.createTest("Busqueda Exitosa Grecia");
        test.log(Status.INFO, "Comienza el Test");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.escribirCiudad("Paros");
        searchPage.clickBuscar();
        test.log(Status.PASS, "Realiza Busqueda en Paros");

        String mensajeCorrecto = searchPage.obtenerResultadoBusqueda();
        assertTrue(mensajeCorrecto.equals("CASA DE PLAYA\nLa Paloma"));
        test.log(Status.PASS, "Validación de Busqueda Exitosa - La Paloma");
    }

    @AfterEach
    public void cerrar() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.close();
    }

    @AfterAll
    public static void createReport() {
        extent.flush();
    }
}
