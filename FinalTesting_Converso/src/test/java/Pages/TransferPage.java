package Pages;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferPage extends BasePage {

    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//input[@value='Log In']");
    private By transferFunds = By.linkText("Transfer Funds");
    private By amount = By.id("amount");
    private By destination = By.id("toAccountId");
    private By transferBtn = By.xpath("//INPUT[@type='submit']");
    private By successMsj = By.xpath("//h1[normalize-space()='Transfer Complete!']");


    public TransferPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void writeUser(String usuario) throws InterruptedException {
        writeInput(usuario, username);
        Thread.sleep(2000);
    }

    public void writePassword(String pass) throws InterruptedException {
        writeInput(pass, password);
        Thread.sleep(2000);
    }

    public void clickLoginBtn() throws InterruptedException {
        this.clickear(loginBtn);
        Thread.sleep(2000);
    }

    public void clickTransferFunds() throws InterruptedException {
        this.clickear(transferFunds);
        Thread.sleep(2000);
    }

    public void writeQuantity(String amountIn) throws InterruptedException {
        writeInput(amountIn, amount);
        Thread.sleep(2000);
    }

    public void selectDestination() throws InterruptedException {
        Select select = new Select(driver.findElement(destination));
        select.selectByVisibleText("28329");
        Thread.sleep(2000);
    }

    public void clickSubmit() throws InterruptedException {
        this.clickear(transferBtn);
        Thread.sleep(2000);
    }
    public String getSuccessMsj() {
        System.out.println("MENSAJE: " + this.getText(successMsj));
        return this.getText(successMsj);
    }

}
