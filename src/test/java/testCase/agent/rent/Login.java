package testCase.agent.rent;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import common.data.Agent_Rent_GetData;
import common.operation.BaseOperation;
import page.agent.AgentRent_xiajia;

public class Login {
	
	public static WebDriver driver = BaseOperation.getDriver();
	
	@BeforeSuite
	public void before(){	
		System.out.println("login before");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="login_success",dataProviderClass = Agent_Rent_GetData.class)
	public void login_success(String caseName,Map<String, String> map) throws InterruptedException{
		System.out.println("login test");
		BaseOperation.login(driver,"https://agent.izhiliao.com/agent/login",map.get("username"), map.get("password"));
		Thread.sleep(2000);//等待登录成功
	}

	@AfterSuite
	public void after(){
		System.out.println("login after");
		AgentRent_xiajia.rent_xiajia_free(driver);
		BaseOperation.logout(driver);
		driver.close();
	}

}
