package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BroswerUtility;

public class SearchPage extends BroswerUtility {

	private static final By PRODUCT_LISTING_HEADING_NAME_LOACTOR=By.xpath("//span[@class='lighter']");
	private static final By ALL_PRODUCT__NAME_LOACTOR=By.xpath("//h5[@itemprop='name']/a");
	//h5[@itemprop='name']/a
	//h5[@itemprop='name']/a[@title='Printed Summer Dress']
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	public String getProductHeadingTitle()
	{
		return getVisibilityText1(PRODUCT_LISTING_HEADING_NAME_LOACTOR);
	}
	public boolean IsSearchTermProductNamePresent(String searchTermProductName)
	
	{
		   //1.PRINTED SUMMER DRESS-> split the SearchNameText
		   List<String>Keywords =Arrays.asList( searchTermProductName.toLowerCase().split(searchTermProductName));
		    List<String>productNameList=getAllVisibilityText(ALL_PRODUCT__NAME_LOACTOR);
		    boolean result = false;
		    // Loop through each product name
		    for (String name : productNameList)
		    {
		        String productNameLower = name.toLowerCase();
		        // Loop through each keyword
		        for (String keyword : Keywords)
		        {
		            if (productNameLower.contains(keyword))
		            {
		                result = true;
		                break;   // keyword found
		            }
		        }
		        if (result)
		        {
		            break;   // product match found
		        }
		    }
		    return result;
		   /* boolean result=productNameList.stream().anyMatch(name->(Keywords.stream().anyMatch(name.toLowerCase()::contains)));
		    return result;*/
	}
	public ProductDetailPage clickOnTheProductAt(int index) {
		//ProductDetailPage productcheckoutpage=null;
		 WebElement element=getAllElements(ALL_PRODUCT__NAME_LOACTOR).get(index);
		 element.click();
		 return new ProductDetailPage(getDriver());
	}
	

}
