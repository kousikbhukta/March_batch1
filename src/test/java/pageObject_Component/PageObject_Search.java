package pageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Search {
	
	public WebDriver driver;
	
	@FindBy(id="srchword")
	WebElement txt_Search;
	
	@FindBy(className="newsrchbtn")
	WebElement btn_Search;
	
	@FindBy(css="html body div.wrapper div.boxcontainer div#home_page.wd100 div#fullbody div div.bgwhite div.grey1.f16.bold")
	WebElement msg_Invalidsearch;
	
	@FindBy(css="html body div.wrapper div.boxcontainer div#myDataDiv.wd100.hide div#fullbody div div.products_cont div.product_left_cont div#productresultsWrapper.productresultsWrapper div.top_search_text")
	WebElement msg_ValidSearch;
	
	
	
	
	public PageObject_Search(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void EnterSearch(String Value)
	{
		txt_Search.sendKeys(Value);
	}

	
	public void Click_Search()
	{
		btn_Search.click();
	}
	
	public String getInvalidmsg()
	{
		return msg_Invalidsearch.getText();
	}
	
	public String getValidmsg()
	{
		return msg_ValidSearch.getText();
	}
	
	
	///***************************8
	
	public void Commonprocess_Search(String Search_Item)
	{
		EnterSearch(Search_Item);
		Click_Search();
		
	}
	
}


