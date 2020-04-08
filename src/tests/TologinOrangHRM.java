package tests;

import java.util.List;

import lib.Common;
import lib.loginOrangHRM;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TologinOrangHRM 
{
	@BeforeMethod
	public void setup()
	{	
		Common.goToBaseUrl();
		System.out.println("1");
	}

	@Test(groups={"login"},priority = 1)
	public void Login()
	{		
		System.out.println("2");
		List<String> testData = Common.getTestData("loginOrangHRM.Login");
		System.out.println("p");
		String Uname = testData.get(0);
		String pwd = testData.get(1);
		System.out.println("3");
		loginOrangHRM.LoginCredentials(Uname,pwd);
		//				Assert.assertTrue(currentSelection.equals(name), "Expected conection name " +name+ " not displayed in connections list");
	}
}

