package ru.package_model;

import org.openqa.selenium.By;

public class ForgotPasswordPageObject {
    private final By ENTER_BUTTON = By.xpath(".//p/a[text()='Войти']");

    public By getENTER_BUTTON() {
        return ENTER_BUTTON;
    }
}
