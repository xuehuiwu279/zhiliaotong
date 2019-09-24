package testCase.agent.secondHand;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.data.Agent_SecondHand_GetData;
import common.operation.BaseJudge;
import page.agent.AgentSecondHand_Add;
import testCase.agent.Login;

public class Success {
	
	WebDriver driver = Login.driver;
	
	@Test(dataProvider="success",dataProviderClass = Agent_SecondHand_GetData.class)
	public void secondHand_success(String caseName,Map<String, String> map){
		String re = AgentSecondHand_Add.secondHand_add(driver,map);
		Assert.assertEquals(map.get("hopeMessage"),re);//校验发布后弹窗信息
		//校验C端展示
		Boolean vi = BaseJudge.viewOrNot_secondHand(map.get("sourceTitle"));
		Assert.assertEquals(map.get("hopeView"), vi.toString());
		System.out.println("secondHand_success");
	}
}
