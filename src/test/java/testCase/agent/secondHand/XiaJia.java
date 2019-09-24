package testCase.agent.secondHand;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import page.agent.AgentSecondHand_xiajia;
import testCase.agent.Login;

public class XiaJia {
	
	WebDriver driver = Login.driver;
	
	@Test
	public void secondHand_xiajia(){
		AgentSecondHand_xiajia.secondHand_xiajia_free(driver);
		System.out.println("secondHand_xiajia");
	}

}
