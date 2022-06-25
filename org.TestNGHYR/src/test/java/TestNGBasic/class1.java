package TestNGBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class class1 {
	
	WebDriver driver;
	
	@BeforeClass
	public void initilizeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Class1 initiated...");
	}
	
	@AfterClass
	public void exitTheBrowser() {
		System.out.println("......Class1 Ended");
		driver.quit();
	}
	@Test
	public void LaunchApp() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test(dependsOnMethods = "LaunchApp")
	public void EnterLoginDetails() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test(dependsOnMethods = "VerifyLogin")
	public void NavigateToMyInfo() {
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		System.out.println(Thread.currentThread().getId());
	}
	 
	@Test (dependsOnMethods = "NavigateToMyInfo")
	public void VerifyMyInfo() {
		System.out.println(driver.findElement(By.id("employee-details")).isDisplayed());
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test(dependsOnMethods = "EnterLoginDetails")
	public void VerifyLogin() {
		WebElement element = driver.findElement(By.id("welcome"));
		System.out.println(element.isDisplayed());
		System.out.println(element.getText());
		System.out.println(Thread.currentThread().getId());
	}
	
}
