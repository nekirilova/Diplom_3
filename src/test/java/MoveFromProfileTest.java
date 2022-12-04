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

public class MoveFromProfileTest {
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
        loginMethods = new LoginMethods(driver);
        loginMethods.getRegistrationPage();//открываем страницу регистрации
        loginMethods.waitForRegisterPageLoad();//ждем, когда загрузится страница регистрации
        credentialsGenerator = new CredentialsGenerator(); //создаем объект класса для генерации тестовых данных
        name = credentialsGenerator.getRandomName(); //создаем рандомное имя
        email = credentialsGenerator.getRandomEmail();//создаем рандомный емейл
        password = credentialsGenerator.getRandomPassword();//создаем рандомный пароль
        loginMethods.enterNameForRegister(name); //вводим имя в поле Имя
        loginMethods.enterEmailForRegister(email); //вводим емейл
        loginMethods.enterPasswordForRegister(password);//вводим пароль
        loginMethods.registerButtonClick(); //кликаем на кнопку Зарегистрироваться
    }
    @After
    public void cleanUp() {
        driver.quit(); //закрываем браузер
    }
    @Test
    @DisplayName("Тест: из профиля можно попасть на главную страницу кликом на кнопку Конструктор")
    public void moveFromProfileByConstructorButtonIsSuccessful() {
        loginMethods.getLoginPage(); //заходим на страницу авторизации
        loginMethods.waitForLoginPageLoad();//ждем загрузки страницы
        loginMethods.enterEmail(email); //вводим емейл
        loginMethods.enterPassword(password); //вводим пароль
        loginMethods.loginButtonClick();//кликаем на кнопку Войти
        loginMethods.waitForMainPageLoad();//ждем загрузки страницы
        loginMethods.getIntoProfile();//кликаем на кнопку Личный кабинет
        loginMethods.waitForProfilePageLoad();//ждем загрузки страницы с профилем
        loginMethods.getIntoMainPageByConstructorButton();//кликаем на кнопку Конструктор

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));//ждем, пока загрузится главная страница
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";//ожидаемый URL
        String actualUrl = driver.getCurrentUrl(); //фактический ERL
        Assert.assertEquals("Incorrect URL", expectedUrl, actualUrl); //проверяем, что ожидаемый и фактический URL совпадают
    }

    @Test
    @DisplayName("Тест: из профиля можно попасть на главную страницу кликом по логотипу")
    public void moveFromProfileByLogoIsSuccessful() {
        loginMethods.getLoginPage(); //заходим на страницу авторизации
        loginMethods.waitForLoginPageLoad();//ждем загрузки страницы
        loginMethods.enterEmail(email); //вводим емейл
        loginMethods.enterPassword(password); //вводим пароль
        loginMethods.loginButtonClick();//кликаем на кнопку Войти
        loginMethods.waitForMainPageLoad();//ждем загрузки страницы
        loginMethods.getIntoProfile();//кликаем на кнопку Личный кабинет
        loginMethods.waitForProfilePageLoad();//ждем загрузки страницы с профилем
        loginMethods.getIntoMainPageByLogo();//кликаем на логотип

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));//ждем, пока загрузится главная страница
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";//ожидаемый URL
        String actualUrl = driver.getCurrentUrl(); //фактический ERL
        Assert.assertEquals("Incorrect URL", expectedUrl, actualUrl); //проверяем, что ожидаемый и фактический URL совпадают
    }
}
