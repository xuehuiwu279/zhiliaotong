package testCase.agent.rent;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import page.agent.AgentRent_xiajia;

public class XiaJia {

	WebDriver driver = Login.driver;
	
	@Test()
	public void success(){
		System.out.println("xiajia");
		AgentRent_xiajia.rent_xiajia_free(driver);
	}
}
