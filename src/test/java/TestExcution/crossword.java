package TestExcution;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClassNDTV;

public class crossword extends BaseClassNDTV
{
	@Test
	
	public void Crossword() throws InterruptedException
	{
		SoftAssert soft=new SoftAssert();
		
		home.ClickNOThanks();
		home.ClickCrossword();
		web.handleChildBrowser();
		
		soft.assertTrue(crossword.getNDTV().isDisplayed());
		
		web.SwitchFrame();
		
		crossword.A7();
		Thread.sleep(500);
		crossword.reveal();
		Thread.sleep(500);
		crossword.word();
		Thread.sleep(500);
		crossword.Check();
		Thread.sleep(500);
		crossword.puzzle();
		Thread.sleep(500);
		crossword.pause();
		Thread.sleep(500);
		crossword.Continue();
		Thread.sleep(500);
		crossword.reset();
	}
}
