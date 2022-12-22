import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LacosteItemPage;

public class LacosteTest {
    public static String EXPECTED_MESSADGE = "0";
    public static String EXPECTED_AMOUNT = "1";

    private static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAddItemToCart() {
        String amountOfProducts = new LacosteItemPage(driver)
                .openPage()
                .closeCookies()
                .clickSizeButton()
                .addItemToCart()
                .getAmountOfProducts();
        Assert.assertEquals(amountOfProducts, EXPECTED_AMOUNT);
    }

    @Test
    public void getErrorMessadge() {
        String amountOfProducts = new LacosteItemPage(driver)
                .openPage()
                .closeCookies()
                .addItemToCart()
                .tryGetErrorMessadge();
        Assert.assertEquals(amountOfProducts, EXPECTED_MESSADGE);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown()  {
        driver.quit();
        driver = null;
    }
}

