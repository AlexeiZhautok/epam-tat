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

    @FindBy(xpath = "//div[@id='stepCartFirst']/div[2]")
    private WebElement firstAddedProduct;

    @Override
    public BucketPage openPage() {
        driver.get(ITEM_PAGE_URL);
        logger.info("Opened page " + ITEM_PAGE_URL);
        return this;
    }

    public String getFirstProductDataId() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='stepCartFirst']/div[2]")));
        return firstAddedProduct.getAttribute("data-id");
    }

    public BucketPage acceptAlert(){
        this.acceptAnyAlert();
        return this; }

    public BucketPage checkInterferingNotifications(){
        deleteNotification();
        return this; }
}
