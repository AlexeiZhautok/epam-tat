package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComparePage {
    private final int WAIT_TIMEOUT_SECOND = 50;

    private WebDriver driver;

    public ComparePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public ComparePage checkInterferingNotifications(){
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='backdrop-close']")))
                    .click();
        }
        catch (TimeoutException e){
            System.out.println("На этой странице не было предупреждения");
        }
        return this;
    }

    public String findAddedElementDataId(){
        return (new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-item product-item-shortblock item js-product-item']"))).getAttribute("data-id"));
    }
}
