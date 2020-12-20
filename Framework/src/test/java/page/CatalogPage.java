package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage extends AbstractPage  {

    private String itemPageURL;
    private final Logger logger = LogManager.getRootLogger();

//    private By applyFilterButtonLocator = By.xpath("//form[@class='catalog-filter']/div[@class='catalog-sbf-top catalog-sbf-btnset']/button[@class='btn btn-orange' and @type='submit']");

//    @FindBy(xpath = "//button[@class='btn btn-orange' and @type='submit']")
//    private WebElement applyFilterButton;

    @FindBy(xpath = "//div[@class='tiles-product-item-large pad-top-30']/div[1]//h2[@class='spec-product-middle-title']")
    private WebElement firstItemName;

    public CatalogPage(WebDriver driver, String url) {
        super(driver);
        itemPageURL = url;
    }

    @Override
    public CatalogPage openPage() {
        driver.get(itemPageURL);
        logger.info("Opened page " + itemPageURL);
        return this;
    }

    public String getFirstItemName() {
        return firstItemName.getText();
    }

//    public CatalogPage applyManufacturerFilter(String manufacturer) {
//        WebElement checkbox = driver.findElement(By.xpath("//span[@class='catalog-filter__checkbox-text' and contains(text(), '" + manufacturer + "')]"));
//        checkbox.click();
//        logger.info("Applied filter of manufacturer " + manufacturer);
//        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.presenceOfElementLocated(applyFilterButtonLocator));
//        applyFilterButton.click();
//        return this;
//    }

}
