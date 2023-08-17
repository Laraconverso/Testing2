package Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EjemploBeforeAfter {
    //ejemplo con la teoria vsta ne clase de una busqueda en wikipedia
    public static WebDriver driver;
    public Boolean shoudTheTestPass = false;

    @BeforeEach
    public void setup() throws InterruptedException {
        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ChromeOptions);
        driver.manage().window().maximize();
    }

    @Test
    public void step01_HomePage()throws Exception{
        driver.get("http://www.wikipedia.org");
        String i = driver.getCurrentUrl();
        System.out.println(i);
        //EjemploBeforeAfter me = new EjemploBeforeAfter();
        try {
//            me.takeScreenShot("Step01.png", driver);
            System.out.println("Instead of screenshot step 1");
        }catch (Exception e){
            System.out.println("Problem" + e);
        }
    }

    @Test
    public void step02_MainPage()throws Exception{
        driver.findElement(By.linkText("English")).click();
        //EjemploBeforeAfter me = new EjemploBeforeAfter();
        try {
//            me.takeScreenShot("Step01.png", driver);
            System.out.println("Instead of screenshot step 2");
        }catch (Exception e){
            System.out.println("Problem" + e);
        }
    }

    @AfterEach
    public void tearDown()throws Exception{
        driver.quit();
    }

}
