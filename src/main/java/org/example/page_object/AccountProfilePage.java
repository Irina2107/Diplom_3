package org.example.page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountProfilePage {
    WebDriver driver;

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public static By profileText = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    public static By logOutButton = By.xpath(".//button[text()='Выход']");

    @Step("Нажать на кнопку 'Выход'")
    public void clickLogOutButtonOnProfilePage() {
        new WebDriverWait(driver, 5);
        driver.findElement(logOutButton).click();
        }

    @Step("Проверить, что отображается кнопка 'Выход'")
    public Boolean checkLogOutIsVisible(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(logOutButton));
        return driver.findElement(logOutButton).isDisplayed();
    }
}
