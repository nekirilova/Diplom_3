package ru.package_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageObject {
    private WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private final String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
    private final By LOGIN_FORM = By.xpath(".//main/div/form");
    private final By EMAIL_FIELD = By.xpath(".//div/label[text()='Email']");
    private final By PASSWORD_FIELD = By.xpath(".//div/label[text()='Пароль']");
    private final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    private final By REGISTER_LINK = By.xpath(".//div/p/a[text()='Зарегистрироваться']");
    //метод ожидания загрузки страницы
    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(LOGIN_FORM)));
    }

    //метод для ввода емейла в поле емейл
    public void enterEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    //метод для ввода пароля в поле Пароль
    public void enterPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    //метод для клика по кнопке Войти
    public void loginButtonClick() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    //метод для клика по кнопке Зарегистрироваться
    public void registerLinkClick() {
        driver.findElement(REGISTER_LINK);
    }

}
