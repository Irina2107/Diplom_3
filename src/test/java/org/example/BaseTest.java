package org.example;

import com.github.javafaker.Faker;
import org.example.user_config.User;
import org.example.user_config.UserClient;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import static org.example.config.Client.MAIN_URL;
import static org.example.config.Client.REGISTER;

public class BaseTest {
    WebDriver driver;
    Faker faker = new Faker();
    String token;
    String name = faker.funnyName().name();
    String email = faker.internet().emailAddress();
    String password = "123456!";
    UserClient userClient = new UserClient(name, email, password);
    @Before
    public void setUp() {
        String setBrowser = "browser";
        if (setBrowser.equals("chrome")) {
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("src/test/resources/chromedriver.exe"))
                    .build();
            driver = new ChromeDriver(service);
            driver.get(MAIN_URL);
            User user = new User(name, email, password);
            token = userClient.register(user)
                    .extract().jsonPath().get("accessToken");

        } else {
            // Для тестирования в Яндекс.Браузере
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.get(MAIN_URL);

            User user = new User(name, email, password);
            token = userClient.register(user)
                    .extract().jsonPath().get("accessToken");
        }
    }
    @After
    public void unLoad() {
        if (token != null) {
            userClient.delete(token);
        }
        driver.quit();

    }
}










