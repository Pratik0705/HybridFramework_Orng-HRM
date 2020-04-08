package tests;
import org.testng.annotations.Test;

import lib.Job_PayGrades;

public class ToJob_PayGrades 
{
	@Test(groups={"Jobs"}, dependsOnGroups={"User"}, priority=2, alwaysRun=true, enabled=false)
//	@Test(groups={"Jobs"}, dependsOnGroups={"User"}, alwaysRun=true)
	public static void jobP()
	{
		Job_PayGrades.jobPay();

	}
}