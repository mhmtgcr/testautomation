package cucumberTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {

//	String lastName = "Herbert";
	WebDriver driver;
	WebElement searchBox;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--allow--insecure-localhost");
		opt.addArguments("acceptInsecureCerts");
		opt.addArguments("--ignore-certificate-errors");
		opt.addArguments("--disable-notifications");
		opt.addArguments("disable-infobars");

		opt.addArguments("--headles");
	}

	@Given("Launch the browser")
	public void launch_the_browser() {
		driver = new ChromeDriver();
	}

	@When("Hit pet clinic on the browser")
	public void hit_pet_clinic_on_the_browser() {
		driver.get("http://localhost:8088/");
	}

	@Then("navigate to find owner")
	public void navigate_to_find_owner() {
		driver.findElement(By.cssSelector("#main-navbar > ul > li:nth-child(2) > a")).click();
	}

	@Then("^send keys (.*) to search box$")
	public void send_keys_to_search_box(String lastName) {
		driver.findElement(By.id("lastName")).sendKeys(lastName);

	}

	@Then("^Search it (.*) (.*) (.*) (.*) (.*)$")
	public void search_it(String firstName, String lastName, String address, String city, String phone)
			throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button")).submit();
		Thread.sleep(4000);
		try {
			if (driver.findElement(By.xpath("//*[@id=\"lastNameGroup\"]/div/span/div/p")).getText()
					.equals("has not been found")) {
				driver.findElement(By.xpath("/html/body/div/div/a")).click();
				driver.findElement(By.id("firstName")).sendKeys(firstName);
				driver.findElement(By.id("lastName")).sendKeys(lastName);
				driver.findElement(By.id("address")).sendKeys(address);
				driver.findElement(By.id("city")).sendKeys(city);
				driver.findElement(By.id("telephone")).sendKeys(phone);
				Thread.sleep(3000);
				driver.findElement(By.className("btn-default")).submit();

			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}

	}

	@After
	public void cleanUp() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
