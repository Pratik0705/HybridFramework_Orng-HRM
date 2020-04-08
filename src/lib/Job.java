package lib;

public class Job extends Common
{
	public static void JobMenu()
	{
		System.out.println("7");
		clickById("HOMEOAGE_ADMIN_MENU_ID");
		mouseHover("ADMIN_JOBS_XPATH");
		clickByXpath("ADMIN_JOBS_JOBTITLES_XPATH");
		

	}

}
