package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	WebDriver driver;
	
//	@Test
//	public void test() {
//		WebDriverManager.chromedriver().setup();
//
//		WebDriver driver = new ChromeDriver();
//
//		driver.get("http://localhost:8088/");
//	}
	

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	@Test
	public void testConnection() {
		driver.get("http://localhost:8088/");

	}
	
	@Test
	public void testFindOwner() {
		driver.findElement(By.cssSelector("#main-navbar > ul > li:nth-child(2) > a")).click();
		//System.out.println(driver.findElement(By.cssSelector("body > div > div > h2")).equals("Find Owners"));
	}
	@Test
	public void testFindVeterinarians() {
		driver.findElement(By.cssSelector("#main-navbar > ul > li:nth-child(3)")).click();
//		driver.findElement(By.cssSelector("a.btn btn-default]")).click();
//		driver.findElement(By.id("firstName")).sendKeys("Frank");
//		driver.findElement(By.id("lastName")).sendKeys("Herbert");
//		driver.findElement(By.id("address")).sendKeys("dune");
//		driver.findElement(By.id("city")).sendKeys("arrakis");
//		driver.findElement(By.id("telephone")).sendKeys("05437404820");
//		driver.findElements(By.className("btn btn-default"));
		
		
	}
	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
