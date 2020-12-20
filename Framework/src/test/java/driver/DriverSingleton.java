package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class DriverSingleton {

    private static Properties prop;
//    private Properties prop; // Global field
//    private WebDriver driver;

    private static WebDriver driver;


    private DriverSingleton(){}

    public static WebDriver getDriver() {
        if (null == driver){
            String browserName = System.getProperty("browser");
            if(browserName == null) browserName = "chrom";
            switch (browserName){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver closeDriver(){
        driver.quit();
        driver = null;
        return driver;
    }
}
