package cuke;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Login;

public class AssessBatchTest {
	
	public static Login login;
	public static WebDriver driver;
	
//	@BeforeSuite
//	public static void login() throws Throwable{
//		File file = new File("src/main/resources/chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//		driver = new ChromeDriver();
//		login = new Login(driver);
//		// go to website
//		driver.get("https://dev-caliber.revature.tech/");
//		//enter username and password
//		login.getUsernameField().sendKeys("calibot@revature.com");
//		login.getPasswordField().sendKeys("*6Ak4-&kXnNTfTh6");
//		// login
//		login.getLoginButton().click();
//	}
//	
//	@Given("^the user is ready to assess the batch$")
//	public static void yearDropDown() {
//		// go to assess batch
//		WebElement we = driver.findElement(By.linkText("Assess Batch"));
//		we.click();
//	}
	
//	@When("^the user clicks \"([^\"]*)\" from the drop down menu$")
//	public static void click_yr_drop_down_menu(String year) {
//		WebElement we = driver.findElement(By.cssSelector("a [class='dropdown-toggle ng-binding'] [data-toggle='dropdown'] [aria-expanded='true']"));
//		Select what = new Select(we);
//		what.selectByVisibleText(""+year);
//		we.click();
//	}
//	
//	@Then("^the link text changes to \"([^\"]*)\"$")
//	public static void link_text_changes(String year) {
//		String we = driver.findElement(By.linkText(""+year)).getText();
//		Assert.assertEquals(we, "\""+year+"\"");
//		driver.close();
//	}
	//-------------------------------------------------------------------
	@Given("^the user is on the assess batch page$")
	public void the_user_is_on_the_assess_batch_page() throws Throwable {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		login = new Login(driver);
		// go to website
		driver.get("https://dev-caliber.revature.tech/");
		//enter username and password
		login.getUsernameField().sendKeys("calibot@revature.com");
		login.getPasswordField().sendKeys("*6Ak4-&kXnNTfTh6");
		// login
		login.getLoginButton().click();
		// go to assess batch
		WebDriverWait wdw = new WebDriverWait(driver, 15);
		wdw.until(ExpectedConditions.urlToBe("https://dev-caliber.revature.tech/caliber/#/vp/home"));
		WebElement we = driver.findElement(By.linkText("Assess Batch"));
		we.click();
	}

	@When("^the user clicks on the year drop down menu$")
	public void the_user_clicks_on_the_year_drop_down_menu() throws Throwable {
//		WebElement we = driver.findElement(By.cssSelector("a [class='dropdown-toggle ng-binding'] [data-toggle='dropdown'] [aria-expanded='true']"));
//		WebElement we = driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[2]/ul[1]/li[1]/a"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement we = driver.findElement(By.linkText("2018"));
		System.out.println(we.getText());
		we.click();// assume button clicked
	}

	@When("^the user clicks on \"([^\"]*)\"$")
	public void the_user_clicks_on(String arg1) throws Throwable {
//		WebElement we = driver.findElement(By.cssSelector("a [class='dropdown-toggle ng-binding'] [data-toggle='dropdown'] [aria-expanded='true']"));
//		Select what = new Select(we);
//		what.selectByVisibleText(arg1);
		WebElement we = driver.findElement(By.linkText(arg1));
		System.out.println("choose from drop down: "+we.getText()+" vs "+arg1);
		
		we.click();
		
	}

	@Then("^the drop down menu's value changes to \"([^\"]*)\"$")
	public void the_drop_down_menu_s_value_changes_to(String arg1) throws Throwable {
		System.out.print("then ");
		WebElement we = driver.findElement(By.linkText(arg1));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(we.getText()+" vs. "+arg1);

	    Assert.assertEquals(we.getText(), arg1);
	}

	
	@After
	public void closeIt() {
		driver.quit();
	}
	
	
	
}
