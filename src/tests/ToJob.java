package tests;
import org.testng.annotations.Test;

import lib.Job;

public class ToJob 
{
	@Test(groups={"Jobs"}, dependsOnGroups={"User"}, priority=1, alwaysRun=true, enabled=true)
//	@Test(groups={"Jobs"}, dependsOnGroups={"User"}, alwaysRun=true)
	public static void jobs()
	{
		Job.JobMenu();
	}
}
