package test;


import driver.DriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import util.TestListener;

import java.io.IOException;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
//        driver = DriverSingleton.getDriver();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void stopBrowser() {
//        DriverSingleton.closeDriver();
        driver.quit();
    }
}
