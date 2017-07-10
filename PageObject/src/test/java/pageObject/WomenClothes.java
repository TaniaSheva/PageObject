package pageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class WomenClothes extends Page {

public String pageURL = "http://automationpractice.com/index.php?id_category=3&controller=category";	
public String sortingOptionDropdownSelectorID = "selectProductSort";
private String PriceAscSortingOptionID = ".//*[@id='selectProductSort']/option[2]";
private String productListSelector = ".//*[@id='center_column']/ul[@class='product_list grid row']/li";

public void changeSortingOption (){
	WebElement SortingDropdown = driver.findElement(By.id(sortingOptionDropdownSelectorID));
	SortingDropdown.click();
	WebElement PriceAscSortingOption = driver.findElement(By.xpath(PriceAscSortingOptionID));
	PriceAscSortingOption.click();
}

public ArrayList<Double> getItemsPrices () {
	
	List<WebElement> ItemsList = driver.findElements(By.xpath(productListSelector));
	ArrayList<Double> prices = new ArrayList<Double>();
	Pattern pattern = Pattern.compile("[0-9]{1,}[.][0-9]{1,}");
	
	
	for (int i = 1; i <= ItemsList.size(); i++) {
		String unformattedPrice = driver.findElement(By.xpath(".//*[@id='center_column']/ul/li[" + i + "]/div/div[1]/div/div[2]/span[1]")).getAttribute("innerText");
		Matcher matcher = pattern.matcher(unformattedPrice);
		if (matcher.find()) {
			prices.add(Double.parseDouble(matcher.group(0)));
		}
		
	}
	return prices;
	
}

public boolean arePricesLowestFirst () {
	List<Double> prices = this.getItemsPrices();
	double currentItem = prices.get(0);
	for (int i=1; i< prices.size(); i++) {
		if (prices.get(i)<currentItem) {
			return false;
		}
		else
		{
			currentItem = prices.get(i);
		}
	}
	return true;
}
}


