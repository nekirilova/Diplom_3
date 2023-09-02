package ru.package_model;

import org.openqa.selenium.By;

public class LoginPageObject {
//страница авторизации, локаторы:
    private final String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
    private final By LOGIN_FORM = By.xpath(".//main/div/form"); //локатор для формы авторизации
    private final By EMAIL_FIELD = By.xpath("html/body/div/div/main/div/form/fieldset/div/div/input[@type='text']");
    private final By PASSWORD_FIELD = By.cssSelector("fieldset:nth-child(2)>div>div>input");
    private final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    private final By REGISTER_LINK = By.cssSelector("div>p:first-of-type>a");
    private final By RESTORE_PASSWORD = By.xpath(".//p/a[text()='Восстановить пароль']");
//геттеры для локаторов страницы:
    public String getLOGIN_PAGE() {
        return LOGIN_PAGE;
    }
    public By getLOGIN_FORM() {
        return LOGIN_FORM;
    }

    public By getEMAIL_FIELD() {
        return EMAIL_FIELD;
    }
    public By getPASSWORD_FIELD() {
        return PASSWORD_FIELD;
    }
    public By getLOGIN_BUTTON() {
        return LOGIN_BUTTON;
    }
    public By getREGISTER_LINK() {
        return REGISTER_LINK;
    }
       public By getRESTORE_PASSWORD() {
        return RESTORE_PASSWORD;
    }




}
