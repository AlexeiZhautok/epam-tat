package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.testng.Assert;

import page.ProductPage;

public class CompareButtonTest {

    private WebDriver driver;
    private String pageDataId = "0";

    @BeforeMethod(alwaysRun = true)
    public void browserSetupReload(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void browserClose() {
        driver.close();
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test (enabled = true, priority = 2)
    public void valueOfTheCompareIndicatorWhenAdding() throws InterruptedException {
        Thread.sleep(2000);
         String actualIndicatorValue = new ProductPage(driver)
                .openPage()
                .pressCompareButtonForAdd()
                .getIndicatorValue();
        Assert.assertEquals(actualIndicatorValue, "1","Indicator does't work.");
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

    @Test(enabled = true, priority = 1)
    public void compareButtonWorkingTest() throws AWTException {
//        pageDataId = new ProductPage(driver).getDataId();
        String actualAddedElementDataId = new ProductPage(driver)
                .openPage()
                .pressCompareButtonForAdd()
                .openComparePage(driver)
                .checkInterferingNotifications()
                .findAddedElementDataId();
        Assert.assertEquals(actualAddedElementDataId, new ProductPage(driver).returnDriverToTheProductPage().getDataId(),"there isn't compare object."+pageDataId);
    }
}
