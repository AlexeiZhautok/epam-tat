package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage extends AbstractPage  {

    private String itemPageURL;
    private final Logger logger = LogManager.getRootLogger();

    private By applyFilterButton = By.xpath("//div[@class='result']//button");

    @FindBy(xpath = "//li[@data-id='BRAND']//li[@class='sidebar-filter-read-more']")
    private WebElement shoewMoreBrends;

    @FindBy(xpath = "//div[@class='spec-product-middle']//a")
    private WebElement firstItemName;

    @FindBy(xpath = "//div[@class='sidebar-filter-title-text']")
    private WebElement openFilter;

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

//    public CatalogPage setParametr (String parametr) {
//        WebElement buf = driver.findElement(By.xpath("//*[@id=\"categoryProductList\"]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(buf);
//        actions.perform();
//        shoewMoreBrends.click();
//        WebElement checkbox = driver
//                .findElement(By.xpath("//li[@data-id='BRAND']//label[text()[contains(.,'" + parametr + "')]]"));
//        checkbox.click();
//        return this; }

//for CI
    public CatalogPage setParametr (String parametr) {
        openFilter.click();
        WebElement buf = driver.findElement(By.xpath("//*[@id=\"smartFilter\"]/ul/li/div[3]/ul/li[5]/div[1]/div[1]/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(buf);
        actions.perform();
        shoewMoreBrends.click();
        WebElement checkbox = driver
                .findElement(By.xpath("//li[@data-id='BRAND']//label[text()[contains(.,'" + parametr + "')]]"));
        checkbox.click();
        return this; }

    public CatalogPage openParameterizedCatalogPage(String url){
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(applyFilterButton)).click();
        driver.get(url + "/brand=zte");
        return this; }

    public String getFirstItemName() {
        return firstItemName.getText(); }

    public CatalogPage acceptAlert(){
        this.acceptAnyAlert();
        return this; }

}
