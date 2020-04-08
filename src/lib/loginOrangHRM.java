package lib;

public class loginOrangHRM extends Common
{
	public static void LoginCredentials(String uname, String pwd)
	{		
		System.out.println("4");
		sendKeysById("LOGINPAGE_USERID_ID",uname);
		sendKeysById("LOGINPAGE_PWD_ID",pwd);
		highLighterXpath("LOGINPAGE_LOGIN_BTN_XPATH");
		clickByXpath("LOGINPAGE_LOGIN_BTN_XPATH");
	}
}


