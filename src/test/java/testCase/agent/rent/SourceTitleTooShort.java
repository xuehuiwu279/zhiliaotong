package testCase.agent.rent;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.data.Agent_Rent_GetData;
import page.agent.AgentRent_Add;

public class SourceTitleTooShort {
	
	WebDriver driver = Login.driver;
	
	@Test(dataProvider="sourceTitleTooShort",dataProviderClass = Agent_Rent_GetData.class)
	public void sourceTitleTooShort(String caseName,Map<String, String> map){
		System.out.println("fail test");
		String message = AgentRent_Add.rent_add(driver, map);
		Assert.assertEquals(map.get("hopeMessage"), message);
	}

}
