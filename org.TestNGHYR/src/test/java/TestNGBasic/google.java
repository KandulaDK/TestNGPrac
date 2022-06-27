package TestNGBasic;

import org.com.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class google {

	public WebDriver driver;
	Date startTime;
	Date endTime;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	
	public google() throws IOException {
		testBase tb = new testBase();
		this.driver = tb.webDriverManager();
	}


	@BeforeClass   
	public void openGoogle() {
		sdf.setTimeZone(TimeZone.getTimeZone("IST"));
		startTime = new Date();
		String startDateTime = sdf.format(startTime);
		System.out.println("Start Date Time: "+startDateTime);
		
		driver.get("https://www.google.com");
	}

	@Parameters({"url"})
	@Test(priority = 20)
	public void enterTheSearch(@Optional("https://www.google.com") String url) throws InterruptedException {
		
		driver.get(url);
		Actions a = new Actions(driver);
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("dinesh Kumar kandula", Keys.ENTER);
//		driver.findElement(By.xpath("//h3[normalize-space()='dinesh-kumar-kandula Profiles - Facebook']")).click();
		driver.findElement(By.xpath("(//h3[text()='Dinesh Kumar kandula - YouTube'])[1]")).click();
		Thread.sleep(3000);
		List<WebElement> videoTitle = driver.findElements(By.id("video-title"));

		for (WebElement title : videoTitle) {
//			System.out.println(title.getAttribute("title"));
			if (title.getAttribute("title").equals("Kannanule kalalalu in Tamil cute girl sings")) {
				title.click();
				break;
			}
		}
//		System.out.println(driver.findElement(By.className("ytp-ad-skip-button ytp-button")).isEnabled());
		Thread.sleep(8000);
		WebElement nextBtn = driver.findElement(By.xpath("//a[@title='Next (SHIFT+n)']"));
		a.moveToElement(nextBtn).click().build().perform();

//		assertEquals(driver.getTitle(), "Dinesh Kumar Kandula Profiles | Facebook","This failed due to Titile Mismatch");
		System.out.println(driver.getTitle());

	}
	@AfterClass
	public void tearDown() {
		try{
			driver.quit();
		}catch(Exception e) {
			e.getMessage();
		}
		sdf.setTimeZone(TimeZone.getTimeZone("IST"));
		endTime = new Date();
		String endDateTime = sdf.format(endTime);
		System.out.println("End Date Time: "+endDateTime);
		
		long diff = (endTime.getTime()-startTime.getTime())/1000;
		String executionTime = String.valueOf(diff/60) + " Min " + String.valueOf(diff%60) + " Sec";
		System.out.println("Execution Time: " +executionTime);
	}
}
