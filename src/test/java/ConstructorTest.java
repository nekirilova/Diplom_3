import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.package_model.ConstructorMethods;
import ru.package_model.MainPageObject;

public class ConstructorTest {
    private WebDriver driver;
    private MainPageObject mainPageObject;
    private ConstructorMethods constructorMethods;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

//        ChromeOptions options = new ChromeOptions();
//        System.setProperty("webdriver.chrome.driver", "C:/Users/Aljona/ChromeDriver/yandexdriver.exe");
//        options.setBinary("C:/Users/Aljona/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
//        driver = new ChromeDriver(options);
        constructorMethods = new ConstructorMethods(driver);
        mainPageObject = new MainPageObject();
        constructorMethods.getMainPage(); //открываем главную страницу
        constructorMethods.waitForMainPageLoad(); //ждем загрузку главной страницы
    }

    @After
   public void cleanUp() {

        driver.quit();//закрываем браузер
    }

    @Test
    @DisplayName("Тест: клик на секцию Булки проматывает ингредиенты до булок")
    public void sectionBunClickShowsBuns() {
        constructorMethods.clickSauceSection();
        constructorMethods.clickBunSection();
        WebElement bun = constructorMethods.getShinyBun();//ищем ингредиент Булка
        Assert.assertTrue("Element not found", bun.isDisplayed());//проверяем, что он отображается на странице
    }

    @Test
    @DisplayName("Тест: клик на секцию Соусы проматывает ингредиенты до соусов")
    public void sectionSauceClickShowsSauce() {
        constructorMethods.clickSauceSection();
        WebElement sauce = constructorMethods.getSpaceXSauce();//ищем ингредиент Соус
        Assert.assertTrue("Element not found", sauce.isDisplayed());//проверяем, что он отображается на странице
    }

    @Test
    @DisplayName("Тест: клик на секцию Наполнитель проматывает ингредиенты до наполнений")
    public void sectionFillingClickShowsFilling() {
        constructorMethods.clickFillingSection();
        WebElement meat = constructorMethods.getFillingMeat(); //ищем ингредиент Мясо
        Assert.assertTrue("Element not found", meat.isDisplayed()); //проверяем, что он отображается на странице
    }
}
