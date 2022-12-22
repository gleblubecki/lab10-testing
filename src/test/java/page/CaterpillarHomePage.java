package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaterpillarHomePage extends AbstractPage {
    public static String CATERPILLAR_HOME_PAGE_URL = "https://www.catfootwear.com/US/en/home";

    @FindBy(xpath = "//input[@class='simplesearch simple-search-input']")
    private WebElement searchBox;

    public CaterpillarHomePage(WebDriver driver) {
        super(driver);
    }

    public CaterpillarHomePage openPage() {
        webDriver.get(CATERPILLAR_HOME_PAGE_URL);
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='simplesearch simple-search-input']")));
        return this;
    }

    public CaterpillarHomePage searchForTerms(String searchQuery) {
       new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(searchQuery);
        searchBox.sendKeys(Keys.ENTER);
        return new CaterpillarHomePage(webDriver);
    }

    public String getArticleOfItem() {
        WebElement idOfItem =  new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@data-stock-number='PA1310084-10121']")));
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.visibilityOf(idOfItem));
        return idOfItem.getText();
    }

}