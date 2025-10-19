package testCase;

import org.testng.annotations.Test;

import pageObjects.SummerNote;
import pageObjects.producrs;
import testBase.Baseclass;

public class TC__004_SummerNote extends Baseclass {
	
	
	
	@Test
	public void SummaryNote() {
		
		producrs login = new producrs(driver);
		
		login.email();
		login.button();
		
		SummerNote sw = new SummerNote(driver);
		sw.SummaryNote11();
		sw.SummaryNote2();
		sw.NoteWriting();
		sw.CTRL_B();
		sw.Font_Style();
		
	}

}
