package pageObject_Component;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Login {
	
	public WebDriver driver;
	
	//storage of the elements
	@FindBy(css="html body div#homewrapper.homewrapper div.userinfo.floatR span span#signin_info a")
	WebElement lnk_Sigin;
	
	@FindBy(name="login")
	WebElement txt_Username;
	
	@FindBy(name="passwd")
	WebElement txt_Password;
	
	@FindBy(name="proceed")
	WebElement btn_Login;
	
	@FindBy(css="html body form div#login div.center-content div.text-container div.heading div")
	WebElement msg_Invalid;
	
	
	public PageObject_Login(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void Click_Sigin()
	{
		
		lnk_Sigin.click();
		
	}
	
	public void Enter_Username(String Value)
	{
		txt_Username.sendKeys(Value);
		
	}
	
	
	public void Enter_Password(String Value)
	{
		txt_Password.sendKeys(Value);
		
	}
	
	public void Click_Login()
	{
		
		btn_Login.click();
		
	}
	
	public String getInvalidmsg()
	{
		return msg_Invalid.getText();
		
	}
}