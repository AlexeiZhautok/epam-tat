package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AbstractPage {
    private final String BASE_URL = "https://5element.by/cabinet";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy (xpath = "//div[@class='panel-personal-email']")
    private WebElement userEmailField;

    public ProfilePage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public ProfilePage openPage()
    {
        driver.get(BASE_URL);
        logger.info("Opened page " + BASE_URL);
        return this;
    }


    public String getUserEmailFieldText() {
        return userEmailField.getText();
    }

    public ProfilePage checkInterferingNotifications(){
        deleteNotification();
        return this;
    }
}
