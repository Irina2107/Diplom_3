package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.page_object.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class ConstructionTest extends BaseTest {
    MainPage mainPage;

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