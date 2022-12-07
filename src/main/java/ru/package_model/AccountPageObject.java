package ru.package_model;

import org.openqa.selenium.By;
//страница профиля
public class AccountPageObject {

    private final String ACCOUNT_PAGE = "https://stellarburgers.nomoreparties.site/account/profile";
    private final By EXIT_BUTTON = By.xpath(".//button[text()='Выход']");

    private final By CONSTRUCTOR = By.xpath(".//a/p[text()='Конструктор']");
    private final By LOGO = By.cssSelector("header>nav>div>a");

    public By getLOGO() {
        return LOGO;
    }

    public By getCONSTRUCTOR() {
        return CONSTRUCTOR;
    }

       public By getEXIT_BUTTON() {
        return EXIT_BUTTON;
    }

}