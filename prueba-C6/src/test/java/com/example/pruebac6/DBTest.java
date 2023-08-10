package com.example.pruebac6;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class DBTest {
    private WebDriver driver;

    @Test
    public void PageObj() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testing.ctd.academy");
        Thread.sleep(1000);

        //Logo
        WebElement footer = driver.findElement(By.className("main-footer"));
        assertTrue(footer.isDisplayed());
        //Footer

        WebElement ciudad = driver.findElement(By.id("ciudad"));
        ciudad.clear();
        ciudad.sendKeys("Punta del Este");
        ciudad.sendKeys(Keys.ENTER);
        Thread.sleep(1000);


        WebElement buttomBusqueda = driver.findElement(By.className("btn-primario"));
        buttomBusqueda.click();
        Thread.sleep(1000);

        WebElement recomendacionPuntaEste = driver.findElement(By.className("categoria"));
        String mensajeCorrecto = recomendacionPuntaEste.getText();
        Thread.sleep(1000);
        assertTrue(mensajeCorrecto.contains("CASA DE PLAYA"));

        driver.quit();
    }
}
