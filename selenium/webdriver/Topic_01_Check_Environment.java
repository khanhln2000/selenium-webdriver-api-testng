package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Check_Environment {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://m.facebook.com/?_rdr");
	}

	@Test
	public void TC_01_Url() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://m.facebook.com/?_rdr");
	}

	@Test
	public void TC_02_Title() {
		Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
