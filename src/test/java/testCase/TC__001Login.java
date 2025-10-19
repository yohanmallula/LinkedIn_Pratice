package testCase;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.producrs;
import testBase.Baseclass;



public class TC__001Login extends Baseclass {
	
	@Test( groups = {"sanatry"})
	public void login() {

		producrs po = new producrs(driver);
		po.email();
		po.button();
		po.firstname();
		po.lastname();
		po.address();
		po.emailaddres();
		po.phone();
		po.Male();
		po.Hobbies();
		po.movies();
		po.language();
		po.pagescrool();
		po.Arbaic();
		po.Skills();
		po.getsourceCode();
		po.country();
		po.year();
		po.month();
		po.Day();
		po.password();
		po.cPassword();
		//po.submit1();
		po.upoloadFile();

	}

}
