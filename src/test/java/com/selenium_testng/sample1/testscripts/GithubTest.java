package com.selenium_testng.sample1.testscripts;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium_testng.sample1.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class GithubTest {

	protected WebDriver driver;

	@BeforeSuite
	public void setupSuite() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeClass
	@Parameters({ "browser" })
	public void setup(String browser) throws MalformedURLException {
		DesiredCapabilities capability = null;
		if ("chrome".equals(browser)) {
			ChromeOptions chromeOptions = new ChromeOptions();
//			capability = DesiredCapabilities.chrome();
//			capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//			driver = new ChromeDriver(capability);
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"), chromeOptions);
		} else if ("firefox".equals(browser)) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
//			driver = new FirefoxDriver(firefoxOptions);
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"), firefoxOptions);
		} else if ("opera".equals(browser)) {
			OperaOptions operaOptions = new OperaOptions();
//			driver = new OperaDriver(operaOptions);
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"), operaOptions);
		}
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public void verifyGithubSlogan() {
		HomePage homePage = new HomePage(driver);
		homePage.get();
		assertThat(homePage.getSloganText()).isEqualTo("Where the world\nbuilds software");
	}
}
