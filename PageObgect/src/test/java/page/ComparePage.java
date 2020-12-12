package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ComparePage {

    private WebDriver driver;

    public ComparePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
