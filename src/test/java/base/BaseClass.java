package base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;
    String browser, os;
    protected String existingUserEmail = "hf_challenge_123456@hf12345.com";
    protected String existingUserPassword = "12345678";

    public static final Logger log = Logger.getLogger(BaseClass.class.getName());

    @BeforeClass
    @Parameters({"browser", "os"})
    public void setUp(@Optional("chrome") String browser, @Optional("windows") String os) {
        // Getting all the environment variables and setting default values
        log("Getting all the environment variables.");
        String url = System.getProperty("url", "http://automationpractice.com/index.php");

        log("Initializing webdriver.");
        this.browser = browser;
        this.os = os;
        driver = WebDriverFactory.init(driver, browser, os);
        driver.manage().window().maximize();

        log("Navigating to Home page.");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10, 50);

        // Initializing log4j
        log("Initializing log4j.");
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }

    @AfterClass(alwaysRun = true)
    public void endTest() {
        closeBrowser();
    }

    private void closeBrowser() {
        driver.quit();
        log("Browser Closed");
    }

    /**
     * Method to be used for getting the status of the test execution
     */
    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenShot(result.getMethod().getMethodName());
        }
    }

    /**
     * Method used for getting the screen capture with the name in a particular format
     *
     * @param name
     * @param method
     * @param methodName
     */
    public void takeScreenShot(String methodName) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
                    + "/src/test/resources/failure_screencaptures/";
            File destFile = new File(String.format("%sFailure_ScreenCaptures_%s_%s_%s_%s.png", reportDirectory, os, browser, methodName, formater.format(calendar.getTime())));
            FileHandler.copy(srcFile, destFile);
            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
                    + "' height='100' width='100'/> </a");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Logging method so that the same log is added in logger as well as in TestNG Report
     *
     * @param data
     */
    public void log(String data) {
        log.info(data);
        Reporter.log(data + "\n");
    }

    /**
     * Common method to wait for visibility of elements on in test clases
     *
     * @param element
     * @return
     */
    public WebElement waitForVisibilityOf(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Function to parse test data from the json file
     */
    public JSONObject getTestData() {
        JSONObject testData = null;
        String testDataFilePath = "src\\test\\resources\\test-data\\ProductToBeCheckedout.json";
        try {
            InputStream is = new FileInputStream(new File(testDataFilePath));
            JSONTokener jsonTokener = new JSONTokener(is);
            testData = new JSONObject(jsonTokener);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData;
    }

}
