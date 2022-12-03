package ru.package_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPageObject {
    public AccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    private final String ACCOUNT_PAGE = "https://stellarburgers.nomoreparties.site/account/profile";
    private final By PROFILE_SECTION = By.xpath(".//a[text()='Профиль']");
    private final By TEXT = By.cssSelector("nav>p");

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(PROFILE_SECTION)));
    }

    public By getPROFILE_SECTION() {
        return PROFILE_SECTION;
    }
}
