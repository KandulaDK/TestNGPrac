package TestNGBasic;

import org.com.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class google {

	public WebDriver driver;
	
	public google() throws IOException {
		testBase tb = new testBase();
		this.driver = tb.webDriverManager();
	}


	@BeforeClass   
	public void openGoogle() {
		driver.get("https://www.google.com");
	}

	@Parameters({"url"})
	@Test()
	public void enterTheSearch(String url) throws InterruptedException {
		
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
		driver.quit();
	}
}
