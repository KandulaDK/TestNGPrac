package TestNGBasic;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.com.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class implicity {
	WebDriver driver;
	public int i = 0;

	public implicity() throws IOException {
		testBase tb = new testBase();
		this.driver = tb.webDriverManager();
	}

	@Parameters({ "url", "status" })
	@BeforeClass
	public void openPage(String url, String status) {
		driver.get(url);
		System.out.println(status);
	}

	@Test(timeOut = 20000)
	public void clickLogin() throws InterruptedException {
		driver.findElement(By.linkText("Login")).click();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> it = aw.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
//		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(8));
//		wb.until(ExpectedConditions.)));

	}

//	@Parameters({ "username", "password" })
	@Test(dataProvider="loginData")
	public void enterTheInput(String username, String pswd) throws InterruptedException {
		// System.out.println(driver.findElement(By.id("tp-message-error")).isDisplayed());
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pswd);
		Thread.sleep(2000);
		driver.findElement(By.id("tp-sign-in")).click();

		Assert.assertTrue(driver.findElement(By.id("tp-message-error")).isDisplayed());
		i++;
		TakesScreenshot tss = ((TakesScreenshot) driver);
		File src = tss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\org.TestNGHYR\\target/iffailed"+i+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@DataProvider(name="loginData")
	public Object[][] getData() {
		//1st Combination of username and password good credit history row
		//2nd username and password - no credit history
		//3rd fraudelent credit history
		
		Object[][] data = new Object[3][2];
		
		//1st set
		data[0][0] = "dineshkumarkandula@gmail.com";
		data[0][1] = "dinnu1234@";
		
		//2nd set
		data[1][0] = "kumarakandula@gmail.com";
		data[1][1] = "kumar@1233";
		
		//3rd set
		data[2][0] = "kanduladinesh@wsgc.com";
		data[2][1] = "williamsSonama";
		
		return data;
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
