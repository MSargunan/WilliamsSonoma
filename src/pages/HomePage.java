
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import exceptions.PageNotLoadedException;

/**
 * Class to perform actions required in home page of Williams Sonoma site.
 */
public class HomePage extends BasePage {

	public HomePage(WebDriver driver) throws PageNotLoadedException {
		super(driver);
	}

	private static final By COOKWARE = By.cssSelector("a[class='topnav-cookware ']");

	public HomePage clickCookwareMenu() {
		driver.findElement(COOKWARE).sendKeys(Keys.ENTER);
		return this;

	}

	public HomePage clickCategory(String category) {
		By locator = By.xpath("//a[text()='" + category + "']");
		waitForElement(locator, driver);
		driver.findElement(locator).sendKeys(Keys.ENTER);
		return this;

	}

	public HomePage clickProduct(String name) {
		By locator = By.xpath("//a[contains(text(),'" + name + "')]");
		waitForElement(locator, driver);
		driver.findElement(locator).sendKeys(Keys.ENTER);
		return this;

	}

	public void handleEmailSignUpPopUp() {
		try {
			waitForElement(By.linkText("close"), driver, 20);
			driver.findElement(By.linkText("close")).click();
		} catch (Exception ex) {
			// do nothing as this is optional pop up
		}
	}

	@Override
	public boolean waitForPageLoad() {
		boolean didPageLoad = false;
		try {
			handleEmailSignUpPopUp();
			waitForElement(COOKWARE, driver);
			didPageLoad = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return didPageLoad;
	}

}
