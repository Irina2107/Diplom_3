package org.example;

import com.github.javafaker.Faker;
import org.example.page_object.LogInPage;
import org.example.page_object.RegisterPage;
import org.example.user_config.UserClient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import static org.example.config.Client.REGISTER;


public class RegistrationTest {
    RegisterPage registerPage;
    LogInPage logInPage;
    UserClient userClient;
    Faker faker = new Faker();
    String name = faker.funnyName().name();
    String email = faker.internet().emailAddress();
    String password = "123456!";
    String token;
    WebDriver driver;

        @Before
        public void setUp() {
        String setBrowser = "browser";
        if (setBrowser.equals("chrome")) {
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("src/test/resources/chromedriver.exe"))
                    .build();
            driver = new ChromeDriver(service);
            driver.get(REGISTER);
        }
        else {
            // Для тестирования в Яндекс.Браузере
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.get(REGISTER);
             }
        }
        @Test
        public void registerPositiveTest () {
            registerPage = new RegisterPage(driver);
            registerPage.fillName(name);
            registerPage.fillEmail(email);
            registerPage.fillPassword(password);
            registerPage.registrationButtonOnRegisterPageClick();
            logInPage = new LogInPage(driver);
            Assert.assertTrue(logInPage.checkLogInVisible());
            System.out.println(email + password);
        }
        @Test
        public void registerNegativeTest () {
            registerPage = new RegisterPage(driver);
            String password = "123";
            registerPage.fillName(name);
            registerPage.fillEmail(email);
            registerPage.fillPassword(password);
            registerPage.registrationButtonOnRegisterPageClick();
            registerPage.verifyErrorRegisterWithIncorrectPassword();
        }
        @After
        public void unLoad () {
            if (token != null) {
                userClient.delete(token);
            }
            driver.quit();
        }
    }







