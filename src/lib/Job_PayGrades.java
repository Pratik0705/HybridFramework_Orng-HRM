package lib;

public class Job_PayGrades extends Common
{
	public static void jobPay()
	{
		clickById("HOMEOAGE_ADMIN_MENU_ID");
		mouseHover("ADMIN_JOBS_XPATH");
		clickByXpath("ADMIN_JOBS_PAYGRADES_XPATH");
	}

}
