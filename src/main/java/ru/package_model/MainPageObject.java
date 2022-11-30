package ru.package_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageObject {
    WebDriver driver;
    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private final String MAIN_PAGE = "https://stellarburgers.nomoreparties.site/"; //главная страница
    private By PERSONAL_CABINET = By.xpath(".//p[text()='Личный Кабинет']"); //селектор для кнопки Личный кабинет


    public void enterPersonalCabinet() {
        driver.findElement(PERSONAL_CABINET).click();
    }

}
