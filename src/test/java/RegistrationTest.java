import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.package_model.*;

import java.time.Duration;

public class RegistrationTest {
    private WebDriver driver;
    private MainPageObject mainPageObject;
    CredentialsGenerator credentialsGenerator;
    private RegisterPageObject registerPageObject;
    private AccountPageObject accountPageObject;
    private LoginPageObject loginPageObject;
    private LoginMethods loginMethods;
    private String name;
    private String email;
    private String password;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
     registerPageObject = new RegisterPageObject();

        loginMethods = new LoginMethods(driver);
        loginMethods.getRegistrationPage();//открываем страницу регистрации
        loginMethods.waitForRegisterPageLoad();//ждем, когда загрузится страница регистрации
        credentialsGenerator = new CredentialsGenerator();
        name = credentialsGenerator.getRandomName();
        email = credentialsGenerator.getRandomEmail();
        password = credentialsGenerator.getRandomPassword();
    }
    @After
    public void cleanUp() {
      driver.quit();
    }

    @Test
    public void registrationWithCorrectDataIsSuccessful() {
        loginMethods.enterNameForRegister(name);
        loginMethods.enterEmailForRegister(email);
        System.out.println(email);
        loginMethods.enterPasswordForRegister(password);
        System.out.println(password);
        loginMethods.registerButtonClick();
        Boolean wait = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.not(ExpectedConditions
                        .visibilityOf(driver.findElement(registerPageObject.getERROR_MESSAGE()))));
System.out.println(wait);
//Assert.assertNull(driver.findElement(registerPageObject.getERROR_MESSAGE()));


    }

}
