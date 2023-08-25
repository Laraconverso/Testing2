package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
     private By logo = By.xpath("//img[@alt='Logo Digital Booking']");
     private By lema = By.linkText("Sentite como en tu hogar");
     private By searchBox = By.id("ciudad");
     private By buscar = By.id("btn-buscador");
     private By searchResult = By.className("categoria");

     public SearchPage(WebDriver driver, WebDriverWait wait) {
          super(driver, null);
     }

     public void escribirCiudad(String ciudad) throws InterruptedException {
          this.sendText(ciudad, searchBox);
          Thread.sleep(500);
          this.sendKey(Keys.ENTER, searchBox);
     }

     public void clickBuscar() throws InterruptedException {
          this.clickear(buscar);
          Thread.sleep(500);
     }

     public String obtenerResultadoBusqueda() throws InterruptedException {
          String res = this.getText(searchResult);
          System.out.println("Resultado Card value: " + res);
          return res;
     }

     public void clickLogo() throws InterruptedException {
          this.clickear(logo);
     }

     public void clickLema() throws InterruptedException {
          this.clickear(lema);
     }
}