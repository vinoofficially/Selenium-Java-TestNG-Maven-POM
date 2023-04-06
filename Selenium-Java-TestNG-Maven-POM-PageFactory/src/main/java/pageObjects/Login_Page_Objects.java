package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Login_Page_Objects {

	private static Login_Page_Objects loginpageinstance;

	private Login_Page_Objects() {

	}

	public static Login_Page_Objects getInstance() {

		if (loginpageinstance == null) {

			loginpageinstance = new Login_Page_Objects();
		}

		return loginpageinstance;

	}

	//Page Factory - OR:

	@FindAll({
		@FindBy(id = "emailInput"),
		@FindBy(id = "email")
	})
	private WebElement username;

	@FindBy(id="passwordInput")
	private WebElement password;

	@FindBy(id="signInButton")
	private WebElement loginBtn;

	@FindBy (xpath = "//div[@class='gf-logo-container']//div[@class='logo graphics-flow outline-none']")
	private WebElement gfLogo;

	//Getters for Page Objects
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getGfLogo() {
		return gfLogo;
	}

}
