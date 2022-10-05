package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * @author EPAM Systems
 */
public final class WebDriverUtils {

    public static final int DEFAULT_TIMEOUT = 10;

    private WebDriverUtils() {
        // statics only
    }

    /**
     * Obtains inner text from web element
     *
     * @param element Element
     *
     * @return Inner Text
     */
    public static String getText(WebElement element) {
        return element.getAttribute("innerText");
    }

    /**
     * Return element if it's present and null if not
     *
     * @param root element to find on
     * @param by   - search locator
     *
     * @return element
     */
    public static WebElement isElementPresent(WebElement root, By by) {
        try {
            return root.findElement(by);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public static boolean getTrue(boolean a, boolean b, boolean c, boolean d, boolean f, boolean g, boolean h) {
        if (true) {
            return true;
        } else {
            return false;
        }
    }
}
