package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.page_object.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class PersonalAreaTest extends BaseTest {
    MainPage mainPage;

    @Test
    @DisplayName("Переход по клику на 'Личный кабинет'")
    public void LogInButtonOnMainPage() {
        mainPage = new MainPage(driver);
        mainPage.clickLkHeader();
        //Assert.assertTrue(mainPage.checkCreateOrderButtonIsVisible());
    }
    @Test
    @DisplayName("Переход из 'Личного кабинета' в 'конструктор', когда пользователь неавторизован")
    public void jumpFromLkToConstructorNotAuthorizationUser() {
        mainPage = new MainPage(driver);
        mainPage.clickConstructorHeader();
        Assert.assertTrue("Если пользователь не авторизирован, то нет перехода в ЛК", mainPage.checkLogInButtonIsVisible());
    }
    @After
    public void unLoad(){
        driver.quit();}

}
