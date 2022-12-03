package ru.package_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageObject {


    private final String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
    private final By LOGIN_FORM = By.xpath(".//main/div/form");

    public String getLOGIN_PAGE() {
        return LOGIN_PAGE;
    }

    public By getLOGIN_FORM() {
        return LOGIN_FORM;
    }

    public By getENTER() {
        return ENTER;
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

    private final By ENTER = By.xpath(".//h2[text()='Вход']");

   //private final By EMAIL_FIELD = By.cssSelector("fieldset:nth-child(1)>div>div>input");
   private final By EMAIL_FIELD = By.xpath("html/body/div/div/main/div/form/fieldset/div/div/input[@type='text']");
  private final By PASSWORD_FIELD = By.cssSelector("fieldset:nth-child(2)>div>div>input");
   // private final By PASSWORD_FIELD = By.xpath(".//input[@type='password']");
    private final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    private final By REGISTER_LINK = By.cssSelector("div>p:first-of-type>a");
    //метод ожидания загрузки страницы





}
