package scenario_Component;

import java.io.IOException;

import org.testng.annotations.Test;

import generic_Component.BaseClass;
import pageObject_Component.PageObject_Login;

public class Scenario_Login extends BaseClass {
	
	@Test(dataProvider="dp_InvalidLogin",dataProviderClass=dataProvider_Component.DataProvider_Login.class)
	public void TestInValidLogin(String TCID, String Order,String Uname, String Pwd, String Exp_Res) throws IOException
	{
		InitializeBrowser();
		PageObject_Login lpob= new PageObject_Login(driver);
		lpob.Click_Sigin();
		lpob.Enter_Username(Uname);
		lpob.Enter_Password(Pwd);
		lpob.Click_Login();
		String Actual_Res = lpob.getInvalidmsg();
		
		if(Actual_Res.equals(Exp_Res))
		{
			System.out.println(TCID +  "  Passed ");
		}
		else
		{
			System.out.println(TCID + "Fail");
		}
		
		
		teardown();
		
		
		
		
	}

}