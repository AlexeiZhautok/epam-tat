package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends AbstractPage {
    private final int WAIT_TIMEOUT_SECOND = 50;

    private final static String XPATH_FOR_ADD_TO_COMPARE_BUTTON = "//div[@class='btn-product-actions']/div[1]";
    private final static String XPATH_FOR_LINK_TO_COMPARE_PAGE = "//div[@class='panel-fr-bottom']/a[1]";

    private By findValueCompareIndicator = By.xpath("//span[@id='compare-count-extra']");
    private By findValueViewIndicator = By.xpath("//span[@id='viewed-count']");

    private boolean isPress = false;
    private String itemPageURL;

    public ProductPage(WebDriver driver, String url) {
        super(driver);
        itemPageURL = url; }

    @FindBy(xpath = "//section[@id='description']")
    private WebElement productDescriptionFind;

    @FindBy(xpath = "//button[starts-with(@class, \"spec-product-right-button\")]")
    private WebElement addToBucket;


    @Override
    public ProductPage openPage() {
        driver.get("https://5element.by/products/681507-ultrabuk-asus-zenbook-14-ux431fa-am119");
        return this; }

    private void cliclToDescription(){
        productDescriptionFind.click();
    }


    public String getUseualButtonPosition(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_action-pic to-compare']")))
                .getCssValue("background-position"); }


    public String getDataId(){
        this.cliclToDescription();
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_ADD_TO_COMPARE_BUTTON)))
                .getAttribute("data-id"); }


    public ProductPage pressCompareButtonForAdd(){
        if(isPress) {
            (new WebDriverWait(driver, WAIT_TIMEOUT_SECOND))
                    .until(ExpectedConditions
                            .attributeContains(findValueCompareIndicator, "class", "compare-count-active")); }
        this.cliclToDescription();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_ADD_TO_COMPARE_BUTTON)))
                .click();
        isPress = !isPress;
        return this; }


    public String getCompareIndicatorValueById(){
        cliclToDescription();
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECOND))
                .until(ExpectedConditions
                        .attributeContains(findValueCompareIndicator, "class", "compare-count-active"));
        return (new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(findValueCompareIndicator)).getText()); }


    public String getViewIndicatorValueById(){
        cliclToDescription();
        return (new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(findValueViewIndicator)).getText()); }


    public ComparePage openComparePage(WebDriver driver){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(findValueCompareIndicator))
                .click();
        driver.get(new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_LINK_TO_COMPARE_PAGE)))
                .getAttribute("href"));
        return new ComparePage(driver); }


    public ProductPage returnDriverToTheProductPage(){
        driver.get(itemPageURL);
        return this; }


    public ProductPage checkInterferingNotifications(){
        deleteNotification();
        return this; }


    public ProductPage acceptAlert(){
        this.acceptAnyAlert();
        return this; }


    public ProductPage addItemToBucket(){
        addToBucket.click();
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='cart-large-remove button small secondary js-remove-from-cart']")));
        return this; }
}
