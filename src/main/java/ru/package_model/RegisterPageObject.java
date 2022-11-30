package ru.package_model;

import org.openqa.selenium.By;

public class RegisterPageObject {
    private final String REGISTER_PAGE = "https://stellarburgers.nomoreparties.site/register";
    private final By NAME_FIELD = By.xpath(".//div/label[text()='Имя']");
    private final By EMAIL_FIELD = By.xpath(".//div/label[text()='Email']");
    private final By PASSWORD_FIELD = By.xpath(".//div/label[text()='Пароль']");
    private final By REGISTER_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By LOGIN_BUTTON = By.xpath(".//div/p/a[text()='Войти']");




}
