package testCase.agent.rent;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import page.agent.AgentRent_xiajia;
import testCase.agent.Login;

public class XiaJia {

	WebDriver driver = Login.driver;
	
	@Test()
	public void rent_xiajia(){
		AgentRent_xiajia.rent_xiajia_free(driver);
		System.out.println("rent_xiajia");
	}
}
