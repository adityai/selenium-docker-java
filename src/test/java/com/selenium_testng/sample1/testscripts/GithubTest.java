package com.selenium_testng.sample1.testscripts;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
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
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
		DesiredCapabilities desiredCapabilitiesChrome = DesiredCapabilities.htmlUnit();
		desiredCapabilitiesChrome.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		driver = new ChromeDriver(desiredCapabilitiesChrome);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    public void verifyGithubSlogan() {
        HomePage homePage = new HomePage(driver);
        homePage.get();
        assertThat(homePage.getSloganText()).isEqualTo("Built for developers");
    }
}
