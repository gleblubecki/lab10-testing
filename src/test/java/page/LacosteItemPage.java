package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LacosteItemPage extends AbstractPage{
    public static String LACOSTE_ITEM_PAGE_URL = "https://www.lacoste.pl/en/bh2153/53s-1/";

    @FindBy(xpath = "//a[@data-value='T48']")
    private WebElement buttonSize;
    @FindBy(xpath = "//button[@class='lc-button lc-button--wide md-px-0 js-sidepopup-trigger' and @data-target='product-sizes']")
    private WebElement selectOpen;
    @FindBy(id = "//button[@class='cookie-consent-accept js-cookie-consent-accept']")
    private WebElement cookies;
    @FindBy(xpath = "//div[@class='product-button-container l-pt-1']")
    private WebElement addToCartButton;

    public LacosteItemPage(WebDriver driver) {
        super(driver);
    }

    public LacosteItemPage closeCookies() {
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.elementToBeClickable(cookies));
        cookies.click();
        return this;
    }

    public LacosteItemPage clickSizeButton() {
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.elementToBeClickable(selectOpen));
        selectOpen.click();
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.elementToBeClickable(buttonSize));
        buttonSize.click();
        new WebDriverWait(webDriver, waitWebDriver);
        return this;
    }

    public LacosteItemPage addItemToCart() {
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        return this;
    }

    public String tryGetErrorMessadge() {
        WebElement getMessadge = new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "//span[@class='basket-icon-badge js-total-quantity']")));
        return getMessadge.getText();
    }

    public String getAmountOfProducts() {
        WebElement amountOfProductsInCart = new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "//span[@class='basket-icon-badge js-total-quantity']")));
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.visibilityOf(amountOfProductsInCart));
        return amountOfProductsInCart.getText();
    }

    @Override
    public LacosteItemPage openPage() {
        webDriver.get(LACOSTE_ITEM_PAGE_URL);
        return this;
    }
}