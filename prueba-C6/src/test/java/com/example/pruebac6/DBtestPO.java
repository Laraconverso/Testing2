package com.example.pruebac6;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DBtestPO {
    private static WebDriver driver;
    private static HomePage homePage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        driver.get("http://testing.ctd.academy");
    }

    @Test
    public void testSearchAndVerifyMessage() throws InterruptedException {
        homePage.waitForPageLoad();

        homePage.enterCity("Punta del Este");
        homePage.clickSearchButton();

        assertTrue(homePage.verifyMessageContains("CASA DE PLAYA"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}

class HomePage {
    private WebDriver driver;
    private By cityInputLocator = By.id("ciudad");
    private By searchButtonLocator = By.className("btn-primario");
    private By categoryLocator = By.className("categoria");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageLoad() throws InterruptedException {
        Thread.sleep(1000); // Adjust this as needed
    }

    public void enterCity(String city) {
        WebElement ciudad = driver.findElement(cityInputLocator);
        ciudad.clear();
        ciudad.sendKeys(city);
        ciudad.sendKeys(Keys.ENTER);
    }

    public void clickSearchButton() {
        WebElement buttonBusqueda = driver.findElement(searchButtonLocator);
        buttonBusqueda.click();
    }

    public boolean verifyMessageContains(String expectedText) {
        WebElement categoryElement = driver.findElement(categoryLocator);
        String actualMessage = categoryElement.getText();
        return actualMessage.contains(expectedText);
    }
}
