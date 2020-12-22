package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BucketPage extends AbstractPage {
    private static final String ITEM_PAGE_URL = "https://5element.by/cart";
    private final Logger logger = LogManager.getRootLogger();

    public BucketPage(WebDriver driver) {
        super(driver);
    }

//    private By submitPromoCodeButtonLocator = By.xpath("//button[@class='btn js-bind-promo_submit btn-orange']");

    @FindBy(xpath = "//div[@id='stepCartFirst']/div[2]")
    private WebElement firstAddedProduct;

//    @FindBy(xpath = "//input[@class='order-footer__input-promo']")
//    private WebElement promocodeInput;
//
//    @FindBy(xpath = "//span[@class='order-footer__value order-footer__value--cart-bonus']")
//    private WebElement finalPriceString;

    @Override
    public BucketPage openPage() {
        driver.get(ITEM_PAGE_URL);
        logger.info("Opened page " + ITEM_PAGE_URL);
        return this;
    }

    public String getFirstProductDataId() {
        return firstAddedProduct.getAttribute("data-id");
    }

    public BucketPage acceptAlert(){
        this.acceptAnyAlert();
        return this; }
}
