package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {
    By nombre = By.id("input-firstname");
    By apellido = By.id("input-lastname");
    By email = By.id("input-email");
    By telefono = By.id("input-telephone");
    By passwordInput = By.id("input-password");
    By passwordConfirm = By.id("input-confirm");
    By noNewsletter = By.xpath("//input[@type='checkbox' and @name='agree']");

//    By privacyPolicy = By.xpath("//input[type='checkbox'][name='agree'][value='1']");
    By myAccount = By.xpath("//ul[@class='list-inline']//li[@class='dropdown']");
    By registration = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
    By btnContinue1 = By.xpath("//input[@value='Continue']");
    By message = By.id("content");
    By btnContinue2 = By.xpath("//*[@id=\"content\"]/div/div/a");

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String response() throws InterruptedException {
        Thread.sleep(1000);
        String res = findElement(message).getText();
        System.out.println("Result: " + res);
        return res;
    }

    public void clickLogin() throws InterruptedException {
        click(myAccount);
        click(registration);
    }

    public void insertName(String name){
        writeInput(name, nombre);
    }

    public void insertLastName(String lastname){
        writeInput(lastname, apellido);
    }

    public void insertMail(String mail){
        writeInput(mail, email);
    }

    public void insertTel(String tel){
        writeInput(tel, telefono);
    }
    public void insertPassword(String password){
        writeInput(password, passwordInput);
        writeInput(password, passwordConfirm);
    }

    public void clickNo(){
        click(noNewsletter);
    }

//    public void setPrivacyPolicy(){
//        click(privacyPolicy);
//    }

    public void clickContinueBtn1() throws InterruptedException {
        Thread.sleep(2000);
        click(btnContinue1);
    }

    public void clickContinueBtn2() throws InterruptedException {
        Thread.sleep(2000);
        click(btnContinue2);
    }

}
