package ru.package_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//класс с методами для регистрации и авторизации
public class LoginMethods {
    private WebDriver driver;

    public LoginMethods(WebDriver driver) {
        this.driver = driver;
    }

    RegisterPageObject registerPageObject = new RegisterPageObject();
    LoginPageObject loginPageObject = new LoginPageObject();
    MainPageObject mainPageObject = new MainPageObject();
    AccountPageObject accountPageObject = new AccountPageObject();
    ForgotPasswordPageObject forgotPasswordPageObject
             = new ForgotPasswordPageObject();
//СТРАНИЦА РЕГИСТРАЦИИ:
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
    //метод для клика по кнопке Войти на странице регистрации
    public void loginButtonFromRegistrationPageClick() {
        driver.findElement(registerPageObject.getLOGIN_BUTTON()).click();
    }
   //метод для поиска текста ошибки о неправильном пароле
    public String getErrorMessage() {
        String errorMessage = driver.findElement(registerPageObject.getERROR_MESSAGE()).getText();
        return errorMessage;
    }


    //СТРАНИЦА АВТОРИЗАЦИИ:
    //метод для открытия страницы авторизации
    public void getLoginPage() {
        driver.get(loginPageObject.getLOGIN_PAGE());
    }
    //метод-ожидание загрузки страницы авторизации
    public void waitForLoginPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(loginPageObject.getEMAIL_FIELD())));
    }
    //метод для ввода емейла в поле емейл
    public void enterEmail(String email) {
        WebElement emailField =  driver.findElement(loginPageObject.getEMAIL_FIELD());

        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.presenceOfElementLocated(loginPageObject.getEMAIL_FIELD()));
        emailField.sendKeys(email);
    }
    //метод для ввода пароля в поле Пароль
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(loginPageObject.getPASSWORD_FIELD());
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
    //метод для клика по кнопке Восстановить пароль
    public void restorePasswordButtonClick() {
        driver.findElement(loginPageObject.getRESTORE_PASSWORD()).click();
    }


    //ГЛАВНАЯ СТРАНИЦА:
    //метод для открытия главной страниц
    public void getMainPage() {
        driver.get(mainPageObject.getMAIN_PAGE());
    }
    //метод для ожидания загрузки главной страницы
    public void waitForMainPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .elementToBeClickable(mainPageObject.getPERSONAL_CABINET()));
    }
    //метод для клика по кнопке Войти в аккаунт
    public void enterAccountButtonClick() {
       WebElement enterAccountButton = driver.findElement(mainPageObject.getENTER_ACCOUNT_BUTTON());
       new WebDriverWait(driver, Duration.ofSeconds(5))
               .until(ExpectedConditions.elementToBeClickable(enterAccountButton));
       enterAccountButton.click();
    }
    //метод для клика по кнопке личный кабинет на главной странице
    public void getIntoProfile() {
        driver.findElement(mainPageObject.getPERSONAL_CABINET()).click();
    }


    //СТРАНИЦА ПРОФИЛЯ:
    //метод для ожидания загрузки страницы профиля
    public void waitForProfilePageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .elementToBeClickable(accountPageObject.getEXIT_BUTTON()));
    }
    //метод для перехода из личного кабинета на главную страницу по кнопке "Конструктор"
    public void getIntoMainPageByConstructorButton() {
        WebElement constructorButton = driver
                .findElement(accountPageObject.getCONSTRUCTOR());
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(constructorButton));
        constructorButton.click();
    }
    //метод для перехода из личного кабинета на главную страницу кликом на логотип
    public void getIntoMainPageByLogo() {
        WebElement logo = driver
                .findElement(accountPageObject.getLOGO());
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(logo));
        logo.click();
    }
    //метод для клика по кнопке Выход
    public void exitProfile() {
        driver.findElement(accountPageObject.getEXIT_BUTTON()).click();
    }


    //СТРАНИЦА ВОССТАНОВЛЕНИЯ ПАРОЛЯ:
    //метод ожидания загрузки страницы восстановления пароля
    public void waitForForgotPasswordPageWait() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(forgotPasswordPageObject.getENTER_BUTTON()));
    }
    //метод для клика по кнопке Войти на странице восстановления пароля
  public void enterButtonFromForgotPasswordClick() {

        driver.findElement(forgotPasswordPageObject.getENTER_BUTTON());
  }
}
