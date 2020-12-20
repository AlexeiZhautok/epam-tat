package test;

import org.testng.annotations.*;
import org.testng.Assert;

import page.ProductPage;

import service.TestDataReader;

public class CompareButtonTest extends CommonConditions {

    private static final String PRODUCT_LINK_PROPERTY = TestDataReader.getTestData("testdata.product.link");
    @Test (enabled = true)
    public void valueOfTheCompareIndicatorWhenAdding() throws InterruptedException {
//        System.out.println(System.getProperty("browser"));
        System.out.println(TestDataReader.getTestData("testdata.product.link"));
         String usualIndicatorValue = new ProductPage(driver,PRODUCT_LINK_PROPERTY)
                .openPage()
                 .acceptAlert()
                .getUseualButtonPosition();
         String actualIndicatorValue = new ProductPage(driver,PRODUCT_LINK_PROPERTY)
                .openPage()
                .checkInterferingNotifications()
                .pressCompareButtonForAdd()
                .getUseualButtonPosition();
        Assert.assertNotEquals(usualIndicatorValue, actualIndicatorValue,"Indicator does't work.");
    }


    @Test (enabled = false)
    public void valueOfTheCompareIndicatorWhenDelete() {
        String actualIndicatorValue = new ProductPage(driver,PRODUCT_LINK_PROPERTY)
                .openPage()
                .pressCompareButtonForAdd()
                .pressCompareButtonForAdd()
//                .pressCompareButtonForDelete()
                .getIndicatorValueById();
        Assert.assertEquals(actualIndicatorValue,"0", "Indicator does't work.");
    }

    @Test(enabled = false)
    public void compareButtonWorkingTest() {
//        String usualButtonPosition = new ProductPage(driver)
//                .openPage()
//                .getUseualButtonPosition();
//        System.out.println(usualButtonPosition);
        String actualAddedElementDataId = new ProductPage(driver,PRODUCT_LINK_PROPERTY)
                .openPage()
//                .checkInterferingNotifications()
                .pressCompareButtonForAdd()
                .openComparePage(driver)
                .checkInterferingNotifications()
                .findAddedElementDataId();
        Assert.assertEquals(actualAddedElementDataId, new ProductPage(driver,PRODUCT_LINK_PROPERTY).returnDriverToTheProductPage().getDataId(),"there isn't compare object.");
    }
}
//assertNotEquals