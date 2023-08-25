package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {
    private By nombre = By.id("firstName");
    private By apellido = By.id("lastName");
    private By email = By.id("email");
    private By password = By.id("password");
    private By repassword = By.id("repassword");
    private By btnRegistrarse = By.className("btn-primario");//*[@id="root"]/main/div/form/button
    private By btnCrearCuenta = By.linkText("Crear cuenta");
    private By gracias = By.className("txt-gracias");
    private By exito = By.className("txt-exito");

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickCrearCuenta() throws InterruptedException {
        this.clickear(btnCrearCuenta);
    }

    public void escribirNombre(String name) throws InterruptedException {
        this.sendText(name, nombre);
    }

    public void escribirApellido(String name) throws InterruptedException {
        this.sendText(name, apellido);
    }

    public void escribirCorreo(String mail) throws InterruptedException {
        this.sendText(mail, email);
    }

    public void escribirContraseña(String pass) throws InterruptedException {
        this.sendText(pass, password);
    }

    public void escribirRepetirContraseña(String pass) throws InterruptedException {
        this.sendText(pass, repassword);
    }

    public void clickRegistrarse() throws InterruptedException {
        this.clickear(btnRegistrarse);
        Thread.sleep(1000);
    }

    public String cuentaCreadaGracias() throws InterruptedException {
        String res = this.getText(gracias);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

    public String cuentaCreadaExito() throws InterruptedException {
        String res = this.getText(exito);
        System.out.println("Resultado Card value: " + res);
        return res;
    }
}
