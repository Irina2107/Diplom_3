package org.example.page_object;

import io.qameta.allure.Step;
import org.example.config.Client;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends Client {

    private By registerLinkOnLogInPage = By.xpath(".//a[contains(text(),'Зарегистрироваться')]");
   // private By nameInput = By.xpath(".//input[@name='name']");
    //private By nameInput = By.xpath(".//fieldset[1]//input");
   private By nameInput = By.xpath(".//label[text()='Имя']/parent::div/input");
    private By emailInput = By.xpath(".//fieldset[2]//input");
    private By passwordInput = By.xpath(".//input[@name='Пароль']");
    private By registrationButtonOnRegisterPage1 = By.xpath(".//button[contains(text(),'Зарегистрироваться')]");
    private By registrationButtonOnRegisterPage = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By logInLink = By.xpath(".//a[@href='/login']");
    private By incorrectPasswordText = By.xpath("//p[contains(text(),'Некорректный пароль')]");

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть форму регистрации")
    public void registerButtonOnMainPageOpen(){
    driver.findElement(registerLinkOnLogInPage).click();}

    @Step("Заполить поле 'Имя'")
    public void fillName(String name){

    driver.findElement(nameInput).sendKeys(name);
    }


    @Step("Заполить поле 'Email'")
    public void fillEmail(String email){
    new WebDriverWait(driver, 5);
    driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполить поле 'Пароль'")
    public void fillPassword(String password){
    new WebDriverWait(driver, 5);
    driver.findElement(passwordInput).sendKeys(password);
    }

   @Step("Нажать на кнопку 'Зарегистрироваться'")
    public void  registrationButtonOnRegisterPageClick(){
    new WebDriverWait(driver, 10);
    driver.findElement(registrationButtonOnRegisterPage).click();
    }

    @Step("Проверить, что отображается кнопка 'Зарегистрироваться'")
    public Boolean registrationButtonNotShown() {
        return driver.findElement(registrationButtonOnRegisterPage).isDisplayed();
    }

    @Step("Некорректный пароль")
    public void verifyErrorRegisterWithIncorrectPassword(){
        new WebDriverWait(driver, 5);
        String ExpectedText = "Некорректный пароль";
        String ActualText = driver.findElement(incorrectPasswordText).getText();
        Assert.assertEquals("Текст верный", ExpectedText, ActualText);
        }

    }



