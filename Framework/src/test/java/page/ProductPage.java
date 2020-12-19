package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends AbstractPage {
    private final int WAIT_TIMEOUT_SECOND = 50;

    private final static String XPATH_FOR_DESCRIPTION_TEXT = "//section[@id='description']";
    private final static String XPATH_FOR_ADD_TO_COMPARE_BUTTON = "//div[@class='btn-product-actions']/div[1]";
    private final static String XPATH_FOR_VALUE_INDICATOR = "//span[@id='compare-count-extra']";
    private final static String XPATH_FOR_LINK_TO_COMPARE_PAGE = "//div[@class='panel-fr-bottom']/a[1]";
    
    private boolean isPress = false;
    private String itemPageURL;

    public ProductPage(WebDriver driver, String url) {
        super(driver);
        itemPageURL = url;
    }

    @FindBy(xpath = XPATH_FOR_DESCRIPTION_TEXT)
    private WebElement productDescriptionFind;

    @FindBy(xpath = XPATH_FOR_ADD_TO_COMPARE_BUTTON)
    private WebElement compareButtonFind;

    @FindBy(xpath = XPATH_FOR_VALUE_INDICATOR)
    private WebElement valueIndicatoOfCompareProduct;
    @FindBy(xpath = XPATH_FOR_LINK_TO_COMPARE_PAGE)
    private WebElement openComparePageBytton;

    @Override
    public ProductPage openPage() {
        int t=0;
        driver.get(itemPageURL);
        return this;
    }

    private void cliclToDescription(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_DESCRIPTION_TEXT)))
                .click();
    }

    public String getUseualButtonPosition(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_action-pic to-compare']")))
                .getCssValue("background-position");
    }

    public String getDataId(){
        this.cliclToDescription();
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_ADD_TO_COMPARE_BUTTON)))
                .getAttribute("data-id");
    }

    public ProductPage pressCompareButtonForAdd(){
        if(isPress) {
            (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions
                            .attributeContains(By.xpath(XPATH_FOR_VALUE_INDICATOR), "class", "compare-count-active"));
        }
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
//        this.cliclToDescription();
        return (new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_VALUE_INDICATOR))).getText());
    }

    public String getIndicatorValueByActiveClass(){
        boolean isAttributeContains = false;
        while(!isAttributeContains){
            isAttributeContains = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.attributeContains(By.xpath(XPATH_FOR_VALUE_INDICATOR),"class","compare-count-active"));
        }
//        this.cliclToDescription();
        return (new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_VALUE_INDICATOR))).getText());
    }

    public ComparePage openComparePage(WebDriver driver){
//        this.cliclToDescription();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_VALUE_INDICATOR)))
                .click();
        driver.get(new WebDriverWait(driver, 100)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_LINK_TO_COMPARE_PAGE)))
                .getAttribute("href"));
        return new ComparePage(driver);
    }

    public ProductPage returnDriverToTheProductPage(){
        driver.get(itemPageURL);
        return this;
    }

    public ProductPage checkInterferingNotifications(){
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='backdrop-close']")))
                    .click();
        }
        catch (TimeoutException e){
            System.out.println("На этой странице не было предупреждения");
        }
        return this;
    }
}
