package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Framework Demo: Library for common APIs 
 * 
 * @author 
 *
 */

public class Common {	

	private static Properties objectMapProps;
	private static XSSFSheet sheet;
	public static WebDriver driver;
	private static String baseUrl;

	public static void sleep(int millSec){
		try {
			Thread.sleep(millSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void highLighterXpath(String xpath){
		WebElement ele = driver.findElement(By.xpath(getObjectValue(xpath)));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: ; border: 2px solid red;');", ele);
	}


	public static void launchBrowser(String browser, String profile){
		FirefoxBinary bin = new FirefoxBinary(new File(browser));
		FirefoxProfile pro = new FirefoxProfile(new File(profile));

		driver = new FirefoxDriver(bin, pro);		
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver(){
		return driver;
	}

	public static void launchUrl(String url){
		driver.get(url);
		baseUrl = url;
	}	

	public static void setTimeOuts(int pageLoadTimeOutInSec, int implicitWaitInSec){
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOutInSec, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitWaitInSec, TimeUnit.SECONDS);
	}

	public static void switchToDefaultContent(){
		driver.switchTo().defaultContent();
	}

	public static void switchToFrame(String id){
		driver.switchTo().frame(getObjectValue(id));
	}

	public static void quit(){		
		driver.quit();
	}

	public static void setObjectMapFile(String configFilePath){
		objectMapProps = new Properties();
		InputStream fis;
		try {
			fis = new FileInputStream(configFilePath);
			objectMapProps.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getObjectValue(String objectName){
		return objectMapProps.getProperty(objectName);
	}

	public static void setTestDataFile(String testDataFilePath){

		try {			
			XSSFWorkbook workbook = new XSSFWorkbook (testDataFilePath);		
			sheet = workbook.getSheetAt(0);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
//			Common.captureScreenshot("");
		}
	}	

	public static ArrayList<String> getTestData(String testCaseName){
		ArrayList<String> testData = new ArrayList<String>();

		Iterator<Row> ite = sheet.rowIterator();
		while(ite.hasNext()){
			Row row = ite.next();
			Iterator<Cell> cite = row.cellIterator();
			while(cite.hasNext()){
				Cell c = cite.next();
				testData.add(c.toString());
			}
			if(testData.get(0).equals(testCaseName)){
				testData.remove(testCaseName);
				return testData;		
			}
			testData = null;
			testData = new ArrayList<String>();
		}
		return testData;
	}	

	public static void captureScreenshot(String screenshotFilePath){
		try {
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(screenshotFilePath));
			System.out.println("Saved screenshot: " + screenshotFilePath);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("Failed to capture screenshot to file : "
					+ screenshotFilePath);
			npe.printStackTrace();
		}
	}

	public static void goToBaseUrl(){
		if(!driver.getCurrentUrl().equals(baseUrl))
			driver.get(baseUrl);
	}

	// Click
	public static void clickById(String id){
		driver.findElement(By.id(getObjectValue(id))).click();		
	}

	public static void clickByXpath(String xpath){
		driver.findElement(By.xpath(getObjectValue(xpath))).click();		
	}

	public static void clickByLinkText(String linkText){
		driver.findElement(By.linkText(getObjectValue(linkText))).click();		
	}

	// sendKeys
	public static void sendKeysByXpath(String xpath, String value){
		WebElement ele = driver.findElement(By.xpath(getObjectValue(xpath)));
		ele.clear();
		ele.sendKeys(value);
	}

	public static void sendKeysById(String id, String value){
		WebElement ele = driver.findElement(By.id(getObjectValue(id)));
		ele.clear();
		ele.sendKeys(value);
	}

	public static void sendKeysByName(String name, String value){
		WebElement ele = driver.findElement(By.name(getObjectValue(name)));
		ele.clear();
		ele.sendKeys(value);
	}

	// Select
	public static void selectByXpath(String xpath, String value){
		WebElement ele = driver.findElement(By.xpath(getObjectValue(xpath)));
		Select listBox = new Select(ele);
		listBox.selectByVisibleText(value);
	}

	public static void selectByName(String name, String value){
		WebElement ele = driver.findElement(By.name(getObjectValue(name)));
		Select listBox = new Select(ele);
		listBox.selectByVisibleText(value);
	}

	public static String getSelecedValuetByXpath(String xpath){
		WebElement ele = driver.findElement(By.xpath(getObjectValue(xpath)));
		Select listBox = new Select(ele);
		WebElement selectedEle = listBox.getFirstSelectedOption();
		return selectedEle.getText();
	}

	// Verification
	public static boolean isElementPresent(String xpath){
		List<WebElement> eles = driver.findElements(By.xpath(getObjectValue(xpath)));
		boolean isPresent = eles.size() > 0;
		return isPresent;
	}

	public static void mouseHover(String Xpath)
	{		
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(getObjectValue(Xpath)));
		act.moveToElement(ele).build().perform();
	}

	public static void selectDropDown(String AllElementsXpath, String SingleElement)
	{
		List<WebElement> test = driver.findElements(By.xpath(AllElementsXpath));
		String st = SingleElement;

		for(WebElement tt : test)
		{
			String ss = tt.getText();
			if(st.equals(ss))
			{
				tt.click();
			}
		}


	}
}








