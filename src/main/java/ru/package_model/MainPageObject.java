package ru.package_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageObject {
    public String getMAIN_PAGE() {
        return MAIN_PAGE;
    }

    public By getPERSONAL_CABINET() {
        return PERSONAL_CABINET;
    }

    public By getBUN() {
        return BUN;
    }

    public By getSAUCE() {
        return SAUCE;
    }

    public By getFILLING() {
        return FILLING;
    }

    private final String MAIN_PAGE = "https://stellarburgers.nomoreparties.site/"; //главная страница
    private final By PERSONAL_CABINET = By.xpath(".//p[text()='Личный Кабинет']"); //селектор для кнопки Личный кабинет
    private final By BUN = By.xpath(".//div/span[text()='Булки']"); //локатор для раздела Булки
    private final By SAUCE = By.xpath(".//div/span[text()='Соусы']");//локатор для раздела Соусы
    private final By FILLING = By.xpath(".//div/span[text()='Начинки']");//локатор для раздела Начинки

}
