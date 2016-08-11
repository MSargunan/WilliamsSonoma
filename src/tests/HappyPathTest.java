
package tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import exceptions.PageNotLoadedException;
import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.HomePage;

/**
 * Automated test case to perform 1. Go to http://www.williams-sonoma.com/ 2. Under Cookware, select Tea
 * Kettles 3. Select any Tea Kettle 4. Add to cart 5. Press the Checkout button
 * 6. On the shopping cart page, on that order line, click â Save for later
 * 7. Verify that the item was saved
 */
public class HappyPathTest {
	WebDriver driver;
	String Test;

	@Before
	public void beforeTest() {
		// Get Driver
		System.setProperty("webdriver.chrome.driver", "C:/selenium-2.53.1/chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize window
		driver.manage().window().maximize();
		// Launch URL
		driver.get("http://www.williams-sonoma.com/");

	}

	@Test
	public void testItemSaveForLater() throws PageNotLoadedException {

		HomePage homePage = new HomePage(driver);
		homePage.clickCookwareMenu().clickCategory("Tea Kettles")
				.clickProduct("Chantal Copper Whistling Tea Kettle, Copper");

		AddToCartPage addToCartPage = new AddToCartPage(driver);
		addToCartPage.clickAddToCart().clickCheckout();

		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.clickSaveForLater();

		assertTrue("Failed to find saved item confirmation message", checkoutPage.validateIfItemSavedForLater());
	}

	@After
	public void afterTest() {
		driver.close();
	}

}
