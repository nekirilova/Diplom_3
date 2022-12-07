import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.package_model.*;

public class RegistrationTest {
    private WebDriver driver;
    CredentialsGenerator credentialsGenerator;
    private AccountPageObject accountPageObject;
    private LoginMethods loginMethods;
    private String name;
    private String email;
    private String password;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        //        ChromeOptions options = new ChromeOptions();
//        System.setProperty("webdriver.chrome.driver", "C:/Users/Aljona/ChromeDriver/yandexdriver.exe");
//        options.setBinary("C:/Users/Aljona/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
//        driver = new ChromeDriver(options);
        accountPageObject = new AccountPageObject();
        loginMethods = new LoginMethods(driver);
        loginMethods.getRegistrationPage();//открываем страницу регистрации
        loginMethods.waitForRegisterPageLoad();//ждем, когда загрузится страница регистрации
        credentialsGenerator = new CredentialsGenerator();
        name = credentialsGenerator.getRandomName(); //создаем рандомное имя
        email = credentialsGenerator.getRandomEmail();//создаем рандомный емейл
        password = credentialsGenerator.getRandomPassword();//создаем рандомный пароль
    }
    @After
    public void cleanUp() {
      driver.quit();
    }

    @Test
    @DisplayName("Тест: можно зарегистрироваться с корректными данными")
    public void registrationWithCorrectDataIsSuccessful() {
        loginMethods.enterNameForRegister(name);//вводим Имя в поле имя
        loginMethods.enterEmailForRegister(email);//вводим емейл в поле
        loginMethods.enterPasswordForRegister(password);//вводим пароль в поле
        loginMethods.registerButtonClick();//нажимаем на кнопку Зарегистрироваться
        loginMethods.getLoginPage(); //переходим на страницу авторизации
        loginMethods.waitForLoginPageLoad();//ждем загрузки страницы
        loginMethods.enterEmail(email);//вводим емейл
        loginMethods.enterPassword(password);//вводим пароль
        loginMethods.loginButtonClick();//нажимаем на кнопку Войти
        loginMethods.waitForMainPageLoad();//ждем загрузку страницы
        loginMethods.getIntoProfile();//нажимаем кнопку Личный кабинет
        loginMethods.waitForProfilePageLoad();//ждем загрузку страницы
        Assert.assertTrue(driver.findElement(accountPageObject.getEXIT_BUTTON()).isDisplayed());//проверяем, что мы попали в профиль

    }

}
