package utility;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @Author: Sahil Mutreja
 * Desc: JSUtility class provides functionality where JS is used to perform UI interaction
 */
public class JSUtility {

    /**
     * Function to scroll and click the element via JS.
     * @param element is the element which will be scrolled into view and clicked
     * @param driver
     */
    public static void scrollIntoViewClick(WebElement element,WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }


}
