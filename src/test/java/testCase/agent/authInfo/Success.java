package testCase.agent.authInfo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.data.Agent_AuthInfo_GetData;
import page.agent.AgentAuthInfo;
import testCase.agent.Login;

public class Success {

	WebDriver driver = Login.driver;
	
	@Test(dataProvider="success",dataProviderClass = Agent_AuthInfo_GetData.class)
	public void success(String caseName,Map<String, String> map){
		String message = AgentAuthInfo.authInfo(driver, map);
		Assert.assertEquals(message, map.get("message"));
	}
}
