package ru.package_model;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginMethods {
    private WebDriver driver;

    public LoginMethods(WebDriver driver) {
        this.driver = driver;
    }

    RegisterPageObject registerPageObject = new RegisterPageObject();
    LoginPageObject loginPageObject = new LoginPageObject();

    //метод для открытия страницы регистрации
    public void getRegistrationPage() {
        driver.get(registerPageObject.getREGISTER_PAGE());
    }
    //метод-ожидание загрузки страницы
    public void waitForRegisterPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(registerPageObject.getREGISTRATION_FORM())));
    }

    //метод для ввода имени в поле Имя
    public void enterNameForRegister(String name) {

        driver.findElement(registerPageObject.getNAME_FIELD()).sendKeys(name);
    }
    //метод для ввода емейла в поле Емейл
    public void enterEmailForRegister(String email) {

        driver.findElement(registerPageObject.getEMAIL_FIELD()).sendKeys(email);
    }

    //метод для ввода пароля в поле Пароль
    public void enterPasswordForRegister(String password) {

        driver.findElement(registerPageObject.getPASSWORD_FIELD()).sendKeys(password);
    }

    //метод для клика по кнопке Зарегистрироваться
    public void registerButtonClick()
    {
        driver.findElement(registerPageObject.getREGISTER_BUTTON()).click();
    }

    //метод для поиска текста ошибки о неправильном пароле
    public String getErrorMessage() {
        String errorMessage = driver.findElement(registerPageObject.getERROR_MESSAGE()).getText();
        return errorMessage;
    }
    //метод-ожидание загрузки страницы
    public void waitForLoginPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(loginPageObject.getEMAIL_FIELD())));
    }

    //метод для ввода емейла в поле емейл
    public void enterEmail(String email) {
        WebElement emailField =  driver.findElement(loginPageObject.getEMAIL_FIELD());
    //   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", emailField);
        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.presenceOfElementLocated(loginPageObject.getEMAIL_FIELD()));
        emailField.sendKeys(email);
    }
    //метод для ввода пароля в поле Пароль
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(loginPageObject.getPASSWORD_FIELD());
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", passwordField);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(passwordField));

                passwordField.sendKeys(password);
    }

    //метод для клика по кнопке Войти
    public void loginButtonClick() {
        WebElement loginButton = driver.findElement(loginPageObject.getLOGIN_BUTTON());
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    //метод для клика по кнопке Зарегистрироваться
    public void registerLinkClick() {
        driver.findElement(loginPageObject.getREGISTER_LINK());
    }

}
