package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
    private final String BASE_URL = "https://5element.by/";
    private final Logger logger = LogManager.getRootLogger();

    private By usernameFieldLocator = By.xpath("//li[@class='top-bar-right-log ']");

    @FindBy (xpath = "//li[@class='top-bar-right-log _in']")
    private WebElement logInButton;

    @FindBy (xpath = "//li[@class='top-bar-right-log ']/a/span")
    private WebElement greetingText;

    public MainPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public MainPage openPage()
    {
        driver.get(BASE_URL);
        logger.info("Opened page " + BASE_URL);
        return this;
    }

//    public SearchPage searchForQuery(String query) {
//        searchBarInput.sendKeys(query);
//        searchBarButton.click();
//        logger.info("Searching for " + query);
//        return new SearchPage(driver);
//    }

    public AuthorizationPage openLogInDialog() {
        logInButton.click();
        return new AuthorizationPage(driver);
    }

//    public String getUserGreeting(){
//        return greetingText.getText();
//
//    }

    public MainPage acceptAlert(){
        this.acceptAnyAlert();
        return this;
    }
}
