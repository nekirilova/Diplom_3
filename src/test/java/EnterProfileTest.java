import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.package_model.CredentialsGenerator;
import ru.package_model.LoginMethods;
import ru.package_model.MainPageObject;

import java.time.Duration;

public class EnterProfileTest {
    private WebDriver driver;
    private MainPageObject mainPageObject;
    private LoginMethods loginMethods;
    CredentialsGenerator credentialsGenerator;

    private String name;
    private String email;
    private String password;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        loginMethods = new LoginMethods(driver);
        loginMethods.getRegistrationPage();//открываем страницу регистрации
        loginMethods.waitForRegisterPageLoad();//ждем, когда загрузится страница регистрации
        credentialsGenerator = new CredentialsGenerator();
        mainPageObject = new MainPageObject();
        name = credentialsGenerator.getRandomName();
        email = credentialsGenerator.getRandomEmail();
        password = credentialsGenerator.getRandomPassword();
        loginMethods.enterNameForRegister(name);
        loginMethods.enterEmailForRegister(email);
        loginMethods.enterPasswordForRegister(password);
        loginMethods.registerButtonClick();
    }
    @After
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void enterAccountFromMainPageButtonIsSuccessful() {
        loginMethods.getMainPage();
        loginMethods.waitForMainPageLoad();
        loginMethods.enterAccountButtonClick();
        loginMethods.waitForLoginPageLoad();
        loginMethods.enterEmail(email);
        loginMethods.enterPassword(password);
        loginMethods.loginButtonClick();
        loginMethods.waitForMainPageLoad();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlToBe(mainPageObject.getMAIN_PAGE()));
        String expectedUrl = mainPageObject.getMAIN_PAGE();
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals("Incorrect URL", expectedUrl, actualUrl);
    }

    @Test
    public void enterAccountFromPersonalCabinetButtonIsSuccessful() {
        loginMethods.getMainPage();
        loginMethods.waitForMainPageLoad();
        loginMethods.getIntoProfile();
        loginMethods.waitForLoginPageLoad();
        loginMethods.enterEmail(email);
        loginMethods.enterPassword(password);
        loginMethods.loginButtonClick();
        loginMethods.waitForMainPageLoad();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlToBe(mainPageObject.getMAIN_PAGE()));
        String expectedUrl = mainPageObject.getMAIN_PAGE();
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals("Incorrect URL", expectedUrl, actualUrl);
    }

    @Test
    public void enterAccountFromRegistrationFormIsSuccessful() {
        loginMethods.getRegistrationPage();
        loginMethods.waitForRegisterPageLoad();
        loginMethods.loginButtonFromRegistrationPageClick();
        loginMethods.waitForLoginPageLoad();
        loginMethods.enterEmail(email);
        loginMethods.enterPassword(password);
        loginMethods.loginButtonClick();
        loginMethods.waitForMainPageLoad();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlToBe(mainPageObject.getMAIN_PAGE()));
        String expectedUrl = mainPageObject.getMAIN_PAGE();
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals("Incorrect URL", expectedUrl, actualUrl);
    }

    @Test
    public void enterAccountFromRestorePasswordButton() {
        loginMethods.getLoginPage();
        loginMethods.waitForLoginPageLoad();
        loginMethods.restorePasswordButtonClick();
        loginMethods.waitForForgotPasswordPageWait();
        loginMethods.enterButtonFromForgotPasswordClick();
        loginMethods.getLoginPage();
        loginMethods.waitForLoginPageLoad();
        loginMethods.enterEmail(email);
        loginMethods.enterPassword(password);
        loginMethods.loginButtonClick();
        loginMethods.waitForMainPageLoad();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlToBe(mainPageObject.getMAIN_PAGE()));
        String expectedUrl = mainPageObject.getMAIN_PAGE();
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals("Incorrect URL", expectedUrl, actualUrl);
    }

}
