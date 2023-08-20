package org.example.page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPage {
    WebDriver driver;

    private By logInButtonOnForgotPage = By.xpath(".//a[text()='Войти']");
    public ForgotPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Нажать на кнопку 'Войти'")
    public void logInButtonOnForgotPage() {
        new WebDriverWait(driver, 5);
        driver.findElement(logInButtonOnForgotPage).click();
    }
}
