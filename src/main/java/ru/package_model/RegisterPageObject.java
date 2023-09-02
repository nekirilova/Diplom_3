package ru.package_model;

import org.openqa.selenium.By;
//страница регистрации
public class RegisterPageObject {
//локаторы для страницы регистрации
    private final String REGISTER_PAGE = "https://stellarburgers.nomoreparties.site/register";
    private final By REGISTRATION_FORM = By.xpath(".//div/form");
    private final By NAME_FIELD = By.cssSelector("fieldset:first-of-type>div>div>input");
    private final By EMAIL_FIELD = By.cssSelector("fieldset:nth-child(2)>div>div>input");
    private final By PASSWORD_FIELD = By.cssSelector("fieldset:last-of-type>div>div>input");
    private final By REGISTER_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By LOGIN_BUTTON = By.xpath(".//div/p/a[text()='Войти']");
    private final By ERROR_MESSAGE = By.xpath(".//p[text()='Некорректный пароль']");

    //геттеры для локаторов
    public String getREGISTER_PAGE() {
        return REGISTER_PAGE;
    }

    public By getREGISTRATION_FORM() {
        return REGISTRATION_FORM;
    }

    public By getNAME_FIELD() {
        return NAME_FIELD;
    }

    public By getEMAIL_FIELD() {
        return EMAIL_FIELD;
    }

    public By getPASSWORD_FIELD() {
        return PASSWORD_FIELD;
    }

    public By getREGISTER_BUTTON() {
        return REGISTER_BUTTON;
    }

    public By getLOGIN_BUTTON() {
        return LOGIN_BUTTON;
    }

    public By getERROR_MESSAGE() {
        return ERROR_MESSAGE;
    }


}
