package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage extends AbstractPage {

    private final String BASE_URL = "https://5element.by/login?back_url=/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@id='login-tab-bpm-email']")
    private WebElement loginByEmailButton;

    @FindBy(xpath = "//input[@name='EMAIL']")
    private WebElement emailInput;

    @FindBy (xpath = "//input[@name='PASSWORD']")
    private WebElement passwordInput;

    @FindBy (xpath = "//input[@id='checkbox-1']/../div/label")
    private WebElement rememberMeCheckbox;

    @FindBy (xpath = "//a[@class='button js-submit']")
    private WebElement logInSubmitButton;

    @FindBy (xpath = "//div[@class='line-wrapper']/div/div/p")
    private WebElement scrollDown;

    public AuthorizationPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

//    public MainPage logIn(User user) {
//        loginByEmailButton.click();
//        emailInput.sendKeys(user.getEmail());
//        passwordInput.sendKeys(user.getPassword());
//        rememberMeCheckbox.click();
//        scrollDown.click();
//        logInSubmitButton.click();
//        return new MainPage(driver); }

//CI
    public MainPage logIn(User user) {
        loginByEmailButton.click();
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        WebElement scroll = driver.findElement(By.xpath("//*[@id=\"comp_9ad7236b48b7cdf3fd2aba112da9bbbb\"]/div/p"));
        Actions actions = new Actions(driver);
        actions.moveToElement(scroll);
        actions.perform();
        rememberMeCheckbox.click();
//        scrollDown.click();
        logInSubmitButton.click();
        return new MainPage(driver); }

    public AuthorizationPage acceptAlert(){
        this.acceptAnyAlert();
        return this; }
}
