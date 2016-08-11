
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains properties required for all pages
 */
import exceptions.PageNotLoadedException;

public abstract class BasePage {

	protected final WebDriver driver;

	public static final int DEFAULT_TIMEOUT = 40;

	public BasePage(WebDriver driver) throws PageNotLoadedException {
		this.driver = driver;
		if (!waitForPageLoad()) {
			throw new PageNotLoadedException("Page at url " + driver.getCurrentUrl() + " did not load");
		}
	}

	public void waitForElement(final By locator, WebDriver driver, int timeOut) {
		waitForElement(ExpectedConditions.presenceOfElementLocated(locator), driver, timeOut);
	}

	public void waitForElement(final By locator, WebDriver driver) {
		waitForElement(locator, driver, DEFAULT_TIMEOUT);
	}

	public void waitForElement(final ExpectedCondition<WebElement> expectedConditionAndLocator, WebDriver driver,
			int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(expectedConditionAndLocator);
	}

	public abstract boolean waitForPageLoad();
}
