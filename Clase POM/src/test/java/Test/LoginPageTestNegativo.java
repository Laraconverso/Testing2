package Test;

import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTestNegativo {
    public WebDriver driver;
    @Test
    public void Prueba_2() throws InterruptedException {
        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ChromeOptions);
        driver.manage().window().maximize();
        driver.get("http://testing.ctd.academy/");
        LoginPage login = new LoginPage(driver);

        login.clickIniciarSesion();
        login.escribirEmail("yo@gmail.com");
        login.escribirPassword("wrongpassword");
        //login.clickIngrsar(); Ver esto!

        String msj = login.obtenerFeedback();
        assertTrue(msj.equals("Sus credenciales son inválidas. Por favor, vuelva a intentarlo"));
        login.close();
    }
}
