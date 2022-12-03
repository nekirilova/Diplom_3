package ru.package_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageObject {
    WebDriver driver;
    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private final String MAIN_PAGE = "https://stellarburgers.nomoreparties.site/"; //главная страница
    private final By PERSONAL_CABINET = By.xpath(".//p[text()='Личный Кабинет']"); //селектор для кнопки Личный кабинет
    private final By BUN = By.xpath(".//div/span[text()='Булки']"); //локатор для раздела Булки
    private final By SAUCE = By.xpath(".//div/span[text()='Соусы']");//локатор для раздела Соусы
    private final By FILLING = By.xpath(".//div/span[text()='Начинки']");//локатор для раздела Начинки
    //метод для открытия главной страницы
    public void getMainPage() {
        driver.get(MAIN_PAGE);
    }

    //метод ожидания загрузки страницы
    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(PERSONAL_CABINET)));
    }
    //метод для клика по кнопке Личный кабинет
    public void enterPersonalCabinet() {
        driver.findElement(PERSONAL_CABINET).click();
    }

    //метод для клика по кнопке Булки
    public void sectionBunClick() {
        driver.findElement(BUN).click();
    }

    //метод для клика по кнопке Соусы
    public void sectionSauceClick() {
        driver.findElement(SAUCE).click();
    }

    //метод для клика по кнопке Начинки
    public void sectionFillingClick() {
        driver.findElement(FILLING).click();
    }
}
