package utility;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtility {

    /**
     * @param webElement is the element which will be scrolled into view and clicked
     */
    public static void scrollIntoViewClick(WebElement element,WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * @param weElement
     *            is the element which will be scrolled into view and clicked
     */
    public static void scrollToClickWebElement(WebElement weElement,WebDriver driver) {
        // Scroll the browser to the element's Y position
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0," + weElement.getLocation().x + ")");
        weElement.click();
    }

}
