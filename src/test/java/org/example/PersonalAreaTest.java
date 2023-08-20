package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.page_object.MainPage;
import org.example.user_config.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import static org.example.config.Client.MAIN_URL;

public class PersonalAreaTest {
    MainPage mainPage;

    WebDriver driver;

    @Before
    public void setUp() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:/Users/IGladkova/Diplom/Drivers/chromedriver.exe"))
                .build();
        driver = new ChromeDriver(service);
        driver.get(MAIN_URL);
    }

     /* Для тестирования в Яндекс.Браузере
    @Before
    public void startUpYandex() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:/Users/IGladkova/Diplom/Drivers/yandexdriver.exe");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get(MAIN_URL);
      }

      */

    @Test
    @DisplayName("Переход по клику на 'Личный кабинет'")
    public void LogInButtonOnMainPage() {
        mainPage = new MainPage(driver);
        mainPage.clickLkHeader();
        Assert.assertTrue(mainPage.checkCreateOrderButtonIsVisible());
          }
    @Test
    @DisplayName("Переход из 'Личного кабинета' в 'конструктор', когда пользователь неавторизован")
    public void jumpFromLkToConstructorNotAuthorizationUser() {
        mainPage = new MainPage(driver);
        mainPage.clickConstructorHeader();
        Assert.assertTrue("Если пользователь не авторизирован, то не перехода в ЛК", mainPage.checkLogInButtonIsVisible());
    }
  @After
    public void unLoad(){
        driver.quit();}

}
