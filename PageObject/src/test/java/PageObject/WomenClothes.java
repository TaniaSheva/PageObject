package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WomenClothes extends Page {
	
public String pageURL = "http://automationpractice.com/index.php?id_category=3&controller=category";
private String sortingOptionDropdownSelectorID = "selectProductSort";
private String PriceAscSortingOptionID = ".//*[@id='selectProductSort']/option[2]";

public void changeSortingOption (){
	WebElement SortingDropdown = driver.findElement(By.id(sortingOptionDropdownSelectorID));
	SortingDropdown.click();
	WebElement PriceAscSortingOption = driver.findElement(By.id(PriceAscSortingOptionID));
	PriceAscSortingOption.click();
}

}
