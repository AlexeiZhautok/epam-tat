import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class CompareButtonTest {

    private WebDriver driver;

    @Before
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

    @After
    public void closeBrowser() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void compareIndicatorTextChangingTest() {
        WebElement compareCountIndicate = driver.findElement(By.xpath("//div[@id='bottomBlock']//span[@id='compare-count-extra']"));
        boolean isAttributeContains = false;
        while(!isAttributeContains){
            isAttributeContains = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.attributeContains(By.xpath("//span[@id='compare-count-extra']"),"class","compare-count-active"));
        }
        String expected = "1";
        String actual = compareCountIndicate.findElement(By.xpath("//span[@id='compare-count-extra']")).getText();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareButtonWorkingTest(){
        WebElement compareCountIndicate = driver.findElement(By.xpath("//div[@id='bottomBlock']//span[@id='compare-count-extra']"));
        boolean isAttributeContains = false;
        while(!isAttributeContains){
            isAttributeContains = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.attributeContains(By.xpath("//span[@id='compare-count-extra']"),"class","compare-count-active"));
        }

        driver.findElement(By.xpath("//div[@class='compare-header']")).click();
        (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='panel-fr-bottom']/a[1]")));
//                .click();

        driver.navigate().to("https://5element.by/compare");
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);

        String expected = "Игровой ноутбук ASUS TUF Gaming FX505DV-HN279";
        String actualTextButton = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-item-head-title']/a[1]")))
                .getText();

        Assert.assertEquals(expected, actualTextButton);
    }

}
