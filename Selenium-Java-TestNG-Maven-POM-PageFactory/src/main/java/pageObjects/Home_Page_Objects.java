package pageObjects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page_Objects {

	private static Home_Page_Objects homepageinstance;

	private Home_Page_Objects() {

	}

	public static Home_Page_Objects getInstance() {

		if (homepageinstance == null) {

			homepageinstance = new Home_Page_Objects();
		}
		return homepageinstance;

	}

	@FindBy(css=("#approvalName"))
	private WebElement approvalName;

	@FindBy(css=".item-card:nth-child(1) .display-block")
	private WebElement firststockArt;

	@FindBy(id="addFileBtn")
	private WebElement addfilesBtn;


	@FindBy(id=("approvalDescription"))
	private WebElement approvalDescription;


	@FindBy(xpath = "//span[contains(text(),'Stock Art')]")
	private WebElement addstockartBtn;

	@FindBy (css = "gf-approvals-list > div > gf-art-approvals-list > div "
			+ "> div.show-for-small > div > div.flex-container.align-"
			+ "middle.filter-results-action > div.flex-conta"
			+ "iner.align-middle > button"
			+ " > span.mat-button-wrapper")
	private WebElement createNewbtn;

	@FindBy(css=("#myArtLink > span"))
	private WebElement myartLink;

	@FindBy(css=("#approvalsLink > span"))
	private WebElement artapprovalLink;

	@FindBy(id=("breadcrumbRoot"))
	private WebElement myArt;

	@FindBy(id=("myArtSearch"))
	private WebElement myartSearch;

	@FindBy(css=(".mat-menu-trigger > .mat-icon"))
	private WebElement gfuseravatarIcon;

	@FindBy(css=(".t-13-600-p"))
	private WebElement gfadminNametxt;

	@FindBy(css=(".p-x-2:nth-child(2)"))
	private WebElement gfadminEmailtxt;

	@FindBy(id=("approvalsFilterMenu"))
	private WebElement approvalsFilterMenu;

	@FindBy(css=(".t-20-500-p"))
	private WebElement myartsearchResultstxt;

	@FindBy(id=("folderItem"))
	private WebElement folderItem;

	@FindBy (id=("optionsButton"))
	private WebElement folderoptionsBtn;

	@FindBy (id =("cancelBtn"))
	private WebElement folderactionsdialogcancelBtn;

	@FindBy(xpath=("//button[contains(text(),'Rename')]"))
	private WebElement renameTxt;

	@FindBy(id=("folderActionsDialog"))
	private WebElement folderactionsDialog;

	@FindBy(className ="text-nowrap")
	private List<WebElement> listofAA;

	@FindBy(className ="art-approval-title")
	private WebElement artapprovalTitle;

	@FindBy (id="approvalStatusFilterMenu")
	private WebElement approvalStatusFilterMenu;

	@FindBy (className = "mat-menu-item")
	private List<WebElement> matmenuItem;

	@FindBy (id="myArtSearch")
	private WebElement myArtSearch;

	@FindBy(id="helpIcon")
	private WebElement helpIcon;

	@FindBy (id="approvalStatusMenuTrigger")
	private WebElement approvalStatusMenuTrigger;

	@FindBy (id="approvalsFilterByCreator")
	private WebElement approvalsFilterByCreator;

	@FindBy (xpath="//span[@class='mat-tooltip-trigger']")
	private WebElement artApprovalPlusIcon;

	@FindBy (id ="uploadBtn")
	private WebElement artApprovaluploadBtn;


	@FindBy (css ="input[type=\"file\"]")
	private WebElement artApprovaluploadFile;

	@FindBy (id ="addFromMyArtBtn")
	private WebElement addFromMyArtBtn;

	@FindBy (id ="searchInput")
	private WebElement searchInput;

	@FindBy (className ="mat-column-name")
	private List<WebElement> matRow;

	@FindBy (id ="submitBtn")
	private WebElement submitBtn;

	@FindBy (xpath ="//h1[@class='t-24-400-p m-t-1 dark-text']")
	private WebElement artApprovalNameTxtSidePanel;

	@FindBy (className="art-name")
	private List<WebElement> listOfArts;

	@FindBy (xpath = "//mat-icon[@class='mat-icon notranslate mat-primary material-icons mat-ligature-font']")
	private WebElement hamBurger;

	public WebElement getHamBurger() {
		return hamBurger;
	}

	public List<WebElement> getListOfArts() {
		return listOfArts;
	}

	public List<WebElement> getMatRow() {
		return matRow;
	}

	public WebElement getArtApprovalNameTxtSidePanel() {
		return artApprovalNameTxtSidePanel;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getSearchInput() {
		return searchInput;
	}

	public WebElement getAddFromMyArtBtn() {
		return addFromMyArtBtn;
	}

	public WebElement getArtApprovaluploadFile() {
		return artApprovaluploadFile;
	}

	public WebElement getArtApprovaluploadBtn() {
		return artApprovaluploadBtn;
	}

	public WebElement getArtApprovalPlusIcon() {
		return artApprovalPlusIcon;
	}

	public WebElement getApprovalName() {
		return approvalName;
	}

	public WebElement getFirststockArt() {
		return firststockArt;
	}

	public WebElement getAddfilesBtn() {
		return addfilesBtn;
	}

	public WebElement getApprovalDescription() {
		return approvalDescription;
	}

	public WebElement getAddstockartBtn() {
		return addstockartBtn;
	}

	public WebElement getCreateNewbtn() {
		return createNewbtn;
	}

	public WebElement getMyartLink() {
		return myartLink;
	}

	public WebElement getArtapprovalLink() {
		return artapprovalLink;
	}

	public WebElement getMyArt() {
		return myArt;
	}

	public WebElement getMyartSearch() {
		return myartSearch;
	}

	public WebElement getGfuseravatarIcon() {
		return gfuseravatarIcon;
	}

	public WebElement getGfadminNametxt() {
		return gfadminNametxt;
	}

	public WebElement getGfadminEmailtxt() {
		return gfadminEmailtxt;
	}

	public WebElement getMyartsearchResultstxt() {
		return myartsearchResultstxt;
	}

	public WebElement getFolderItem() {
		return folderItem;
	}

	public WebElement getFolderoptionsBtn() {
		return folderoptionsBtn;
	}

	public WebElement getFolderactionsdialogcancelBtn() {
		return folderactionsdialogcancelBtn;
	}

	public WebElement getRenameTxt() {
		return renameTxt;
	}

	public WebElement getFolderactionsDialog() {
		return folderactionsDialog;
	}

	public List<WebElement> getListofAA() {
		return listofAA;
	}

	public WebElement getArtapprovalTitle() {
		return artapprovalTitle;
	}

	public WebElement getApprovalStatusFilterMenu() {
		return approvalStatusFilterMenu;
	}

	public List<WebElement> getMatmenuItem() {
		return matmenuItem;
	}

	public WebElement getMyArtSearch() {
		return myArtSearch;
	}

	public WebElement getHelpIcon() {
		return helpIcon;
	}

	public WebElement getApprovalStatusMenuTrigger() {
		return approvalStatusMenuTrigger;
	}

	public WebElement getApprovalsFilterByCreator() {
		return approvalsFilterByCreator;
	}

	public WebElement getApprovalsFilterMenu() {
		return approvalsFilterMenu;
	}

}


