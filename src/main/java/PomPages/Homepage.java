package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage 
{
	//declaration
	@FindBy(xpath = "//img[contains(@src,'ndtvlogo22')]")
	private WebElement NDTVlogo;
	@FindBy(xpath = "//a[@class='notnow']")
	private WebElement Nothanks;
	@FindBy(xpath = "//a[@id='gavtab-11']")
	private WebElement crossword;
	@FindBy(xpath = "//a[@id='h_sub_menu']")
	private WebElement menu;
	@FindBy(xpath = "//a[text()='Trains ']")
	private WebElement Trains;
	@FindBy(xpath = "//a[text()='LIVE TV']")
	private WebElement LiveTv;
	
	//initialization
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getLogo()
	{
		return NDTVlogo;
	}
	public void ClickNOThanks()
	{
		Nothanks.click();
	}
	
	public void ClickCrossword()
	{
		crossword.click();
	}
	public void ClickMenu()
	{
		menu.click();
	}
	public void ClickTrains()
	{
		Trains.click();
	}
	public void ClickLivetv()
	{
		LiveTv.click();
	}
	
}
