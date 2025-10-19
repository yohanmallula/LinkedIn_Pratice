package testCase;

import org.testng.annotations.Test;

import pageObjects.Alert_Frames;
import pageObjects.producrs;
import testBase.Baseclass;

public class Alert_Frames__002  extends Baseclass {
	
	
	
	@Test()
	public void alert() {
		
		
		producrs al =  new producrs(driver); 
		 
		al.email();
		al.button();
		
	
		
		Alert_Frames all = new Alert_Frames(driver);
		all.Switchto();
		all.Alert();
		//all.Alert_With_OK();
		//all.OK_Cancel();
		//all.Ok_Cancel2();
		
		all.alert_Class_GetText();
		all.alert_With_Text();
		//all.OK_Cancel();
		all.alert3();
		all.alert4();
		
		
	}


}
