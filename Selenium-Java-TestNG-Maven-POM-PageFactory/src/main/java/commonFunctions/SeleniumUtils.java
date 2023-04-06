package commonFunctions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class SeleniumUtils {

	private static SeleniumUtils seleniumutilinstance;

	private SeleniumUtils() {

	}

	public static SeleniumUtils getInstance() {

		if (seleniumutilinstance == null) {

			seleniumutilinstance = new SeleniumUtils();
		}
		return seleniumutilinstance;
	}

	public WebElement waitForElement(WebElement locator, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public Boolean textContains(WebElement locator, String element) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.textToBePresentInElement(locator, element));
	}


	public void selectDropdownOptionByText(By locator, String optionText) {
		WebElement dropdown = BaseClass.driver.findElement(locator);
		Select select = new Select(dropdown);
		select.selectByVisibleText(optionText);
	}

	public void switchToFrame(String frameNameOrId) {
		BaseClass.driver.switchTo().frame(frameNameOrId);
	}

	public void switchToDefaultContent() {
		BaseClass.driver.switchTo().defaultContent();
	}

	public void switchToWindow(String windowTitle) {
		String currentWindowHandle = BaseClass.driver.getWindowHandle();
		Set<String> windowHandles = BaseClass.driver.getWindowHandles();

		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(currentWindowHandle)) {
				BaseClass.driver.switchTo().window(windowHandle);
				if (BaseClass.driver.getTitle().equals(windowTitle)) {
					return;
				}
			}
		}

		throw new NoSuchWindowException("Could not find window with title: " + windowTitle);
	}

	public void closeWindow() {
		BaseClass.driver.quit();
	}

	public void moveMouseToElement(WebElement element) {
		Actions actions = new Actions(BaseClass.driver);
		actions.moveToElement(element).build().perform();
	}

	public void dragAndDrop(WebElement element, int xOffset, int yOffset) {
		Actions actions = new Actions(BaseClass.driver);
		actions.dragAndDropBy(element, xOffset, yOffset).build().perform();
	}

	public void clickAndHold(WebElement element) {
		Actions actions = new Actions(BaseClass.driver);
		actions.clickAndHold(element).build().perform();
	}

	public void keyPress(Keys key) {
		Actions actions = new Actions(BaseClass.driver);
		actions.sendKeys(key).build().perform();
	}

}