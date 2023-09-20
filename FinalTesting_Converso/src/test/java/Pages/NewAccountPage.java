package Pages;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountPage extends BasePage {

    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//input[@value='Log In']");
    private By openNewAccountBtn = By.linkText("Open New Account");
    private By accountType = By.id("type");
    private By submitBtn = By.xpath("//input[@value='Open New Account']");
    private By succesMsj = By.xpath("//p[text()='Congratulations, your account is now open.']");



    public NewAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void writeUsername(String usernameIn) throws  InterruptedException{
        writeInput(usernameIn, username);
        Thread.sleep(1500);
    }
    public void writePassword(String passwordIn) throws InterruptedException{
        writeInput(passwordIn, password);
        Thread.sleep(1500);
    }
    public void clickLoginBtn() throws InterruptedException{
        this.clickear(loginBtn);
        Thread.sleep(1500);
    }
    public void openNewAccount() throws InterruptedException{
        this.clickear(openNewAccountBtn);
        Thread.sleep(1500);
    }
    public void selectAccountType() throws InterruptedException{
        Select select = new Select(driver.findElement(accountType));
        select.selectByVisibleText("SAVINGS");
        Thread.sleep(1500);
    }
    public void clickSubmitNewAcc() throws InterruptedException {
        this.clickear(submitBtn);
        Thread.sleep(1500);
    }
    public String getSucccessMsj() throws InterruptedException{
        System.out.println("MENSAJE: " + this.getText(succesMsj));
        return this.getText(succesMsj);
    }

}
