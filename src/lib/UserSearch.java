package lib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserSearch extends Common
{
	public static void addingUser(String Username, String pwd)
	{
		System.out.println("6");
		clickById("HOMEOAGE_ADMIN_MENU_ID");
		clickByXpath("HOMEOAGE_ADMIN_MENU_USERMGMT_ID");
		highLighterXpath("ADMIN_MENU_USERMGMT_USER_ID");
		clickByXpath("ADMIN_MENU_USERMGMT_USER_ID");
		highLighterXpath("ADMIN_MENU_USERMGMT_ADDUSERBTN_XPATH");
		highLighterXpath("SEARCH_ADDED_USER_XPATH");
//		clickByXpath("SEARCH_ADDED_USER_XPATH");
		sendKeysByXpath("SEARCH_ADDED_USER_XPATH",Username);
		highLighterXpath("SEARCH_EMPNAME_XPATH");
		sendKeysByXpath("SEARCH_EMPNAME_XPATH",pwd);
		highLighterXpath("SEARCH_USERROLE_XPATH");
		clickByXpath("SEARCH_USERROLE_XPATH");
//		selectByXpath("SEARCH_USERROLE_COMMON_XPATH","Admin");
		String ESS="ESS";
//		selectDropDown("SEARCH_USERROLE_COMMON_XPATH",ESS);
		List<WebElement> test = driver.findElements(By.xpath("//select[@id='searchSystemUser_userType']/option"));
		for(WebElement tt : test)
		{
			String ss = tt.getText();
			if("Admin".equals(ss))
			{
				tt.click();
			}
		}
		
		
		
		
		
	}
}
