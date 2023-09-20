package Pages;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    private By register = By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");
    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phone = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By username = By.id("customer.username");
    private By password = By.id("customer.password");
    private By confirmPassword = By.id("repeatedPassword");
    private By registerSubmitBtn = By.xpath("(//INPUT[@type='submit'])[2]");
    private By registeredMsj = By.xpath("//P[text()='Your account was created successfully. You are now logged in.']");

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickRegister() throws InterruptedException {
        this.clickear(register);
    }

    public void writeFirstName(String name) throws InterruptedException {
        writeInput(name, firstName);
    }

    public void writeLastName(String lastNameIn) throws InterruptedException {
        writeInput(lastNameIn, lastName);
    }

    public void writeAddress(String addressIn) throws InterruptedException {
        writeInput(addressIn, address);
    }

    public void writeCity(String cityIn) throws InterruptedException {
        writeInput(cityIn, city);
    }


    public void writeState(String stateIn) throws InterruptedException {
        writeInput(stateIn, state);
    }

    public void writeZipCode(String zipCodeIn) throws InterruptedException {
        writeInput(zipCodeIn, zipCode);
    }

    public void writeTelephone(String telephoneIn) throws InterruptedException {
        writeInput(telephoneIn, phone);
    }

    public void writeSsn(String ssnIn) throws InterruptedException {
        writeInput(ssnIn, ssn);
    }

    public void writeUsername(String usernameIn) throws InterruptedException {
        writeInput(usernameIn, username);
    }

    public void writePassword(String passwordIn) throws InterruptedException {
        writeInput(passwordIn, password);
    }

    public void confirmPassword(String passwordIn) throws InterruptedException {
        writeInput(passwordIn, confirmPassword);
    }

    public void submit() throws InterruptedException {
        this.clickear(registerSubmitBtn);
    }

    public String getRegisteredMsj() {
        System.out.println("MENSAJE: " + this.getText(registeredMsj));
        return this.getText(registeredMsj);
    }
}
