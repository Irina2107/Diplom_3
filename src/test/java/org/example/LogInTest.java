package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.page_object.AccountProfilePage;
import org.example.page_object.ForgotPage;
import org.example.page_object.LogInPage;
import org.example.page_object.MainPage;
import org.junit.Assert;

import org.junit.Test;
import static org.example.config.Client.*;
public class LogInTest extends BaseTest{

    LogInPage logInPage;
    MainPage mainPage;
    ForgotPage forgotPage;
    AccountProfilePage accountProfilePage;

    @Test
    @DisplayName("Bход по кнопке 'Войти в аккаунт' на главной")
   public void LogInButtonOnMainPage() {
        mainPage = new MainPage(driver);
        mainPage.clickLogInButtonOnMainPage();
        logInPage = new LogInPage(driver);
        logInPage.fillEmail(email);
        logInPage.fillPassword(password);
        logInPage.logInClickOnLoginPage();
        Assert.assertTrue(mainPage.checkCreateOrderButtonIsVisible());
    }
    @Test
        @DisplayName("Вход через кнопку 'Личный кабинет'")
        public void LogInButtonOnLkHeader(){
            mainPage =new MainPage(driver);
            mainPage.clickLkHeader();
            logInPage = new LogInPage(driver);
            logInPage.fillEmail(email);
            logInPage.fillPassword(password);
            logInPage.logInClickOnLoginPage();
            Assert.assertTrue(mainPage.checkCreateOrderButtonIsVisible());
        }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    public void LogInButtonOnRegistration(){
        logInPage = new LogInPage(driver);
        driver.get(LOGIN);
        Assert.assertTrue(logInPage.checkLogInVisible());
        logInPage = new LogInPage(driver);
        logInPage.fillEmail(email);
        logInPage.fillPassword(password);
        logInPage.logInClickOnLoginPage();
        //Assert.assertTrue(mainPage.checkСollectBurgerHeaderIsVisible());
    }

    @Test
    @DisplayName("Войти через кнопку в форме восстановления пароля")
    public void LogInButtonOnForgotPage(){
    forgotPage = new ForgotPage(driver);
    driver.get(FORGOT);
    forgotPage.logInButtonOnForgotPage();
    logInPage = new LogInPage(driver);
    logInPage.fillEmail(email);
    logInPage.fillPassword(password);
    logInPage.logInClickOnLoginPage();
    //Assert.assertFalse(logInPage.checkLogInVisible());
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете, когда пользователь авторизован")
    public void jumpFromLkToConstructorAuthorizationUser()  {
      mainPage =new MainPage(driver);
      mainPage.clickLkHeader();
      accountProfilePage = new AccountProfilePage(driver);
      logInPage = new LogInPage(driver);
      logInPage.fillEmail(email);
      logInPage.fillPassword(password);
      logInPage.logInClickOnLoginPage();
      mainPage.clickLkHeader();
      accountProfilePage.checkLogOutIsVisible();
      accountProfilePage.clickLogOutButtonOnProfilePage();
      Assert.assertTrue("Ошибка в Chrom Browser, по кнопке не происходит выхода", accountProfilePage.checkLogOutIsVisible());
    }
}

