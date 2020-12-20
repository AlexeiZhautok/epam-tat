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

        (new ProductPage(driver, TestDataReader.getTestData(PRODUCT_LINK_PROPERTY)))
                .openPage()
                .addItemToBucket();
        String actual = new ProductPage(driver, TestDataReader.getTestData(PRODUCT_LINK_PROPERTY)).getDataId();
        String expected =  new BucketPage(driver).openPage().getFirstProductDataId();
        Assert.assertEquals(expected, actual);
    }
}
