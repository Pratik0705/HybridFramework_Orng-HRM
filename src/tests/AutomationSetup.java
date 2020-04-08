package tests;

import lib.Common;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class AutomationSetup {

	@BeforeSuite
	@Parameters({"browser", "profile", "chromeDriver", "url", "objectMapFile", "testDataFile", "pageLoadTimeOutInSec", 
	"implicitWaitInSec"})
	public void setup(String browser, String profile, String chromeDriver, String url, String objectMapFile, 
			String testDataFile, String pageLoadTimeOutInSec, String implicitWaitInSec)
	{		
		Common.setTestDataFile(testDataFile);

		Common.setObjectMapFile(objectMapFile);		

		Common.launchBrowser(browser, profile);

		Common.setTimeOuts(Integer.parseInt(pageLoadTimeOutInSec), Integer.parseInt(implicitWaitInSec));

		Common.launchUrl(url);
	}
}
