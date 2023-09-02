package ru.package_model;

import org.openqa.selenium.By;
//страница восстановления пароля
public class ForgotPasswordPageObject {
    private final By ENTER_BUTTON = By.xpath(".//p/a[text()='Войти']");//кнопка Войти на странице восстановления пароля
    //геттер для кнопки
    public By getENTER_BUTTON() {
        return ENTER_BUTTON;
    }
}
