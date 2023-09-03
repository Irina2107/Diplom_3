package org.example.page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.example.config.Client.MAIN_URL;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void start(){
        driver.get(MAIN_URL);
    }

    private By logInButton = By.xpath(".//button[contains(text(),'Войти в аккаунт')]");
    private By lkHeader = By.xpath(".//p[contains(text(),'Личный Кабинет')]");
    private By constructorHeader1 = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2']"); //или
    private By constructorHeader = By.xpath(".//p[contains(text(),'Конструктор')]");
    private By orderFeedHeader = By.xpath(".//p[contains(text(),'Лента Заказов')]");
    private By collectBurgerHeader = By.xpath(".//h1[text()='Соберите бургер']");
    private By bunSection = By.xpath(".//span[contains(text(),'Булки')]");
    private By sauceSection = By.xpath(".//span[contains(text(),'Соусы')]");
    private By fillingSection = By.xpath(".//span[contains(text(),'Начинки')]");
  //  private By fillingSection = By.className("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
    private By fluorBunImg = By.xpath(".//img[@alt = 'Флюоресцентная булка R2-D3']");
    private By traditionSauceImg = By.xpath(".//img[@alt = 'Соус традиционный галактический']");
    private By beefMetImg = By.xpath(".//img[@alt = 'Говяжий метеорит (отбивная)']");
    private By createOrderButton = By.xpath(".//button[contains(text(),'Оформить заказ')]");

    @Step("Кликнуть по 'Войти в аккаунт' на главной странице")
    public void clickLogInButtonOnMainPage(){driver.findElement(logInButton).click();}

    @Step("Кликнуть по 'Личный Кабинет'")
    public void clickLkHeader(){driver.findElement(lkHeader).click();}

    @Step("Кликнуть по 'Лента Заказов'")
    public void clickOrderFeedHeader(){driver.findElement(orderFeedHeader).click();}

    @Step("Кликнуть по 'Конструктор'")
    public MainPage clickConstructorHeader(){driver.findElement(constructorHeader).click();
    return this;}

    @Step("Перейти к секции 'Булки'")
    //Проскролить  до секции 'Булки'
    public MainPage clickBunSection(){
    driver.findElement(bunSection).click();
    return this;}

    @Step("Проверить, что подчеркнута секция 'Булки'")
    public Boolean bunSectionIsVisible(){
        return driver.findElement(bunSection).isDisplayed();
            }

    @Step("Перейти к секции 'Соусы'")
    public MainPage clickSauceSection(){
       // ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(sauceSection));
        //Подождать
     //   new WebDriverWait(driver, 5)
       //        .until(ExpectedConditions.visibilityOfElementLocated(sauceSection));
        driver.findElement(sauceSection).click();
       return this;
    }
    @Step("Проверить, что подчеркнута секция 'Соусы'")
    public Boolean sauceSectionIsVisible(){
        return driver.findElement(sauceSection).isDisplayed();
    }
    @Step("Перейти к секции 'Начинки'")
    public MainPage clickFillingSection() {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(fillingSection));
    driver.findElement(fillingSection).click();
    return this;
}
    @Step("Проверить, что подчеркнута секция 'Начинки'")
    public Boolean fillingSectionIsVisible(){
        return driver.findElement(fillingSection).isDisplayed();
    }
    @Step("Провреить, что отображается кнопка 'Оформить заказ'")
    public Boolean checkCreateOrderButtonIsVisible(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        return driver.findElement(createOrderButton).isDisplayed();
    }
    @Step("Провреить, что отображается текст 'Соберите бургер'")
    public Boolean checkСollectBurgerHeaderIsVisible(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(collectBurgerHeader));
        return driver.findElement(collectBurgerHeader).isDisplayed();
    }
    @Step("Провреить, что отображается кнопка 'Войти в аккаунт'")
    public Boolean checkLogInButtonIsVisible(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(logInButton));
        return driver.findElement(logInButton).isDisplayed();
    }

}
