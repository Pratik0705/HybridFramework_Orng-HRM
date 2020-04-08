package lib;

public class Job_Categories extends Common
{
	public static boolean category()
	{
		try{
		clickById("HOMEOAGE_ADMIN_MENU_ID");
		mouseHover("ADMIN_JOBS_XPATH");
		highLighterXpath("ADMIN_JOBS_CATEGORIES_XPATH");
		clickByXpath("ADMIN_JOBS_CATEGORIES_XPATH");
		highLighterXpath("ADMIN_JOBS_CATEGORIES_ADD_XPATH");
		clickByXpath("ADMIN_JOBS_CATEGORIES_ADD_XPATH");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Common.captureScreenshot("D:/selenium_Class/Fail_Screenshots");
			return false;
		}
		return true;
	}
}
