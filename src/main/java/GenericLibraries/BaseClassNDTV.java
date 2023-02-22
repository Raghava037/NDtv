package GenericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomPages.CrossWordsNDTV;
import PomPages.Homepage;

public class BaseClassNDTV 
{
	protected PropertiesFileUtility property;
	protected ExcelUtility excel;
	protected WebdriverUlities web;
	protected WebDriver driver;
	protected Homepage home;
	protected CrossWordsNDTV crossword;
	protected long time;
	
	@BeforeClass
	public void ClassConfiguration()
	{
		property=new PropertiesFileUtility();
		excel=new ExcelUtility();
		web=new WebdriverUlities();
		
		property.propertiesFileInitialization(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
	}
	
	@BeforeMethod
	public void methodConfiguration()
	{
		time=Long.parseLong(property.featchproperties("timeouts"));
		driver=web.opeanApplication(property.featchproperties("browser"), time,property.featchproperties("url"));
		
		home=new Homepage(driver);
		
		Assert.assertTrue(home.getLogo().isDisplayed());
		
		crossword=new CrossWordsNDTV(driver);
		
		
		
	}
	@AfterMethod
	public void methodTearDown()
	{
		web.quitBrowser();
	}
	@AfterClass
	public void classTearDown()
	{
		excel.closeExcel();
	}
	
}
