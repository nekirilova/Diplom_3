package ru.package_model;

import org.openqa.selenium.By;

public class MainPageObject {
//локаторы главной страницы
    private final String MAIN_PAGE = "https://stellarburgers.nomoreparties.site/"; //главная страница
    private final By PERSONAL_CABINET = By.xpath(".//p[text()='Личный Кабинет']"); //селектор для кнопки Личный кабинет
    private final By BUN = By.xpath(".//div/span[text()='Булки']"); //локатор для раздела Булки
    private final By SAUCE = By.xpath(".//div/span[text()='Соусы']");//локатор для раздела Соусы
    private final By FILLING = By.xpath(".//div/span[text()='Начинки']");//локатор для раздела Начинки
    private final By ENTER_ACCOUNT_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");//локатор для кнопки Войти в аккаунт

    private final By SPICY_X = By.xpath(".//ul/a/p[text()='Соус Spicy-X']"); //локатор для соуса Spicy-X
    private final By MEAT = By.xpath(".//ul/a/p[text()='Мясо бессмертных моллюсков Protostomia']");//Локатор для начинки
    private final By SHINY_BUN = By.xpath(".//ul/a/p[text()='Флюоресцентная булка R2-D3']");//локатор для булки
//геттеры для локаторов главной страницы
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
    public By getENTER_ACCOUNT_BUTTON() {
        return ENTER_ACCOUNT_BUTTON;
    }


    public By getSHINY_BUN() {
        return SHINY_BUN;
    }

    public By getMEAT() {
        return MEAT;
    }

    public By getSPICY_X() {
        return SPICY_X;
    }
}
