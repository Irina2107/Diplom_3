package org.example.page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
    WebDriver driver;
    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logInFormHeader = By.xpath(".//h2[contains(text(),'Вход')]");
    private By logInButton = By.xpath(".//button[contains(text(),'Войти')]");
    private By fieldEmail = By.xpath(".//input[@name='name']");
    private By fieldPassword = By.xpath(".//input[@name='Пароль']");

    @Step("Заполить поле 'email'")
    public void fillEmail(String email){
        new WebDriverWait(driver, 5);
        driver.findElement(fieldEmail).sendKeys(email);
    }
    @Step("Заполить поле 'Пароль'")
    public void fillPassword(String password){
        new WebDriverWait(driver, 5);
        driver.findElement(fieldPassword).sendKeys(password);
    }
    @Step("Нажать на кнопку 'Войти'")
    public void logInClickOnLoginPage(){
        driver.findElement(logInButton).click();
    }

    @Step("Проверить, что отображается кнопка 'Войти'")
    public Boolean checkLogInVisible(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(logInButton));
        return driver.findElement(logInButton).isDisplayed();
    }

}
