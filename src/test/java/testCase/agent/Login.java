package testCase.agent;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import common.data.Agent_Rent_GetData;
import common.operation.BaseOperation;

public class Login {
	
	public static WebDriver driver = BaseOperation.getDriver();
	
	@BeforeSuite
	public void before(){	
		System.out.println("suite before");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="login_success",dataProviderClass = Agent_Rent_GetData.class)
	public void login_success(String caseName,Map<String, String> map) throws InterruptedException{
		BaseOperation.login(driver,"https://agent.izhiliao.com/agent/login",map.get("username"), map.get("password"));
		Thread.sleep(2000);//等待登录成功
		System.out.println("login_success");
	}

	@AfterSuite
	public void after(){
		System.out.println("suite after");
		driver.close();
	}

}
