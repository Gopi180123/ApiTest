package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginDemo {
	public WebDriver driver;

	// This test case is all about login to sales force application and navigating
	// to new contact
	// We have used thread.sleep for demo purpose to provide UI feel to the viewers
	// In future we can maintain it in framework level
	
	@BeforeClass
	public void launchUrl() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\pops\\Tog_Website_new\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://test.salesforce.com/");
	}

	@Test
	public void demoTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(
				"//*[@data-aura-class='uiTooltip']//lightning-icon//lightning-primitive-icon//*[@data-key='add']"))
				.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[contains(text(),'New Contact')]")).click();
		Thread.sleep(10000);
		driver.quit();

	}
}
