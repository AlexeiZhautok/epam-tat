package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import page.ProductPage;

public class CompareButtonTest {

    private WebDriver driver;
    private String pageDataId = "0";

    @BeforeTest(alwaysRun = true)
    public void browserSetup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (enabled = true)
    public void valueOfTheCompareIndicatorWhenAdding() {
         String actualIndicatorValue = new ProductPage(driver)
                .openPage()
                .pressCompareButtonForAdd()
                .getIndicatorValue();
        Assert.assertEquals("1", actualIndicatorValue,"Indicator does't work.");
    }

//    @Test (enabled = true)
//    public void valueOfTheCompareIndicatorWhenDelete() {
//        String actualIndicatorValue = new ProductPage(driver)
//                .openPage()
//                .checkInterferingNotifications()
//                .pressCompareButtonForAdd()
//                .pressCompareButtonForDelete()
//                .getIndicatorValue();
//        Assert.assertEquals("0", actualIndicatorValue, "Indicator does't work.");
//    }

    @Test(enabled = true)
    public void compareButtonWorkingTest() throws AWTException {
//        pageDataId = new ProductPage(driver).getDataId();
        String actualAddedElementDataId = new ProductPage(driver)
                .openPage()
                .getDataId(pageDataId)
                .pressCompareButtonForAdd()
                .openComparePage(driver)
                .checkInterferingNotifications()
                .findAddedElementDataId();

        Assert.assertEquals(pageDataId, actualAddedElementDataId,"there isn't compare object.");
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
