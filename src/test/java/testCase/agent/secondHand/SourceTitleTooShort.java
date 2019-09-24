package testCase.agent.secondHand;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.data.Agent_SecondHand_GetData;
import page.agent.AgentSecondHand_Add;
import testCase.agent.Login;

public class SourceTitleTooShort {
	
	WebDriver driver = Login.driver;
	
	@Test(dataProvider="sourceTitleTooShort",dataProviderClass = Agent_SecondHand_GetData.class)
	public void secondHand_sourceTitleTooShort(String caseName,Map<String, String> map){
		String message = AgentSecondHand_Add.secondHand_add(driver, map);
		Assert.assertEquals(map.get("hopeMessage"), message);
		System.out.println("secondHand_sourceTitleTooShort");
	}

}
