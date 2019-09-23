package testCase.agent.secondHand;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.data.Agent_SecondHand_GetData;
import common.operation.BaseOperation;
import page.agent.AgentSecondHand_Add;

public class SourceTitleTooShort {
	
WebDriver driver = BaseOperation.getDriver();
	
	
	@BeforeTest
	public void before() throws InterruptedException{		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="login_success",dataProviderClass = Agent_SecondHand_GetData.class)
	public void login_success(String caseName,Map<String, String> map) throws InterruptedException{
		BaseOperation.login(driver,"https://agent.izhiliao.com/agent/login",map.get("username"), map.get("password"));
		Thread.sleep(3000);//等待登录成功
	}
	
	@Test(dataProvider="sourceTitleTooShort",dataProviderClass = Agent_SecondHand_GetData.class)
	public void sourceTitleTooShort(String caseName,Map<String, String> map){
		String message = AgentSecondHand_Add.secondHand_add(driver, map);
		Assert.assertEquals(map.get("hopeMessage"), message);
	}

	@AfterTest
	public void after() throws InterruptedException{
		Thread.sleep(1000);
		driver.close();
	}


}
