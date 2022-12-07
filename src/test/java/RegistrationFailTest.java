import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.package_model.CredentialsGenerator;
import ru.package_model.LoginMethods;

public class RegistrationFailTest {

    private WebDriver driver;
    CredentialsGenerator credentialsGenerator;
    private LoginMethods loginMethods;
    private String name;
    private String email;
    private String incorrectPassword;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        //        ChromeOptions options = new ChromeOptions();
//        System.setProperty("webdriver.chrome.driver", "C:/Users/Aljona/ChromeDriver/yandexdriver.exe");
//        options.setBinary("C:/Users/Aljona/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
//        driver = new ChromeDriver(options);
        loginMethods = new LoginMethods(driver);
        loginMethods.getRegistrationPage();//открываем страницу регистрации
        loginMethods.waitForRegisterPageLoad();//ждем, когда загрузится страница регистрации
        credentialsGenerator = new CredentialsGenerator();
        name = credentialsGenerator.getRandomName(); //создаем рандомное имя
        email = credentialsGenerator.getRandomEmail();//создаем рандомный емейл
        incorrectPassword = credentialsGenerator.getIncorrectPassword();//создаем неправильный (короткий) пароль
    }
    @After
    public void cleanUp() {
        driver.quit();
    }

    @Test
    @DisplayName("Тест: регистрация с коротким паролем выдает ошибку")
    public void registrationWithShortPasswordReturnsErrorMessage() {
        loginMethods.enterNameForRegister(name); //вводим имя
        loginMethods.enterEmailForRegister(email);//вводим емейл
        loginMethods.enterPasswordForRegister(incorrectPassword); //вводим пароль

        loginMethods.registerButtonClick();//нажимаем на кнопку Зарегистрироваться
        String expectedErrorMessage = "Некорректный пароль"; //ожидаемое сообщение об ошибке
        String actualErrorMessage = loginMethods.getErrorMessage(); //фактическое сообщение об ошибке
        //проверяем, что сообщение об ошибке соответствует ожидаемому
        Assert.assertEquals("Incorrect error message", expectedErrorMessage,actualErrorMessage);
    }
}
