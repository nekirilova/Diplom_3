import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.package_model.LoginMethods;
import ru.package_model.MainPageObject;

public class ConstructorTest {
    private WebDriver driver;
    private MainPageObject mainPageObject;
    private LoginMethods loginMethods;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        loginMethods = new LoginMethods(driver);
        mainPageObject = new MainPageObject();
        loginMethods.getMainPage();
        loginMethods.waitForMainPageLoad();
    }

    @After
   public void cleanUp() {

        driver.quit();
    }
}
