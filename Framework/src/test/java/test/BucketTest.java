package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.BucketPage;
import page.ProductPage;
import service.TestDataReader;

public class BucketTest extends CommonConditions {

    private static final String PRODUCT_LINK_PROPERTY = "testdata.product.link";

    @Test
    public void findInBucketAfterAddingTest() {
        String actual = new ProductPage(driver, TestDataReader.getTestData(PRODUCT_LINK_PROPERTY))
                .openPage()
                .acceptAlert()
                .getDataId();
        (new ProductPage(driver, TestDataReader.getTestData(PRODUCT_LINK_PROPERTY)))
                .openPage()
                .acceptAlert()
                .addItemToBucket();
        String expected =  new BucketPage(driver)
                .openPage()
                .checkInterferingNotifications()
                .getFirstProductDataId();
        Assert.assertEquals(expected, actual); } }
