package tests;
import org.testng.annotations.Test;

import lib.Job_Workshift;
import lib.Common;

public class ToJob_Workshift extends Common
{
	@Test(groups={"jobs"}, dependsOnGroups={"User"}, priority=5, alwaysRun=true)
	public static void Wshifts()
	{
		Job_Workshift.workshift();
		
	}
}
