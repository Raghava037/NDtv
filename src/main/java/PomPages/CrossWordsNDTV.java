package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrossWordsNDTV 
{
	//Declaration
	@FindBy(xpath = "//img[@alt=\"NDTV News\"]")
	private WebElement NDTVlogo;
	@FindBy(xpath = "//*[@id=\"across\"]/li[4]")
	private WebElement A7;
	@FindBy(xpath = "(//span[@class=\"brw-nav_wrp\"])[2]")
	private WebElement Reveal; 
	@FindBy(xpath = "//a[@id=\"revealWord\"]")
	private WebElement Word;
	@FindBy(xpath = "(//span[@class=\"brw-nav_wrp\"])[1]")
	private WebElement Check;
	@FindBy(xpath = "//a[@id=\"checkPuzzle\"]")
	private WebElement Puzzle;
	@FindBy(xpath = "//*[@id=\"tim_pup\"]/div[2]")
	private WebElement pause;
	@FindBy(xpath = "//a[@id=\"onContinueGame\"]")
	private WebElement Continue;
	@FindBy(xpath = "//button[@id=\"resetDesk\"]")
	private WebElement Reset;

	//initialization
	public CrossWordsNDTV(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getNDTV(){
		return NDTVlogo;
	}
	public void A7(){
		A7.click();
	}
	public void reveal(){
		Reveal.click();
	}
	public void word(){
		Word.click();
	}
	public void Check(){
		Check.click();
	}
	public void puzzle(){
		Puzzle.click();
	}
	public void pause(){
		pause.click();
	}
	public void Continue() {
		Continue.click();
	}
	public void reset() {
		Reset.click();
	}
}
