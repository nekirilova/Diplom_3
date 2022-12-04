package ru.package_model;

import org.openqa.selenium.By;

public class AccountPageObject {

    public String getACCOUNT_PAGE() {
        return ACCOUNT_PAGE;
    }

    public By getPROFILE_SECTION() {
        return PROFILE_SECTION;
    }

    public By getTEXT() {
        return TEXT;
    }

    public By getEXIT_BUTTON() {
        return EXIT_BUTTON;
    }

    private final String ACCOUNT_PAGE = "https://stellarburgers.nomoreparties.site/account/profile";
    private final By PROFILE_SECTION = By.xpath(".//a[text()='Профиль']");
    private final By TEXT = By.cssSelector("nav>p");
    private final By EXIT_BUTTON = By.xpath(".//button[text()='Выход']");

    private final By CONSTRUCTOR = By.xpath(".//a/p[text()='Конструктор']");
    private final By LOGO = By.cssSelector("header>nav>div>a");

    public By getLOGO() {
        return LOGO;
    }

    public By getCONSTRUCTOR() {
        return CONSTRUCTOR;
    }
}