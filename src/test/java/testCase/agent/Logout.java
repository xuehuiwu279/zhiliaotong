package testCase.agent;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common.operation.BaseOperation;
import testCase.agent.Login;

public class Logout {
	
	WebDriver driver = Login.driver;
	
	@Test
	public void logout(){
		BaseOperation.logout(driver);
		System.out.println("logout");
	}

}
