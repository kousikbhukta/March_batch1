package generic_Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass1 {
	
	public WebDriver driver;
	Utility_Class c1= new Utility_Class();
	static Logger log= Logger.getLogger(BaseClass1.class);
	
	public void InitializeBrowser() throws IOException
	{
		String browser_type = c1.reading_properties("btype");
		
		if(browser_type.equals("ff"))
		{
		driver= new FirefoxDriver();
		}
		
		else if(browser_type.equals("ch"))
		{
			
		System.setProperty("webdriver.chrome.driver",c1.reading_properties("Chrome_Path"));
		driver= new ChromeDriver();
		}
		
		else if(browser_type.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",c1.reading_properties("IE_Path"));
			driver= new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(c1.reading_properties("URL"));
		
		log.info("Successfully initialized the browser");
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
	}
	
	
	public void teardown()
	{
		driver.quit();
		log.info("Successfully closed the Browser");
	}
	

	public void Snapshot(String TCID, String Order) throws IOException
	{
		Date date= new Date();
		SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		File file= new File(dateformat.format(date) +".png");
		
		
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshotAs, new File("F:\\20.02.16\\Selenium world\\Screenshot\\" +TCID+"-"+Order+"-"+file));
		
	}
	
}
