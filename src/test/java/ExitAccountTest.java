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

import java.time.Duration;

public class ExitAccountTest {

    private WebDriver driver;

    CredentialsGenerator credentialsGenerator;
    private LoginMethods loginMethods;
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
    public void exitAccountIsSuccessful() {
        loginMethods.getLoginPage();
        loginMethods.waitForLoginPageLoad();
        loginMethods.enterEmail(email);
        loginMethods.enterPassword(password);
        loginMethods.loginButtonClick();
        loginMethods.waitForMainPageLoad();
        loginMethods.getIntoProfile();
        loginMethods.waitForProfilePageLoad();
        loginMethods.exitProfile();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
        String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals("Incorrect URL", expectedUrl, actualUrl);
    }
}
