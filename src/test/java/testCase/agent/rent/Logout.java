package testCase.agent.rent;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common.operation.BaseOperation;

public class Logout {
	
	WebDriver driver = Login.driver;
	
	@Test
	public void logout(){
		System.out.println("logout");
		BaseOperation.logout(driver);
	}

}
