package Pages;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActivityPage extends BasePage {

    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//input[@value='Log In']");
    private By accountsOverview = By.linkText("Accounts Overview");
    private By balanceMsj = By.xpath("//TD[text()='*Balance includes deposits that may be subject to holds\n" + "        ']");
    private By accountNumber = By.xpath("//a[@class='ng-binding']");
    private By accountDetail = By.xpath("//H1[@class='title'][text()='Account Details']");
    private By periodActivity = By.id("month");
    private By type = By.id("transactionType");
    private By submitBtn = By.xpath("//INPUT[@type='submit']");

    public ActivityPage(WebDriver driver, WebDriverWait wait) {
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

    public void clickAccountNumber() throws InterruptedException {
        this.clickear(accountNumber);
    }

    public void chooseActivityperiod() throws InterruptedException {
        Select select = new Select(driver.findElement(periodActivity));
        select.selectByVisibleText("All");
    }
    public void chooseActivityType() throws InterruptedException {
        Select select = new Select(driver.findElement(type));
        select.selectByVisibleText("All");
    }

    public void clickSubmit() throws InterruptedException {
        this.clickear(submitBtn);
    }
    public String getBalanceMsj() {
        System.out.println("MENSAJE: " + this.getText(balanceMsj));
        return this.getText(balanceMsj);
    }
    public String getAccountDetilsMsj() {
        System.out.println("MENSAJE: " + this.getText(accountDetail));
        return this.getText(accountDetail);
    }


}