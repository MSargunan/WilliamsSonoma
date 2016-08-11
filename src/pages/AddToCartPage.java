
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import exceptions.PageNotLoadedException;

/**
 * Class to add items to shopping cart
 */
public class AddToCartPage extends BasePage {

	public AddToCartPage(WebDriver driver) throws PageNotLoadedException {
		super(driver);
	}

	private static final By ADD_TO_CART = By.cssSelector("button[class*='btn btn_addtobasket btn_addtobasket_add']");
	private static final By CHECKOUT = By.id("anchor-btn-checkout");
	private static final By VIEW_CART = By.cssSelector("a[class='view-cart']");

	public AddToCartPage clickAddToCart() {
		driver.findElement(ADD_TO_CART).sendKeys(Keys.ENTER);
		return this;

	}

	public AddToCartPage clickCheckout() {
		waitForElement(CHECKOUT, driver);
		driver.findElement(CHECKOUT).sendKeys(Keys.ENTER);
		return this;

	}

	public AddToCartPage clickViewCart() {
		waitForElement(VIEW_CART, driver);
		driver.findElement(VIEW_CART).sendKeys(Keys.ENTER);
		return this;

	}

	@Override
	public boolean waitForPageLoad() {
		boolean didPageLoad = false;
		try {
			waitForElement(ADD_TO_CART, driver);
			didPageLoad = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return didPageLoad;
	}

}
