package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * @Author: Sahil Mutreja
 * @Desc: WebDriverFactory provides init method to initialize WebDriver for different os and browser combination
 */
public class WebDriverFactory {

    public static WebDriver init(String browser, String os) {
        return Browser.valueOf(browser.toUpperCase()).getDriver(os);
    }

    enum Browser {
        CHROME {
            public WebDriver getDriver(String os) {
                System.setProperty("webdriver.chrome.driver", String.format("src//test//resources//drivers//%s//chromedriver.exe", os));
                return new ChromeDriver();
            }
        },
        FIREFOX {
            public WebDriver getDriver(String os) {
                System.setProperty("webdriver.gecko.driver",String.format("src//test//resources//drivers//%s//geckodriver.exe", os));
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("marionette", true);
                return new FirefoxDriver(firefoxOptions);
            }
        };
        public abstract WebDriver getDriver(String os);
    }


}
