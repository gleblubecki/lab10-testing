package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CaterpillarHomePage;
import page.CaterpillarItemPage;

public class CaterpillarTest {
    public static String EXPECTED_NAME = "Women's Triton Soft Shell Jacket";
    public static String EXPECTED_AMOUNT = "1";

    private static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAddItemToCart() {
        String amountOfProducts = new CaterpillarItemPage(driver)
                .openPage()
                .clickSizeButton()
                .addItemToCart()
                .getAmountOfProducts();
        Assert.assertEquals(amountOfProducts, EXPECTED_AMOUNT);
    }

    @Test
    public void testSearchItemByArticle() {
        String idOfItem = new CaterpillarHomePage(driver)
                .openPage()
                .searchForTerms(EXPECTED_NAME)
                .getArticleOfItem();
        Assert.assertEquals(idOfItem, EXPECTED_NAME);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown()  {
        driver.quit();
        driver = null;
    }
}