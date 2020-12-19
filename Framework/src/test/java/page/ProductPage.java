package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private final int WAIT_TIMEOUT_SECOND = 50;

    private static final String HOMEPAGE_URL = "https://5element.by/products/681507-ultrabuk-asus-zenbook-14-ux431fa-am119";
    private final static String XPATH_FOR_DESCRIPTION_TEXT = "//section[@id='description']";
    private final static String XPATH_FOR_ADD_TO_COMPARE_BUTTON = "//div[@class='btn-product-actions']/div[1]";
    private final static String XPATH_FOR_VALUE_INDICATOR = "//span[@id='compare-count-extra']";
    private final static String XPATH_FOR_LINK_TO_COMPARE_PAGE = "//div[@class='panel-fr-bottom']/a[1]";

    private WebDriver driver;
    private String dataId;
    private boolean isPress = false;
    private int usuakButtonPosition;


//    @FindBy(xpath = XPATH_FOR_DESCRIPTION_TEXT)
//    private WebElement productDescriptionFind;
//
//    @FindBy(xpath = XPATH_FOR_ADD_TO_COMPARE_BUTTON)
//    private WebElement compareButtonFind;
//
//    @FindBy(xpath = XPATH_FOR_VALUE_INDICATOR)
//    private WebElement valueIndicatoOfCompareProduct;
//
//    @FindBy(xpath = XPATH_FOR_LINK_TO_COMPARE_PAGE)
//    private WebElement openComparePageBytton;

    public ProductPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    private void cliclToDescription(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_DESCRIPTION_TEXT)))
                .click();
    }

    private String getUseualButtonPosition(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_DESCRIPTION_TEXT)))
                .getAttribute("background-position");
    }

    public String getDataId(){
        this.cliclToDescription();
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_ADD_TO_COMPARE_BUTTON)))
                .getAttribute("data-id");
    }

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductPage pressCompareButtonForAdd(){
        if(!isPress)
            (new WebDriverWait(driver, 100))
                .until(ExpectedConditions
                        .attributeContains(By.xpath(XPATH_FOR_VALUE_INDICATOR),"class","compare-count-active"));
        this.cliclToDescription();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_ADD_TO_COMPARE_BUTTON)))
                .click();
        isPress = !isPress;
        return this;
    }

//    public ProductPage pressCompareButtonForDelete(){
//        (new WebDriverWait(driver, 100))
//                .until(ExpectedConditions
//                        .attributeContains(By.xpath(XPATH_FOR_VALUE_INDICATOR),"class","compare-count-active"));
//        this.cliclToDescription();
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
//                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_ADD_TO_COMPARE_BUTTON)))
//                .click();
//        return this;
//    }

    public String getIndicatorValueById(){
        boolean r;
        r = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions
                        .not(ExpectedConditions
                                .presenceOfAllElementsLocatedBy(By.xpath("//span[@class='compare-count-active']"))));
        return (new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_VALUE_INDICATOR))).getText());
    }

    public String getIndicatorValueByActiveClass(){
        boolean isAttributeContains = false;
        while(!isAttributeContains){
            isAttributeContains = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.attributeContains(By.xpath(XPATH_FOR_VALUE_INDICATOR),"class","compare-count-active"));
        }
        return (new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_VALUE_INDICATOR))).getText());
    }

    public ComparePage openComparePage(WebDriver driver){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_VALUE_INDICATOR)))
                .click();
        driver.get(new WebDriverWait(driver, 100)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_LINK_TO_COMPARE_PAGE)))
                .getAttribute("href"));
        return new ComparePage(driver);
    }

    public ProductPage returnDriverToTheProductPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }
}
