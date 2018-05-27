package base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.security.DigestException;

public class WebDriverFactory {

    public static WebDriver init(WebDriver driver, String browser, String os) {
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
