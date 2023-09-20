package Pages;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OverviewPage extends BasePage {

    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//input[@value='Log In']");
    private By accountsOverview = By.linkText("Accounts Overview");
    private By balancemsj = By.xpath("//TD[@colspan='3'][text()='*Balance includes deposits that may be subject to holds\n" +
            "        ']");

    public OverviewPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void writeUser(String usuario) throws InterruptedException {
        writeInput(usuario, username);
    }

    public void writePassword(String pass) throws InterruptedException {
        writeInput(pass, password);
    }

    public void clickLoginBtn() throws InterruptedException {
        this.clickear(loginBtn);
    }

    public void clickAccountsOverview() throws InterruptedException {
        this.clickear(accountsOverview);
    }

    public String getBalanceMsj() {
        System.out.println("MENSAJE: " + this.getText(balancemsj));
        return this.getText(balancemsj);
    }

}
