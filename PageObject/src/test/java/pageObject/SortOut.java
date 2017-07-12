package pageObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class SortOut {
    public static WebDriver driver;
    
   
    @Before
    public void startDriver() {
        driver = new ChromeDriver();
    }
    

    @Test
//    public void checkSortingOption() throws InterruptedException {
    
//    	//GIVEN
//    	WomenClothes WomenClothes = new WomenClothes();
//    	WomenClothes.openPage(WomenClothes.pageURL);
    	//WHEN
//    	WomenClothes.changeSortingOption();
 //   	Thread.sleep(2000);
    	//THEN
  //  	assertTrue(WomenClothes.arePricesLowestFirst());
    		  	
 //   }
    
    public void filterByColor() throws InterruptedException {
    	//GIVEN 
    	WomenClothes WomenClothes = new WomenClothes();
    	WomenClothes.openPage(WomenClothes.pageURL);
    	Thread.sleep(2000);
    	//WHEN
    	WomenClothes.filterByColor(WomenClothes.colorBeigeSelector);
    }

    @After
    public void stutDownDriver() {
        //driver.close();
    }
}