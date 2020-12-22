package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComparePage extends AbstractPage{
    private final int WAIT_TIMEOUT_SECOND = 20;

    private WebDriver driver;

    public ComparePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public ComparePage checkInterferingNotifications(){
        this.deleteNotification();
        return this; }

    public String findAddedElementDataId(){
        return (new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-item product-item-shortblock item js-product-item']"))).getAttribute("data-id")); }

    public ComparePage acceptAlert(){
        this.acceptAnyAlert();
        return this; }
}
