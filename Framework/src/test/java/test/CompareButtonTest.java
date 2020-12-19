package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.*;
import org.testng.Assert;

import page.ProductPage;

public class CompareButtonTest extends CommonConditions {

    private String pageDataId = "0";

    @Test (enabled = true)
    public void valueOfTheCompareIndicatorWhenAdding() throws InterruptedException {
        Thread.sleep(2000);
         String actualIndicatorValue = new ProductPage(driver)
                .openPage()
                .pressCompareButtonForAdd()
                .getIndicatorValueByActiveClass();
        Assert.assertEquals(actualIndicatorValue, "1","Indicator does't work.");
    }

    @Test (enabled = true)
    public void valueOfTheCompareIndicatorWhenDelete() {
        String actualIndicatorValue = new ProductPage(driver)
                .openPage()
                .pressCompareButtonForAdd()
                .pressCompareButtonForAdd()
//                .pressCompareButtonForDelete()
                .getIndicatorValueById();
        Assert.assertEquals(actualIndicatorValue,"0", "Indicator does't work.");
    }

    @Test(enabled = true)
    public void compareButtonWorkingTest() {
        String actualAddedElementDataId = new ProductPage(driver)
                .openPage()
                .pressCompareButtonForAdd()
                .openComparePage(driver)
                .checkInterferingNotifications()
                .findAddedElementDataId();
        Assert.assertEquals(actualAddedElementDataId, new ProductPage(driver).returnDriverToTheProductPage().getDataId(),"there isn't compare object."+pageDataId);
    }
}
//assertNotEquals