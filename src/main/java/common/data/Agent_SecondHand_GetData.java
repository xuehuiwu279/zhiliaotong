package common.data;

import org.testng.annotations.DataProvider;

public class Agent_SecondHand_GetData {
	
	/**
	 * 获取登录账号和密码
	 */
	@DataProvider(name="login_success")
	public static Object[][] login_success(){
		Object[][] objects = GetXML.getXML("src\\test\\java\\testCase\\testData\\agent_scondHand.xml", "login_success");
		return objects;
	}
	
	
	/**
	 * 获取发布二手房成功测试数据
	 */
	@DataProvider(name = "success")
	public static Object[][] success(){
		Object[][] objects = GetXML.getXML("src\\test\\java\\testCase\\testData\\agent_scondHand.xml","success");
		return objects;
	}
	
	/**
	 * 获取发布二手房失败测试数据--房源标题太短
	 */
	@DataProvider(name="sourceTitleTooShort")
	public static Object[][] sourceTitletooShort(){
		Object[][] objects = GetXML.getXML("src\\test\\java\\testCase\\testData\\agent_scondHand.xml", "sourceTitleTooShort");
		return objects;
	}
}
