package com.ptc.sairam.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;

public class PtcContactusTest extends TestCase {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\WebDev\\workspace\\Selenium\\Drivers\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testPtcContactus() throws Exception {
		driver.get("https://www.ptc.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Contact Us")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Blogs'])[1]/preceding::img[1]"))
				.click();
		driver.close();
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
