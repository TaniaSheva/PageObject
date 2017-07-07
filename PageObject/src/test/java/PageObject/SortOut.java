package PageObject;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SortOut {
    private WebDriver driver;

    @Before
    public void startDriver() {
        driver = new FirefoxDriver();
    }
    WomenClothes WomenClothes = new WomenClothes();

    @Test
    public void checkSortingOption() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, 60);
    	WomenClothes.openPage(WomenClothes.pageURL);

    }

    @After
    public void stutDownDriver() {
        driver.close();
    }
}