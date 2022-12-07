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
        mainPageObject = new MainPageObject();
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
    @DisplayName("Тест: в профиль можно войти через кнопку на главной странице")
    public void enterAccountFromMainPageButtonIsSuccessful() {
        loginMethods.getMainPage(); //открываем главную страницу
        loginMethods.waitForMainPageLoad();//ждем загрузку страницы
        loginMethods.enterAccountButtonClick(); //нажимаем  на кнопку Войти в профиль
        loginMethods.waitForLoginPageLoad();//ждем загрузку страницы
        loginMethods.enterEmail(email); //вводим емейл
        loginMethods.enterPassword(password);//вводим пароль
        loginMethods.loginButtonClick(); //нажимаем на кнопку авторизации
        loginMethods.waitForMainPageLoad();// ждем загрузку страницы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(mainPageObject.getMAIN_PAGE()));
        String expectedUrl = mainPageObject.getMAIN_PAGE();//ожидаемый URL
        String actualUrl = driver.getCurrentUrl(); //фактический URL
        //сверяем ожидаемый и фактический адрес страницы
        Assert.assertEquals("Incorrect URL", expectedUrl, actualUrl);
    }

    @Test
    @DisplayName("Тест: в профиль можно войти через кнопку Личный кабинет на главной странице")
    public void enterAccountFromPersonalCabinetButtonIsSuccessful() {
        loginMethods.getMainPage(); //открываем главную страницу
        loginMethods.waitForMainPageLoad();//ждем загрузку страницы
        loginMethods.getIntoProfile(); //нажимаем на кнопку Личный кабинет
        loginMethods.waitForLoginPageLoad();//дждем загрузку страницы
        loginMethods.enterEmail(email); //вводим емейл
        loginMethods.enterPassword(password);//вводим пароль
        loginMethods.loginButtonClick(); //нажимаем на кнопку авторизации
        loginMethods.waitForMainPageLoad();// ждем загрузку страницы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(mainPageObject.getMAIN_PAGE()));
        String expectedUrl = mainPageObject.getMAIN_PAGE();//ожидаемый URL
        String actualUrl = driver.getCurrentUrl(); //фактический URL
        //сверяем ожидаемый и фактический адрес страницы
        Assert.assertEquals("Incorrect URL", expectedUrl, actualUrl);
    }

    @Test
    @DisplayName("Тест: в профиль можно войти через форму регистрации")
    public void enterAccountFromRegistrationFormIsSuccessful() {
        loginMethods.getRegistrationPage();//открываем страницу регистрации
        loginMethods.waitForRegisterPageLoad();//ждем ее загрузку
        loginMethods.loginButtonFromRegistrationPageClick();
        loginMethods.waitForLoginPageLoad();//дждем загрузку страницы
        loginMethods.enterEmail(email); //вводим емейл
        loginMethods.enterPassword(password);//вводим пароль
        loginMethods.loginButtonClick(); //нажимаем на кнопку авторизации
        loginMethods.waitForMainPageLoad();// ждем загрузку страницы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(mainPageObject.getMAIN_PAGE()));
        String expectedUrl = mainPageObject.getMAIN_PAGE();//ожидаемый URL
        String actualUrl = driver.getCurrentUrl(); //фактический URL
        //сверяем ожидаемый и фактический адрес страницы
        Assert.assertEquals("Incorrect URL", expectedUrl, actualUrl);
    }

    @Test
    @DisplayName("Тест: в профиль можно войти через страницу восстановления пароля")
    public void enterAccountFromRestorePasswordButton() {
        loginMethods.getLoginPage();//открываем страницу авторизации
        loginMethods.waitForLoginPageLoad();//ждем ее загрузку
        loginMethods.restorePasswordButtonClick();//нажимаем на кнопку Восстановить пароль
        loginMethods.waitForForgotPasswordPageWait(); //ждем загрузку страницы
        loginMethods.enterButtonFromForgotPasswordClick(); //нажимаем на кнопку Войти
        loginMethods.getLoginPage();//заходим на страницу авторизации
        loginMethods.waitForLoginPageLoad();//дждем загрузку страницы
        loginMethods.enterEmail(email); //вводим емейл
        loginMethods.enterPassword(password);//вводим пароль
        loginMethods.loginButtonClick(); //нажимаем на кнопку авторизации
        loginMethods.waitForMainPageLoad();// ждем загрузку страницы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(mainPageObject.getMAIN_PAGE()));
        String expectedUrl = mainPageObject.getMAIN_PAGE();//ожидаемый URL
        String actualUrl = driver.getCurrentUrl(); //фактический URL
        //сверяем ожидаемый и фактический адрес страницы
        Assert.assertEquals("Incorrect URL", expectedUrl, actualUrl);
    }

}
