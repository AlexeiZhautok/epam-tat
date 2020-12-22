package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import service.TestDataReader;

public class BottomBlockTest extends CommonConditions {

    private static final String PRODUCT_LINK_PROPERTY = TestDataReader.getTestData("testdata.product.link");

    @Test(enabled = true)
    public void valueOfTheCompareIndicatorWhenAddTest() {
        String actualIndicatorValue = new ProductPage(driver, PRODUCT_LINK_PROPERTY)
                .openPage()
                .acceptAlert()
                .pressCompareButtonForAdd()
                .getCompareIndicatorValueById();
        Assert.assertEquals(actualIndicatorValue,"1", "Indicator does't work."); }

    @Test (enabled = true)
    public void valueOfViewIndicatorTest(){
        String actualIndicatorValue = new ProductPage(driver,PRODUCT_LINK_PROPERTY)
                .openPage()
                .acceptAlert()
                .getViewIndicatorValueById();
        Assert.assertEquals(actualIndicatorValue, "1","Indicator does't work."); } }


