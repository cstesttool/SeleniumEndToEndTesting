package StepDefintions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class LoginSteps {

	WebDriver driver;
	
	@Given("user launches browser")
	public void lanuch_browser() {
		driver = new ChromeDriver();		
	}
	
	@When("user enter usersName and password")
	public void enter_user_password() {
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("submit")).click();
	}
	
	@Then("User should be homepage")
	public void verifuHomePage() {
		System.out.println("login is done");
		driver.quit();
	}
	
	@When("user enter usersName {string} and password {string}")
	public void enter_user_password(String userName, String password) {
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
	}
	
	@When("user enters credentials")
	public void userEnterCrentails(DataTable table) throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/login");
		Thread.sleep(3000);
		
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
		
		for(Map<String, String> row: data) {
			WebElement user = driver.findElement(By.id("username"));
			user.clear();
			user.sendKeys(row.get("username"));
			WebElement pass = driver.findElement(By.id("password"));
			pass.clear();
			pass.sendKeys(row.get("password"));
			driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
			Thread.sleep(2000);
			boolean bool = driver.findElement(By.id("flash")).isDisplayed();
			if(driver.getCurrentUrl().contains("secure")) {
				Assert.assertTrue(bool);
				Thread.sleep(1000);
				driver.navigate().back();
			}else {
				Assert.assertTrue(bool);
			}
			
		}
		//driver.quit();
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
	}
	@When("user enter {string} and {string}")
	public void user_enter_and(String username, String password) throws InterruptedException {
		WebElement user = driver.findElement(By.id("username"));
		user.clear();
		user.sendKeys(username);
		WebElement pass = driver.findElement(By.id("password"));
		pass.clear();
		pass.sendKeys(password);
		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
		Thread.sleep(2000);
	}
	@Then("verify error and success {string}")
	public void verify_error_and_success(String message) {
	   String url = driver.getCurrentUrl();
	   if(url.contains(message)) {
		   Assert.assertTrue(true);
	   }else {
		   WebElement element = driver.findElement(By.id("flash"));
		   Assert.assertTrue(element.isDisplayed());
	   }
	}
	
	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
	    System.out.println("multiple tags Given");
	}
	@When("I complete action")
	public void i_complete_action() {
		System.out.println("multiple tags When");
	}
	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		System.out.println("multiple tags then");
	}
	
	@Given("single tags check")
	public void single_tags_check() {
		System.out.println("single tags Given");
	}
	@When("providing single tags")
	public void providing_single_tags() {
		System.out.println("single tags When");
	}
	@Then("verifying single tag")
	public void verifying_single_tag() {
		System.out.println("single tags then");
	}
	
	@Before
	public void setup() {
		System.out.println("before each scenario");
	}
	
	@After
	public void teardown() {
		System.out.println("after each scenario");
	}
	
	@BeforeStep
	public void setupstep() {
		System.out.println("before each step");
	}
	
	@AfterStep
	public void teardownStep() {
		System.out.println("after each step");
	}
	
	@Before(value="@smoke", order=2)
	public void setup1() {
		System.out.println("before each scenario");
	}
	
	@After(value="@smoke", order=2)
	public void teardown1() {
		System.out.println("after each scenario");
	}
	
	@Before(value="@smoke", order=1)
	public void setup2() {
		System.out.println("before each scenario");
	}
	
	@After(value="@smoke", order=1)
	public void teardown2() {
		System.out.println("after each scenario");
	}
}
