package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import page.ProductPage;

public class CompareButtonTestOld {

    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setUpDriverAndClickCompareButton() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
        driver.get("https://5element.by/products/691383-igrovoy-noutbuk-asus-tuf-gaming-fx505dv-hn279");
        WebElement webElement = driver.findElement(By.xpath("//section[@id='characteristics']"));
        webElement.click();
        WebElement addToCompareButton = driver.findElement(By.xpath("//div[@class='btn-product-actions']/div[1]"));
        addToCompareButton.click();
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() throws InterruptedException {
        driver.quit();
        driver = null;
    }

    @Test (enabled = true,priority = 1)
    public void compareIndicatorTextChangingTest() {
//        String addr = new ProductPage(driver)
//                .openPage();
        WebElement compareCountIndicate ;
        boolean isAttributeContains = false;
        while(!isAttributeContains){
            isAttributeContains = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.attributeContains(By.xpath("//span[@id='compare-count-extra']"),"class","compare-count-active"));
        }
        String expected = "1";
        String actual = driver.findElement(By.xpath("//span[@id='compare-count-extra']")).getText();
        Assert.assertEquals(expected, actual, "Indicator does't work.");
    }

    @Test(enabled = true,priority = 2)
    public void compareButtonWorkingTest(){
        boolean isAttributeContains = false;
        while(!isAttributeContains){
            isAttributeContains = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.attributeContains(By.xpath("//span[@id='compare-count-extra']"),"class","compare-count-active"));
        }

        driver.findElement(By.xpath("//div[@class='compare-header']")).click();
        String actual = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='panel-fr-bottom']/a[1]")))
                .getAttribute("href");

//        driver.navigate().to("https://5element.by/compare");
        driver.get("https://5element.by/compare");

        String expected = "Игровой ноутбук ASUS TUF Gaming FX505DV-HN279";
        String actualTextButton = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-item-head-title']/a[1]")))
                .getText();

        Assert.assertEquals(expected, actualTextButton);
    }

}
