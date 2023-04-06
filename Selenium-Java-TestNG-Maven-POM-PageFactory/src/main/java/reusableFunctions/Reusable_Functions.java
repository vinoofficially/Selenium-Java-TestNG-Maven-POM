package reusableFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.github.javafaker.Faker;

import commonFunctions.BaseClass;
import pageObjects.Home_Page_Objects;

public class Reusable_Functions extends BaseClass {

	public String artApprovalname;
	public String artApprovaldescription;

	private static Reusable_Functions reusablefunctioninstance;

	private Reusable_Functions() {

	}

	public static Reusable_Functions getInstance() {

		if (reusablefunctioninstance == null) {

			reusablefunctioninstance = new Reusable_Functions();
		}

		return reusablefunctioninstance;

	}

	public void createArtApproval () throws InterruptedException {

		Faker faker = new Faker();
		artApprovalname=faker.company().name();
		artApprovaldescription=faker.company().catchPhrase();
		Home_Page_Objects.getInstance().getArtapprovalLink().click();
		Home_Page_Objects.getInstance().getCreateNewbtn().click();
		Home_Page_Objects.getInstance().getApprovalName().sendKeys(artApprovalname);
		Home_Page_Objects.getInstance().getApprovalDescription().sendKeys(artApprovaldescription);
		Home_Page_Objects.getInstance().getApprovalName().click();
		Home_Page_Objects.getInstance().getAddstockartBtn().click();
		Home_Page_Objects.getInstance().getFirststockArt().click();
		Home_Page_Objects.getInstance().getAddfilesBtn().click();
		Home_Page_Objects.getInstance().getArtApprovalPlusIcon().click();
		Home_Page_Objects.getInstance().getArtApprovaluploadFile().sendKeys(System.getProperty("user.dir") + "/src/test/resources"
				+ "/Test_Data/Tesla.svg");
		Home_Page_Objects.getInstance().getAddFromMyArtBtn().click();
		Home_Page_Objects.getInstance().getSearchInput().sendKeys("Adidas");
		WebElement firstArt = driver.findElement(By.cssSelector(".mat-row:nth-child(2) .outline-none > .m-b-0:nth-child(1)"));
		firstArt.click();
		Home_Page_Objects.getInstance().getSubmitBtn().click();
	}	

	public void deleteAllartApproval () throws InterruptedException {

		for (int i=0;i<Home_Page_Objects.getInstance().getListofAA().size();i++) {
			driver.findElements(By.id("approvalActionMenu")).get(i).click();
			driver.findElement(By.cssSelector(".danger-color")).click();
			driver.findElements(By.cssSelector(".mat-checkbox-inner-container")).get(0).click();
			driver.findElements(By.cssSelector(".mat-checkbox-inner-container")).get(1).click();
			driver.findElements(By.cssSelector(".mat-checkbox-inner-container")).get(2).click();
			driver.findElement(By.id("submitBtn")).click();
		}
	}

	public void deleteCreatedartapproval() {
		//for loop to get the delete the created art approval
		for (int i=0;i<Home_Page_Objects.getInstance().getListofAA().size();i++) {
			String createdartApproval = Home_Page_Objects.getInstance().getListofAA().get(i).getText();
			if (createdartApproval.contentEquals(artApprovalname)) {
				driver.findElements(By.id("approvalActionMenu")).get(i).click();
				driver.findElement(By.cssSelector(".danger-color")).click();
				driver.findElements(By.cssSelector(".mat-checkbox-inner-container")).get(0).click();
				driver.findElements(By.cssSelector(".mat-checkbox-inner-container")).get(1).click();
				driver.findElements(By.cssSelector(".mat-checkbox-inner-container")).get(2).click();
				driver.findElement(By.id("submitBtn")).click();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}


		}

	}


}
