import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.package_model.CredentialsGenerator;
import ru.package_model.LoginMethods;

public class RegistrationFailTest {

    private WebDriver driver;

    CredentialsGenerator credentialsGenerator;
    private LoginMethods loginMethods;
    private String name;
    private String email;
    private String incorrrectPassword;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        loginMethods = new LoginMethods(driver);
        loginMethods.getRegistrationPage();//открываем страницу регистрации
        loginMethods.waitForRegisterPageLoad();//ждем, когда загрузится страница регистрации
        credentialsGenerator = new CredentialsGenerator();
        name = credentialsGenerator.getRandomName();
        email = credentialsGenerator.getRandomEmail();
        incorrrectPassword = credentialsGenerator.getIncorrectPassword();
    }
    @After
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void registrationWithShortPasswordReturnsErrorMessage() {
        loginMethods.enterNameForRegister(name);
        loginMethods.enterEmailForRegister(email);
        loginMethods.enterPasswordForRegister(incorrrectPassword);

        loginMethods.registerButtonClick();
        String expectedErrorMessage = "Некорректный пароль";
        String actualErrorMessage = loginMethods.getErrorMessage();
        System.out.println(actualErrorMessage);
        Assert.assertEquals("Incorrect error message", expectedErrorMessage,actualErrorMessage);
    }
}
