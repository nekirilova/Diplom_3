package ru.package_model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ConstructorMethods {
    private WebDriver driver;

    public ConstructorMethods(WebDriver driver) {
        this.driver = driver;
    }
    MainPageObject mainPageObject = new MainPageObject();

    @Step("метод для открытия главной страницы")
    public void getMainPage() {
         driver.get(mainPageObject.getMAIN_PAGE());
    }

    @Step("метод для ожидания загрузки главной страницы")
    public void waitForMainPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .elementToBeClickable(mainPageObject.getPERSONAL_CABINET()));
    }

    @Step("метод для клика по разделу Булки")
    public void clickBunSection() {
        WebElement bunSection = driver.findElement(mainPageObject.getBUN());
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(bunSection));
        bunSection.click();
    }
    @Step("метод для клика по разделу Соусы")
    public void clickSauceSection() {
        WebElement sauceSection = driver.findElement(mainPageObject.getSAUCE());
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(sauceSection));
        sauceSection.click();
    }
    @Step("метод для клика по разделу Начинки")
    public void clickFillingSection() {
        WebElement fillingSection = driver.findElement(mainPageObject.getFILLING());
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fillingSection));
        fillingSection.click();
    }

    @Step("метод для поиска флюорисцентной булки")
    public WebElement getShinyBun() {
        return driver.findElement(mainPageObject.getSHINY_BUN());
    }
    @Step("метод для поиска соуса")
    public WebElement getSpaceXSauce() {
        return driver.findElement(mainPageObject.getSPICY_X());
    }

    @Step("метод для поиска начинки")
    public WebElement getFillingMeat() {
        return driver.findElement(mainPageObject.getMEAT());
    }
}
