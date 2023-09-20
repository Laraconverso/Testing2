package com.Tests;


import com.Pages.SearchResultPage;
import com.Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TestBusqueda {
    private static WebDriver driver;
    public WebDriverWait wait;
    static ExtentReports extent;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_BUSQUEDA.html");
    protected static final String url = "https://opencart.abstracta.us/index.php?route=common/home";

    @BeforeAll
    public static void setupReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUpTest() throws InterruptedException{
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        SearchResultPage searchPage = new SearchResultPage(driver, wait);
        searchPage.setup();
        searchPage.url(url);
    }

    @Test
    @Tag("BUSQUEDA")
    public void searchTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Busqueda Exitosa Iphone");
        test.log(Status.INFO, "Comienza el Test");
        SearchResultPage searchPage = new SearchResultPage(driver, wait);
        test.log(Status.PASS, "Realiza Busqueda de Iphone");
        searchPage.searchProduct("Iphone");
        test.log(Status.PASS, "Agrega producto al carrito");
        searchPage.addProduct();
        Thread.sleep(300);
        System.out.println("Product testing successfully");
    }

    @AfterAll
    static void closeTest() {
        driver.quit();
        extent.flush();
    }
}
