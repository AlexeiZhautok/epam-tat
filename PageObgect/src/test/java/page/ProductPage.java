package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class ProductPage {
    private final int WAIT_TIMEOUT_SECOND = 50;

    private static final String HOMEPAGE_URL = "https://5element.by/products/691383-igrovoy-noutbuk-asus-tuf-gaming-fx505dv-hn279";
    private final static String XPATH_FOR_DESCRIPTION_TEXT = "//section[@id='description']";
    private final static String XPATH_FOR_ADD_TO_COMPARE_BUTTON = "//div[@class='btn-product-actions']/div[1]";
    private final static String XPATH_FOR_VALUE_INDICATOR = "//span[@id='compare-count-extra']";
//    private final static String XPATH_FOR_COMPARE_PANEL = "//div[@class='compare-header']";
    private final static String XPATH_FOR_LINK_TO_COMPARE_PAGE = "//div[@class='panel-fr-bottom']/a[1]";
//    private final static String XPATH_FOR_HEADLINE = "//h1[@class='cont-hd-alt widget-query-heading']";

    private WebDriver driver;
    private String dataId;

//    @FindBy(xpath = "//input[@id='qf-0q-destination']")
//    private WebElement placeInput;

    @FindBy(xpath = XPATH_FOR_DESCRIPTION_TEXT)
    private WebElement productCharacteristicsFind;

    @FindBy(xpath = XPATH_FOR_ADD_TO_COMPARE_BUTTON)
    private WebElement searchButton;

    @FindBy(xpath = XPATH_FOR_VALUE_INDICATOR)
    private WebElement roomsAdultsSelect;

//    @FindBy(xpath = XPATH_FOR_COMPARE_PANEL)
//    private WebElement addToCompareButton;

    @FindBy(xpath = XPATH_FOR_LINK_TO_COMPARE_PAGE)
    private WebElement longStayLink;
//
//    @FindBy(xpath = XPATH_FOR_HEADLINE)
//    private WebElement headline;

    public String getDataId(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_DESCRIPTION_TEXT)))
                .click();
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_ADD_TO_COMPARE_BUTTON))).getAttribute("data-id");
//        System.out.println(dataid);
    }

    public ProductPage(WebDriver driver){
        this.driver = driver;
            PageFactory.initElements(driver, this);
    }

    public ProductPage openPage() {
        driver.get(HOMEPAGE_URL);

        return this;
    }

    public ProductPage checkInterferingNotifications(){
//        System.out.println(new WebDriverWait(driver,WAIT_TIMEOUT_SECOND).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='backdrop-close'"))));
//        if(!(new WebDriverWait(driver,WAIT_TIMEOUT_SECOND).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='backdrop-close'"))))){
////            Robot robot = new Robot();
////            robot.keyPress(KeyEvent.VK_ESCAPE);
////            robot.keyRelease(KeyEvent.VK_ESCAPE);
//            new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
//                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='backdrop-close'")))
//                    .click();
//        }
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                        .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='backdrop-close']")))
                    .click();
        }
        catch (TimeoutException e){
            System.out.println("11");
        }
        return this;
    }

    public ProductPage pressCompareButtonForAdd(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_DESCRIPTION_TEXT)))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_ADD_TO_COMPARE_BUTTON)))
                .click();
        return this;
    }

    public ProductPage pressCompareButtonForDelete(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_DESCRIPTION_TEXT)))
                .click();
        boolean isAttributeContains = true;
        while(isAttributeContains){
            isAttributeContains = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.attributeContains(By.xpath(XPATH_FOR_VALUE_INDICATOR),"class","compare-count-active"));
        }
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_ADD_TO_COMPARE_BUTTON)))
                .click();
        return this;
    }

    public String getIndicatorValue(){
        boolean isAttributeContains = false;
        while(!isAttributeContains){
            isAttributeContains = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.attributeContains(By.xpath(XPATH_FOR_VALUE_INDICATOR),"class","compare-count-active"));
        }
        return (new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_VALUE_INDICATOR))).getText());
    }

    public ProductPage openComparePage(WebDriver driver){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_VALUE_INDICATOR)))
                .click();
        driver.get(new WebDriverWait(driver, 100)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_LINK_TO_COMPARE_PAGE)))
                .getAttribute("href"));
        return this;
    }

    public String findAddedElementDataId(){
        return (new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-item product-item-shortblock item js-product-item']"))).getAttribute("data-id"));
    }

    public ProductPage returnDriverToTheProductPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }
}
