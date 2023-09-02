import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        password = credentialsGenerator.getRandomPassword();//создаем рандомный пароль
        loginMethods.enterNameForRegister(name);//вводим Имя в поле имя
        loginMethods.enterEmailForRegister(email);//вводим емейл в поле
        loginMethods.enterPasswordForRegister(password);//вводим пароль в поле
        loginMethods.registerButtonClick();//нажимаем на кнопку Зарегистрироваться
    }
    @After
    public void cleanUp() {
        driver.quit();
    }
    @Test
    @DisplayName("Тест: можно выйти из аккаунта по кнопке в профиле")
    public void exitAccountIsSuccessful() {
        loginMethods.getLoginPage();//открываем страницу авторизации
        loginMethods.waitForLoginPageLoad();//ждем ее загрузку
        loginMethods.enterEmail(email); //вводим емейл
        loginMethods.enterPassword(password);//вводим пароль
        loginMethods.loginButtonClick(); //нажимаем на кнопку авторизации
        loginMethods.waitForMainPageLoad(); //ждем загрузку
        loginMethods.getIntoProfile(); //переходим в личный кабинет
        loginMethods.waitForProfilePageLoad(); //ждем загрузку страницы
        loginMethods.exitProfile();//нажимаем на кнопку Выйти
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login")); //ждем загрузку страницы авторизации
        String expectedUrl = "https://stellarburgers.nomoreparties.site/login"; //ожидаемый URL
        String actualUrl = driver.getCurrentUrl();//фактический URL
        //сравниваем ожидаемый и фактический URL
        Assert.assertEquals("Incorrect URL", expectedUrl, actualUrl);
    }
}
