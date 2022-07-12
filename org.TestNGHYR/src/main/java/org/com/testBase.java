package org.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {
	 
//	public WebDriver webDriverManager() throws IOException {
//		FileInputStream fis = new FileInputStream(
//				System.getProperty("user.dir") + "/src/test/resource/base.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
//		String browser = pro.getProperty("browser");
//		String url = pro.getProperty("url");
//		
//		if (driver == null) {
//			if (browser.equalsIgnoreCase("chrome")) {
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//			} else if (browser.equalsIgnoreCase("firefox")) {
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//			} else if (browser.equalsIgnoreCase("edge")) {
//				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();
//			}
//			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////			driver.get(url);
//		}
//		return driver;
//	}
	
	private static Logger log = LogManager.getLogger(testBase.class.getName());
	public static WebDriver driver;
	private String proPath = "src\\main\\java\\org\\com\\parameters.properties";
	public static Properties prop;
	public static FileInputStream fis;
	private static String brow;
	
	public WebDriver getAutomationProperties() throws IOException {
		prop = new Properties();
		fis = new FileInputStream(proPath);

		if (fis == null) {
			log.error("Test Execution failed as unable to read property file");
		} else {
			log.info("Test Exection started with property file " + proPath);
			prop.load(fis);
			brow = prop.getProperty("browser");
			System.out.println(brow);
			if (brow.equalsIgnoreCase("Chrome")) {
				chromeDriver();
			} else if (brow.equalsIgnoreCase("Firefox")) {
				firefoxDriver();
			}
		}
		return driver;

	}

	@SuppressWarnings("deprecation")
	private void chromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	private void firefoxDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
