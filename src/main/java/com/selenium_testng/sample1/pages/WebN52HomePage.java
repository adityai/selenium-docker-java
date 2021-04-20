package com.selenium_testng.sample1.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class WebN52HomePage extends AbstractPage<WebN52HomePage> {

    @FindBy(xpath = "/html/body/div[4]/main/div/div[1]/div[1]/div[1]/div/div/div[1]/h1")
    private WebElement slogan;

    public WebN52HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the Github homepage")
    @Override
    protected void load() {
        driver.get("https://www.webn52.bsc.bscal.com");
    }

    @Override
    protected void isLoaded() throws Error {
        assertThat(driver.getTitle()).contains("Home | Blue Shield of California");
    }

    @Step("Get slogan text")
    public String getSloganText() {
        return slogan.getText();
    }


}
