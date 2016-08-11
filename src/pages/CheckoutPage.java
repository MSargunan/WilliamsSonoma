
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import exceptions.PageNotLoadedException;

/**
 * Class to validate if the item has been saved for later successfully during checkout
 */
public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) throws PageNotLoadedException {
		super(driver);
	}

	private static final By SAVE_FOR_LATER = By.cssSelector("a[class='moveToSFL save-for-later-link']");
	private static final By SAVED_FOR_LATER = By.xpath("//a[text()='1 saved item']");

	public CheckoutPage clickSaveForLater() {
		driver.findElement(SAVE_FOR_LATER).sendKeys(Keys.ENTER);
		return this;

	}

	public boolean validateIfItemSavedForLater() {
		boolean didItSucceed = false;
		try {
			waitForElement(ExpectedConditions.visibilityOfElementLocated(SAVED_FOR_LATER), driver, 40);
			didItSucceed = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return didItSucceed;
	}

	@Override
	public boolean waitForPageLoad() {
		boolean didPageLoad = false;
		try {
			waitForElement(SAVE_FOR_LATER, driver);
			didPageLoad = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return didPageLoad;
	}

}
