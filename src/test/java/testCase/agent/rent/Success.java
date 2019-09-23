package testCase.agent.rent;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common.data.Agent_Rent_GetData;
import common.operation.BaseJudge;
import junit.framework.Assert;
import page.agent.AgentRent_Add;

public class Success {
	
	WebDriver driver = Login.driver;
	
	@Test(dataProvider="success",dataProviderClass = Agent_Rent_GetData.class)
	public void success(String caseName,Map<String,String> map){
		System.out.println("success");
		String message = AgentRent_Add.rent_add(driver, map);
		Assert.assertEquals(map.get("hopeMessage"), message);
		Boolean viewOrNot = BaseJudge.viewOrNot_rent(map.get("sourceTitle"));
		Assert.assertEquals(map.get("hopeView"), viewOrNot.toString());
	}

}
