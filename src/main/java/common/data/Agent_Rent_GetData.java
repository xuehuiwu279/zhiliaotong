package common.data;

import org.testng.annotations.DataProvider;

public class Agent_Rent_GetData {
	
	public static String rentXML_addr = "src\\test\\java\\testCase\\testData\\agent_rent.xml";
	
	/**
	 * 获取登录用户账号及密码
	 */
	@DataProvider(name="login_success")
	public static Object[][] login_success(){
		Object[][] objects = GetXML.getXML(rentXML_addr,"login_success");
		return objects;
	}
	
	/**
	 * 获取发布租房成功用例数据
	 * @return
	 */
	@DataProvider(name = "success")
	public static Object[][] success(){
		Object[][] objects = GetXML.getXML(rentXML_addr,"success");
		return objects;
	}
	
	/**
	 * 获取发布租房失败用例数据--房源标题太短
	 */
	@DataProvider(name="sourceTitleTooShort")
	public static Object[][] sourceTitletooShort(){
		Object[][] objects = GetXML.getXML(rentXML_addr, "sourceTitleTooShort");
		return objects;
	}

}
