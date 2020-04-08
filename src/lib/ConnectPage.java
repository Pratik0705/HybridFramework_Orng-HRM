package lib;

public class ConnectPage extends Common{
	
	public static void enterConnectionSettings(String name, String scheme, String host, String port, String path){
		sendKeysByName("CONNECT_NAME_NAME", name);		
		selectByName("CONNECT_SCHEME_NAME", scheme);		
		sendKeysByName("CONNECT_HOST_NAME", host);
		sendKeysByName("CONNECT_PORT_NAME", port);
		sendKeysByName("CONNECT_PATH_NAME", path);		
	}
	
	public static void clickSave(){
		clickByXpath("CONNECT_SAVE_XPATH");
	}
	
	public static String getSelectedConnection(){
		String selectedOption = getSelecedValuetByXpath("CONNECT_CONNECTIONS_XPATH");
		return selectedOption;
	}	
}