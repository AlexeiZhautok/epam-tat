package test;

import org.testng.annotations.*;
import org.testng.Assert;

import page.ProductPage;

public class CompareButtonTest extends CommonConditions {

    private String pageDataId = "0";
    private static final String PRODUCT_LINK_PROPERTY = "https://5element.by/products/681507-ultrabuk-asus-zenbook-14-ux431fa-am119";

    @Test (enabled = true)
    public void valueOfTheCompareIndicatorWhenAdding() throws InterruptedException {
        System.out.println(System.getProperty("browser"));
         String usualIndicatorValue = new ProductPage(driver,PRODUCT_LINK_PROPERTY)
                .openPage()
//                .pressCompareButtonForAdd()
                .getUseualButtonPosition();
//                .getIndicatorValueByActiveClass();
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
        Assert.assertEquals(actualAddedElementDataId, new ProductPage(driver,PRODUCT_LINK_PROPERTY).returnDriverToTheProductPage().getDataId(),"there isn't compare object."+pageDataId);
    }
}
//assertNotEquals