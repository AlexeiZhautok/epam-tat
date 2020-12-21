package test;

import org.testng.annotations.*;
import org.testng.Assert;

import page.ProductPage;

import service.TestDataReader;

public class CompareButtonTest extends CommonConditions {

    private static final String PRODUCT_LINK_PROPERTY = TestDataReader.getTestData("testdata.product.link");

    @Test(enabled = true)
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