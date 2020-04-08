package tests;
import java.util.List;

import org.testng.annotations.Test;

import lib.Common;
import lib.UserSearch;;

public class ToUserSearch
{
	@Test(groups={"User"}, dependsOnGroups={"login"}, alwaysRun=true)
	public void addUser()
	{
		List<String> testdata = Common.getTestData("ToSearchUser.searchingUser");
		String Username = testdata.get(0);
		String EmpName = testdata.get(1);
		UserSearch.addingUser(Username,EmpName);
		System.out.println("5");
		
	}
}

