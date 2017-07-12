package pageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WomenClothes extends Page {

public String pageURL = "http://automationpractice.com/index.php?id_category=3&controller=category";	
private String sortingOptionDropdownSelectorID = "selectProductSort";
private String PriceAscSortingOptionID = ".//*[@id='selectProductSort']/option[2]";
private String productListSelector = ".//*[@id='center_column']/ul[@class='product_list grid row']/li";

//URL
public String colorBeigeURL = "http://automationpractice.com/index.php?id_category=3&controller=category#/color-beige";
public String colorOrangeURL = "http://automationpractice.com/index.php?id_category=3&controller=category#/color-orange";

//LABELS
public String colorBeigeSelector = ".//*[@id='ul_layered_id_attribute_group_3']/li[1]/label/a/span";
public String colorOrangeSelector = ".//*[@id='ul_layered_id_attribute_group_3']/li[4]/label/a/span";



public void changeSortingOption (){
	WebElement SortingDropdown = driver.findElement(By.id(sortingOptionDropdownSelectorID));
	SortingDropdown.click();
	WebElement PriceAscSortingOption = driver.findElement(By.xpath(PriceAscSortingOptionID));
	PriceAscSortingOption.click();
}

private ArrayList<Double> getItemsPrices () {
	
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

private void filterByColor (String colorURL) {
	openPage(colorURL);
	WebDriverWait wait = new WebDriverWait(driver, 5);
	
	wait.until(ExpectedConditions.attributeToBe(By.xpath(".//*[@id='center_column']/ul"), "style", "opacity: 1;")); 
	
}

public boolean isFilteredByColor (String colorURL, String colorLabelSelector) {
	filterByColor (colorURL);
	List<WebElement> ItemsList = driver.findElements(By.xpath(productListSelector));
	int itemsQuantity = ItemsList.size();
	WebElement colorLabel = driver.findElement(By.xpath(colorLabelSelector));
	Pattern pattern = Pattern.compile("[0-9]");
	Matcher matcher = pattern.matcher(colorLabel.getText());
	matcher.find();
	int labelItemsQuantity = Integer.parseInt(matcher.group(0));
		
		if (itemsQuantity == labelItemsQuantity ) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	
}




