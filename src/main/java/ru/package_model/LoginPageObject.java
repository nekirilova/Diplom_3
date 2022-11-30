package ru.package_model;

import org.openqa.selenium.By;

public class LoginPageObject {
    private final String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
    private final By EMAIL_FIELD = By.xpath(".//div/label[text()='Email']");
    private final By PASSWORD_FIELD = By.xpath(".//div/label[text()='Пароль']");
    private final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    private final By REGISTER_LINK = By.xpath(".//div/p/a[text()='Зарегистрироваться']");

}
