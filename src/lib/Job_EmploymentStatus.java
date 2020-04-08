package lib;

public class Job_EmploymentStatus extends Common
{
	public static void employmnt()
	{
		clickById("HOMEOAGE_ADMIN_MENU_ID");
		mouseHover("ADMIN_JOBS_XPATH");
		clickByXpath("ADMIN_JOBS_EMPLOYMNT_STSTUS_XPATH");
				
	}

}
