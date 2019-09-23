package testCase.agent.secondHand;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.data.Agent_SecondHand_GetData;
import common.operation.BaseJudge;
import common.operation.BaseOperation;
import page.agent.AgentSecondHand_Add;
import page.agent.AgentSecondHand_xiajia;

public class Success {
	
	WebDriver driver = BaseOperation.getDriver();
	
	@BeforeTest
	public void before(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="login_success",dataProviderClass = Agent_SecondHand_GetData.class)
	public void login_success(String caseName,Map<String, String> map) throws InterruptedException{
		BaseOperation.login(driver, "https://agent.izhiliao.com/agent/login", map.get("username"), map.get("password"));
		Thread.sleep(2000);//等待登录成功
	}
	
	@Test(dataProvider="success",dataProviderClass = Agent_SecondHand_GetData.class)
	public void success(String caseName,Map<String, String> map){
		String re = AgentSecondHand_Add.secondHand_add(driver,map);
		Assert.assertEquals(map.get("hopeMessage"),re);//校验发布后弹窗信息
		//校验C端展示
		Boolean vi = BaseJudge.viewOrNot_secondHand(map.get("sourceTitle"));
		Assert.assertEquals(map.get("hopeView"), vi.toString());
	}
	
	@AfterTest
	public void after() throws InterruptedException{
		AgentSecondHand_xiajia.secondHand_xiajia_free(driver);
		Thread.sleep(2000);
		driver.close();
	}

}
