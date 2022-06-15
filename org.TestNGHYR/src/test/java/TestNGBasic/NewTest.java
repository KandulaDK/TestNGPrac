package TestNGBasic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/login");
		
//		id - document.getElementById('email');
//		name - document.getElementsByName('email')[0];
//		classname - document.getElementsByClassName("inputtext")[0];
//		tagName - document.getElementsByTagName('input')[13];
		
//		css selector - document.querySelector('#email');
//		xpath- document.evaluate(XpathExpression, contextNode, namespaceresolver, resultType, result).singleNodeValue;
//		document.evalute("//input[@id='email']",document,null,xpathResult.FIRST_ORDERED-NODE-TYPE,null).singleNodeValue;
		
		JavascriptExecutor jsEx = (JavascriptExecutor) driver;
		WebElement el = (WebElement) jsEx.executeScript("return document.getElementById('email');");
		el.sendKeys("dineshkumar007");
		
	} 


}
