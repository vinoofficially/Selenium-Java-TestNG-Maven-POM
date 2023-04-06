package commonFunctions;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Home_Page_Objects;
import pageObjects.Login_Page_Objects;


public class BaseClass {

	public static Properties properties;
	public static WebDriver driver;

	public Properties loadProperties() throws IOException {

		FileInputStream inputStream = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(inputStream);
		return properties;
	}

	public void initElements () {
		//Initializing page objects
		PageFactory.initElements(driver, Login_Page_Objects.getInstance());
		PageFactory.initElements(driver, Home_Page_Objects.getInstance());

	}

	public void login () {
		//Login
		Login_Page_Objects.getInstance().getUsername().sendKeys(properties.getProperty("username"));
		Login_Page_Objects.getInstance().getPassword().sendKeys(properties.getProperty("password"));
		Login_Page_Objects.getInstance().getLoginBtn().click();
		SeleniumUtils.getInstance().waitForElement(Login_Page_Objects.getInstance().getGfLogo(),Duration.ofSeconds(10)).isDisplayed();
	}

	@BeforeClass
	public void launchBrowser() throws IOException {		
		loadProperties();
		getProperties();
		initElements();
		login();
	}

	public void getProperties() {

		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String chromeBrowser = properties.getProperty("chromelocation");
		String firefoxBrowser = properties.getProperty("firefoxlocation");

		//Launching Browser

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new EdgeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}
	@AfterClass
	public void tearDown() {

		//GF Sign out
		SeleniumUtils.getInstance().moveMouseToElement(Home_Page_Objects.getInstance().getGfuseravatarIcon());
		Home_Page_Objects.getInstance().getGfuseravatarIcon().click();
		Home_Page_Objects.getInstance().getMatmenuItem().get(3).click();

		//Closing the browser
		SeleniumUtils.getInstance().closeWindow();
	}

}
