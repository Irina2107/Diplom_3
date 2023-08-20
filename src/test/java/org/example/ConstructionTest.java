package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.page_object.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import java.io.File;
import static org.example.config.Client.MAIN_URL;

public class ConstructionTest extends BaseTest {
    MainPage mainPage;
    @Before
    public void setUp() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:/Users/IGladkova/Diplom/Drivers/chromedriver.exe"))
                .build();
        driver = new ChromeDriver(service);
        driver.get(MAIN_URL);
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Соусы'")
    public void openSauceSection() {
        mainPage = new MainPage(driver);
        mainPage.clickSauceSection();
        Assert.assertTrue(mainPage.sauceSectionIsVisible());
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Начинки'")
    public void openFillingSection() {
        mainPage = new MainPage(driver);
        mainPage.clickFillingSection();
        Assert.assertTrue(mainPage.fillingSectionIsVisible());
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Булки'")
    public void openBunSection() {
        mainPage = new MainPage(driver);
        mainPage.clickFillingSection();
        mainPage.clickBunSection();
        Assert.assertTrue(mainPage.bunSectionIsVisible());
    }

    @After
    public void unLoad() {
                driver.quit();
    }

}