package scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import generic_Component.BaseClass1;
import pageObject_Component.PageObject_Search;

public class Scenario_Booksearch extends BaseClass1 {
	
	static Logger log= Logger.getLogger(Scenario_Booksearch.class);
	
	@Test(dataProvider="dp_Invalidsearch",dataProviderClass=dataProvider_Component.DataProvider_Search.class,groups={"regression"})
	public void TestInvalidsearch(String TCID, String Order, String Search_Item, String Exp_Res) throws IOException
	{
		InitializeBrowser();
		PageObject_Search BS_pob= new PageObject_Search(driver);
		BS_pob.Commonprocess_Search(Search_Item);
		String Actual_Res = BS_pob.getInvalidmsg();
		
		if(Actual_Res.equals(Exp_Res))
		{
			log.info("Passed as Exp msg"+Exp_Res +  "Actual msg  was " +Actual_Res);
		}
		else
		{
			
			log.info("Failed as Exp ms was " +Exp_Res + " Actual msg is  " +Actual_Res);
		}
		
		teardown();
		
	}
	
		@Test(dataProvider="dp_validsearch",dataProviderClass=dataProvider_Component.DataProvider_Search.class, groups={"smoke"})
		public void Testvalidsearch(String TCID, String Order, String Search_Item, String Exp_Res) throws IOException
		{
			InitializeBrowser();
			PageObject_Search BS_pob= new PageObject_Search(driver);
			BS_pob.Commonprocess_Search(Search_Item);
			String Actual_Res = BS_pob.getValidmsg();
			
			if(Actual_Res.equals(Exp_Res))
			{
				log.info("Passed as Exp msg"+Exp_Res +  "Actual msg  was " +Actual_Res);
			}
			else
			{
				
				log.info("Failed as Exp ms was " +Exp_Res + " Actual msg is  " +Actual_Res);
			}
			
			teardown();
		
		
		
		
	}

}
