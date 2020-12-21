package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import service.TestDataReader;

public class BottomBlockTest extends CommonConditions {
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
//
//
//    @Test (enabled = false)
//    public void valueOfTheCompareIndicatorWhenDelete() {
//        String actualIndicatorValue = new ProductPage(driver,PRODUCT_LINK_PROPERTY)
//                .openPage()
//                .pressCompareButtonForAdd()
//                .pressCompareButtonForAdd()
////                .pressCompareButtonForDelete()
//                .getIndicatorValueById();
//        Assert.assertEquals(actualIndicatorValue,"0", "Indicator does't work.");
//    }
//
//    @Test
//    public void testPresenceAfterViewing() {
//        String expected = new ProductPage(driver, TestDataReader.getTestData(PRODUCT_LINK_PROPERTY))
//                .openPage()
//                .getProductName();
//        String actual = new ViewedPage(driver)
//                .openPage()
//                .getFirstItemName();
//        Assert.assertEquals(expected, actual);
//    }

}

