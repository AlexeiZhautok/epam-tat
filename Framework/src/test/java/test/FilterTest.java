package test;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CatalogPage;
import service.TestDataReader;

public class FilterTest extends CommonConditions {
    private static final String CATALOG_LINK_PROPERTY = "testdata.catalog.link";
    private static final String PARAMETR_PROPERTY = "testdata.catalog.parameter";

    @Test
    public void presenceAfterApplyingFilterTest() {
        String expected = TestDataReader.getTestData(PARAMETR_PROPERTY);
        String actual = new CatalogPage(driver, TestDataReader.getTestData(CATALOG_LINK_PROPERTY))
                .openPage()
                .acceptAlert()
                .setParametr(expected)
                .openParameterizedCatalogPage(TestDataReader.getTestData(CATALOG_LINK_PROPERTY))
                .getFirstItemName();
        LogManager.getRootLogger().info("Checking that '" + actual + "' contatins '" + expected + "'");
        Assert.assertTrue(actual.toLowerCase().contains(expected.toLowerCase()));
    }
}
