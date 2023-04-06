package testCases;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import commonFunctions.BaseClass;
import commonFunctions.SeleniumUtils;
import extentReport.ExtentTestNGITestListener;
import pageObjects.Home_Page_Objects;
import reusableFunctions.Reusable_Functions;


public class Validate_Art_Approval extends BaseClass {

	@Test
	public void TC_1_Validate_ArtApproval_list_page() throws InterruptedException, AWTException {
		Reusable_Functions.getInstance().createArtApproval();	
		SeleniumUtils.getInstance().moveMouseToElement(Home_Page_Objects.getInstance().getHamBurger());
		Home_Page_Objects.getInstance().getHamBurger().click();
		SeleniumUtils.getInstance().waitForElement(Home_Page_Objects.getInstance().getArtapprovalLink(),Duration.ofSeconds(5)).click();
		String artapprovalTitlename = Home_Page_Objects.getInstance().getArtapprovalTitle().getText();
		Assert.assertEquals(artapprovalTitlename, "Art Approvals");
		Home_Page_Objects.getInstance().getApprovalStatusFilterMenu().click();
		String openTxt = Home_Page_Objects.getInstance().getMatmenuItem().get(0).getText();
		Assert.assertEquals(openTxt, "Open");
		String archivedTxt = Home_Page_Objects.getInstance().getMatmenuItem().get(1).getText();
		Assert.assertEquals(archivedTxt, "Archived");
		SeleniumUtils.getInstance().keyPress(Keys.ESCAPE);
		Perform_Infinite_Scroll();
		Validate_No_Of_Artapprovals();
		Reusable_Functions.getInstance().deleteCreatedartapproval();
	}

	public void Perform_Infinite_Scroll() throws InterruptedException {

		// Get the instance of the JavascriptExecutor interface
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Find the scrollable container element
		WebElement container = driver.findElement(By.className("scrolling-container"));

		// Scroll to the bottom of the first 20 results
		int numResults = 20;
		for (int i = 0; i < numResults; i++) {
			js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", container);
			Thread.sleep(200);
		}

		// Repeat the scrolling process until the bottom of the content is reached
		while (true) {

			// Get the initial height of the scrollable content
			long initialHeight = ((Number) js.executeScript("return arguments[0].scrollHeight", container)).longValue();

			// Scroll to the bottom of the container element
			js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", container);

			// Wait for some time to allow new content to load
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Get the new height of the scrollable content
			long newHeight = ((Number) js.executeScript("return arguments[0].scrollHeight", container)).longValue();

			// If the height of the content has not increased, we have reached the bottom
			if (newHeight == initialHeight) {
				break;
			}

		}
	}

	public void Validate_No_Of_Artapprovals() throws InterruptedException {
		int totalartApprovalSize = driver.findElements(By.cssSelector(".approval-name")).size();
		int approvedartApprovalSize = driver.findElements(By.cssSelector(".approval-name .success")).size();
		int notApprovedartapprovals = totalartApprovalSize - approvedartApprovalSize;
		System.out.println(notApprovedartapprovals);
		Home_Page_Objects.getInstance().getApprovalStatusMenuTrigger().click();
		String approvedTxt = Home_Page_Objects.getInstance().getMatmenuItem().get(0).getText();
		System.out.println(approvedartApprovalSize);
		String notapprovedTxt = Home_Page_Objects.getInstance().getMatmenuItem().get(1).getText();
		Assert.assertEquals(notapprovedTxt, "Not Approved" + " " + "(" + notApprovedartapprovals + ")");
		SeleniumUtils.getInstance().keyPress(Keys.ESCAPE);
	}

}










