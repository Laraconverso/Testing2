package com.Tests;

import com.Pages.RegisterPage;
import com.Reportes.ExtentFactory;
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
    ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_registro.html");
    ExtentReports extent;

    protected static final String url = "https://opencart.abstracta.us/index.php?route=common/home";


    @BeforeEach
    public void setUpTest() throws InterruptedException{
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setup();
        registerPage.url(url);
    }

    @Test
    @Tag("REGISTRO")
    public void successfulRegistration() throws InterruptedException {
        ExtentTest test = extent.createTest("Registro Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        registerPage.clickLogin();
        test.log(Status.PASS, "Ingreso en el formulario de Registro");

        registerPage.insertName("Taylor");
        registerPage.insertLastName("Swift");
        registerPage.insertMail("youareonyourown@gmail.com");
        registerPage.insertTel("123456");
        registerPage.insertPassword("swiftie");
        registerPage.clickNo();
        //registerPage.setPrivacyPolicy();
        test.log(Status.PASS, "Ingreso todos los datos del Registro");

        registerPage.clickContinueBtn1();
        assertTrue(registerPage.response().contains("Congratulations! Your new account has been successfully created!"));
        registerPage.clickContinueBtn2();
    }

    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
        extent.flush();
    }

}
