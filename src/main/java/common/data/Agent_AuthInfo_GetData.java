package common.data;

import org.testng.annotations.DataProvider;

public class Agent_AuthInfo_GetData {
//	public static void main(String[] args){
//		getXML_authInfo();
//	}

	@DataProvider(name="authInfo")
	public static Object[][] getXML_authInfo(){
		//获取认证测试数据
		Object[][] objects = GetXML.getXML("src\\test\\java\\testCase\\testData\\agent_authInfo.xml","authInfo");

		return objects;	
	}
	
}
