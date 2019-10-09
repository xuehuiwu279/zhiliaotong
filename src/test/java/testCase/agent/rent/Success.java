package testCase.agent.rent;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.data.Agent_Rent_GetData;
import common.operation.BaseJudge;
import page.agent.AgentRent_Add;
import testCase.agent.Login;

public class Success {
	
	WebDriver driver = Login.driver;
	
	@Test(dataProvider="success",dataProviderClass = Agent_Rent_GetData.class)
	public void rent_success(String caseName,Map<String,String> map){
		String message = AgentRent_Add.rent_add(driver, map);
		Assert.assertEquals(map.get("hopeMessage"), message);
		Boolean viewOrNot = BaseJudge.viewOrNot_rent(map.get("sourceTitle"));
		System.out.println("viewOrNot:" + viewOrNot.toString());
		System.out.println("hopeView:" + map.get("hopeView"));
		Assert.assertEquals(map.get("hopeView"), viewOrNot.toString());
		
		System.out.println("rent_success");
	}

}
