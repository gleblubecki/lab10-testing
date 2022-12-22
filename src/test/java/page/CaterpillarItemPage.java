package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaterpillarItemPage extends AbstractPage{
    public static String CATERPILLAR_ITEM_PAGE_URL = "https://www.timberland.com/shop/mens-davis-square-chukka-shoes-blue-a1sf3019";

    @FindBy(xpath = "//*[@id=\"swatch-select a size-XL\"]")
    private WebElement buttonSize;

    @FindBy(xpath = "//*[@id=\"dimensions-combined-44270W\"]/ul/li/div/ul/li[5]")
    private WebElement addToCartButton;

    public CaterpillarItemPage(WebDriver driver) {
        super(driver);
    }

    public CaterpillarItemPage clickSizeButton() {
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.elementToBeClickable(buttonSize));
        buttonSize.click();
        return this;
    }

    public CaterpillarItemPage addItemToCart() {
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        return this;
    }

    public String getAmountOfProducts() {
        WebElement amountOfProductsInCart = new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='mini-cart-quantity-bag new-header ']")));
        new WebDriverWait(webDriver, waitWebDriver);
        return amountOfProductsInCart.getText();
    }

    @Override
    public CaterpillarItemPage openPage() {
        webDriver.get(CATERPILLAR_ITEM_PAGE_URL);
        return this;
    }
}