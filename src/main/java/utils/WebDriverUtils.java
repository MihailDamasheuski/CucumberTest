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
	 * @return Inner Text
	 */
	public static String getText(WebElement element) {
		return element.getAttribute("innerText");
	}

	/**
	 * Return element if it's present and null if not
	 *
	 *
	 * @param root element to find on
	 * @param by   - search locator
	 * @return element
	 */

	// TODO: 5.10.22 CHeck this method. It should return boolean
	public static WebElement isElementPresent(WebElement root, By by) {
		try {
			return root.findElement(by);
		} catch (NoSuchElementException e) {
			//update this method to throw an error but not to return null
			return null;
		}
	}

	public static void dosmth(String a, String b) {
		String result ;
		// TODO: 10.10.22
		if(a.length() > b.length()) {
			result = a + b;
		}
	}

	public static void main(String[] args) {
		dosmth("asdasd", "ddddd");
	}

	//Not very useful method
	public boolean isValid(WebElement root, By by, String a, String b, String c, String d, String w, String s) {
		return true;
	}
}
