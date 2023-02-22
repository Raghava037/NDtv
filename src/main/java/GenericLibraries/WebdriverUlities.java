package GenericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUlities 
{
	WebDriver driver;
	
	public WebDriver opeanApplication(String browser, long time,String url )
	{

		switch (browser) 
		{
			case "chrome": driver=new ChromeDriver();break;
			case "edge": driver=new EdgeDriver();break;
			case "firefox": driver=new FirefoxDriver();break;
		default:
			System.out.println("Invalid Browser data");
			break;
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		return driver;
	}
	
	public void MouseHover(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void DoubleClick(WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	public void DragandDropElement(WebElement src, WebElement dsy)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(src, dsy).perform();
	}
	public void RightClickElement(WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();		
	}
	public void Dropdown(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void Dropdown(WebElement element, String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void Dropdown( String Text, WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(Text);
	}
	public void SwitchFrame()
	{
		driver.switchTo().frame(0);
	}
	public void SwitchFrameBack()
	{
		driver.switchTo().defaultContent();
	}
	public void handleAlert()
	{
		driver.switchTo().alert().accept();
	}
	public void handleChildBrowser()
	{
		Set<String> windowIDE=driver.getWindowHandles();
		for (String string : windowIDE) 
		{
			driver.switchTo().window(string);
		}
	}
	public void handleToParentWindow()
	{
		driver.switchTo().window(driver.getWindowHandle());
	}
	public void ScrollToElement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public void takeScreenshort()
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshort/picture.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ExplicitWait(long time, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void closecurrentwindow()
	{
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
}
