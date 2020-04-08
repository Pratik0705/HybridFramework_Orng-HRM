package tests;
import org.testng.annotations.Test;

import lib.Job_EmploymentStatus;

public class ToJob_EmploymentStatus 
{
	@Test(groups={"Jobs"}, dependsOnGroups={"User"}, priority=3, alwaysRun=true, enabled=false)
	public static void emply()
	{
		Job_EmploymentStatus.employmnt();		
	}
}

