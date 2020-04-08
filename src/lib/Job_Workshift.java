package lib;

public class Job_Workshift extends Common
{
	public static void workshift()
	{
		System.out.println("p1");
		clickById("HOMEOAGE_ADMIN_MENU_ID");
		mouseHover("ADMIN_JOBS_XPATH");
		System.out.println("p2");
		highLighterXpath("ADMIN_JOBS_WORKSHIFT_XPATH");
		System.out.println("p3");
		clickByXpath("ADMIN_JOBS_WORKSHIFT_XPATH");
		System.out.println("p4");
		
	}

}
