package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
     private By btnLogin = By.xpath("//a[@class='btn btn-secundario btn-xs'][normalize-space()='Iniciar sesión']");
     private By email = By.id("email");
     private By obligatorio = By.className("small-feedback");
     private By contrasena = By.id("password");
     private By btnIngresar = By.className("btn-primario");
     private By invalido = By.className("form-feedback");
     private By usuario = By.className("txt-nombre");


     public LoginPage(WebDriver driver, WebDriverWait wait) {
          super(driver, null);
     }

     public void clickLogin() throws InterruptedException {
          this.clickear(btnLogin);
     }

     public void escribirCorreo(String ciudad) throws InterruptedException {
          this.sendText(ciudad, email);
     }

     public void escribirContraseña(String ciudad) throws InterruptedException {
          this.sendText(ciudad, contrasena);
     }

     public void loguearse() throws InterruptedException {
          this.clickear(btnIngresar);
     }

     public String usuarioLogueado() throws InterruptedException {
          String res = this.getText(usuario);
          System.out.println("Resultado Card value: " + res);
          return res;
     }

     public String campoObligatorio() throws InterruptedException {
          String res = this.getText(obligatorio);
          System.out.println("Resultado Card value: " + res);
          return res;
     }

     public String credencialesInvalidas() throws InterruptedException {
          String res = this.getText(invalido);
          System.out.println("Resultado Card value: " + res);
          return res;
     }
}