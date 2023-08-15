package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By login = By.linkText("Iniciar sesión");
    private By emailBox = By.id("email");

    private By passwordBox = By.id("password");

    private By ingresar = By.linkText("Ingresar");

    private By feedback = By.className("form-feedback");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void clickIniciarSesion() throws InterruptedException {
        this.clickear(login);
        Thread.sleep(1000);
    }

    public void escribirEmail(String email) throws InterruptedException {
        this.sendText(email, emailBox);
        Thread.sleep(1000);
        //this.sendKey(Keys.ENTER, emailBox);
        //Thread.sleep(1000);
    }

    public void escribirPassword(String password) throws InterruptedException {
        this.sendText(password, passwordBox);
        Thread.sleep(1000);
        this.sendKey(Keys.ENTER, passwordBox);
        Thread.sleep(1000);
    }

    public void clickIngrsar() throws InterruptedException {
        this.clickear(ingresar);
        Thread.sleep(1000);
    }

    public String obtenerFeedback() throws InterruptedException {
        String res = this.getText(feedback);
        System.out.println("Resultado: " + res);
        Thread.sleep(1000);
        return res;
    }


}
