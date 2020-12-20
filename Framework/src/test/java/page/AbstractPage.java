package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage
{
    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    interface Page{

        void print();
    }

    public void acceptAnyAlert(){
        try{
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (NoAlertPresentException e){
            System.out.println("Алёрта не было в этот раз");
        }
    }

    public void deleteNotification(){
        try {
            new WebDriverWait(driver, 20)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='backdrop-close']")))
                    .click();
        }
        catch (TimeoutException e){
            System.out.println("На этой странице не было предупреждения");
        }
    }
}
