import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.package_model.ConstructorMethods;
import ru.package_model.MainPageObject;

public class ConstructorTest {
    private WebDriver driver;
    private MainPageObject mainPageObject;
    private ConstructorMethods constructorMethods;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        constructorMethods = new ConstructorMethods(driver);
        mainPageObject = new MainPageObject();
        constructorMethods.getMainPage();
        constructorMethods.waitForMainPageLoad();
    }

    @After
   public void cleanUp() {
        driver.quit();
    }

    @Test
    public void sectionBunClickShowsBuns() {
        constructorMethods.clickSauceSection();
        constructorMethods.clickBunSection();
        WebElement bun = constructorMethods.getShinyBun();
        Assert.assertTrue("Element not found", bun.isDisplayed());
    }

    @Test
    public void sectionSauceClickShowsSauce() {
        constructorMethods.clickSauceSection();
        WebElement sauce = constructorMethods.getSpaceXSauce();
        Assert.assertTrue("Element not found", sauce.isDisplayed());
    }

    @Test
    public void sectionFillingClickShowsFilling() {
        constructorMethods.clickFillingSection();

        WebElement meat = constructorMethods.getFillingMeat();
        Assert.assertTrue("Element not found", meat.isDisplayed());
    }
}
