package ru.package_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;

public class ConstructorMethods {
    private WebDriver driver;

    public ConstructorMethods(WebDriver driver) {
        this.driver = driver;
    }
    MainPageObject mainPageObject = new MainPageObject();

    //метод для открытия главной страницы
    public void getMainPage() {
         driver.get(mainPageObject.getMAIN_PAGE());
    }

    //метод для ожидания загрузки главной страницы
    public void waitForMainPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .elementToBeClickable(mainPageObject.getPERSONAL_CABINET()));
    }

    //метод для клика по разделу Булки
    public void clickBunSection() {
        WebElement bunSection = driver.findElement(mainPageObject.getBUN());
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(bunSection));
        bunSection.click();
    }
    //метод для клика по разделу Соусы

    public void clickSauceSection() {
        WebElement sauceSection = driver.findElement(mainPageObject.getSAUCE());
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(sauceSection));
        sauceSection.click();
    }
    //метод для клика по разделу Начинки
    public void clickFillingSection() {
        WebElement fillingSection = driver.findElement(mainPageObject.getFILLING());
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fillingSection));
        fillingSection.click();
    }

    //метод для поиска флюорисцентной булки
    public WebElement getShinyBun() {
        return driver.findElement(mainPageObject.getSHINY_BUN());
    }
//метод для поиска соуса
    public WebElement getSpaceXSauce() {
        return driver.findElement(mainPageObject.getSPICY_X());
    }

    //метод для поиска начинки
    public WebElement getFillingMeat() {
        return driver.findElement(mainPageObject.getMEAT());
    }
}
