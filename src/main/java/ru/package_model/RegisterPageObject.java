package ru.package_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPageObject {
    private WebDriver driver;
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }
    private final String REGISTER_PAGE = "https://stellarburgers.nomoreparties.site/register";
    private final By REGISTRATION_FORM = By.xpath(".//div/form");
    private final By NAME_FIELD = By.xpath(".//div/label[text()='Имя']");
    private final By EMAIL_FIELD = By.xpath(".//div/label[text()='Email']");
    private final By PASSWORD_FIELD = By.xpath(".//div/label[text()='Пароль']");
    private final By REGISTER_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By LOGIN_BUTTON = By.xpath(".//div/p/a[text()='Войти']");

    //метод-ожидание загрузки страницы
    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(REGISTRATION_FORM)));
    }

//метод для ввода имени в поле Имя
public void enterName(String name) {
   driver.findElement(NAME_FIELD).sendKeys(name);
}
//метод для ввода емейла в поле Емейл
    public void enterEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    //метод для ввода пароля в поле Пароль
    public void enterPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    //метод для клика по кнопке Зарегистрироваться
    public void registerButtonClick() {
    driver.findElement(REGISTER_BUTTON).click();
    }

}
