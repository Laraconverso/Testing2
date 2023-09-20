package com.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(2000));
    }

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
        driver.manage().window().maximize();
    }

    public void url(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(1000);
    }

    public WebElement findElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void writeInput(String input, By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(input);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }


    public void close() {
        driver.quit();
    }

}
