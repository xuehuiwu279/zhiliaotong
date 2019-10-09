package common.data;

import org.testng.annotations.DataProvider;

public class Agent_AuthInfo_GetData {

	public static String authInfoXML_addr = "src\\test\\java\\testCase\\testData\\agent_authInfo.xml";
	
	/**
	 * 获取登录账号
	 * @return
	 */
	@DataProvider(name="login_success")
	public static Object[][] login_success(){
		Object[][] objects = GetXML.getXML(authInfoXML_addr, "login");
		return objects;
	}

	/**
	 * 认证成功数据
	 * @return
	 */
	@DataProvider(name="success")
	public static Object[][] success(){
		Object[][] objects = GetXML.getXML(authInfoXML_addr, "success");
		return objects;
	}
	
	/**
	 * 认证失败数据
	 * @return
	 */
	@DataProvider(name="nameInputNull")
	public static Object[][] nameInputNull(){
		Object[][] objects = GetXML.getXML(authInfoXML_addr, "nameInputNull");
		return objects;
	}
}
