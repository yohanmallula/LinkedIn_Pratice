package testCase;

import org.testng.annotations.Test;

import pageObjects.producrs;
import testBase.Baseclass;
import pageObjects.Widgets;

public class TC_003_Widgets extends Baseclass {
	
	
	@Test(enabled = false)
	public void Widgets() {
		
		producrs al =  new producrs(driver); 
		 
		al.email();
		al.button();
		
	
		Widgets wi = new Widgets(driver);
		
		wi.widget();
		wi.Accordion();
		wi.Accordion1();
		wi.Accordion4();
		wi.Accordion3();
		wi.Accordion2();
		//wi.Accordion1();
		
		wi.widget2();
		
		wi.slider();
		wi.sliderpoint();
	
	}
	
	
	@Test
	public void Widgets2() {
		
		producrs al =  new producrs(driver); 
		 
		al.email();
		al.button();
		
	
		Widgets wi = new Widgets(driver);
	wi.widget2();
		
		wi.slider();
		wi.sliderpoint();
		
	}
	
	
	
	
	

}
