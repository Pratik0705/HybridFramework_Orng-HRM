package tests;
import org.testng.annotations.Test;
import lib.Common;
import lib.Job_Categories;

public class ToJob_Categories extends Common
{
	@Test(groups={"Jobs"}, dependsOnGroups={"User"}, priority=4, alwaysRun=true)
	public static void categ()
	{
		boolean b = Job_Categories.category();
		
		if (b==true)
		{
			
		}
		else
		{
			
		}
	}

}
