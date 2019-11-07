package testCase.agent;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;

public class test4 {

	@Test
	public void test4_01() {
		int[] arr = new int[3];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("请输入第" + (i + 1) + "个你想输入的值：");
			Integer integer = Integer.valueOf(scanner.next());
			arr[i] = integer;
		}
		Arrays.sort(arr);
		double sum = 0;
		for (int j : arr) {
			sum += j;
		}
		System.out.println("数组求和为：" + sum);
	}

	@Test
	public void test4_02() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String string = String.valueOf(scanner.next());
		String[] strings = string.split("");
		String string2 = "";
		for (int i = strings.length - 1; i >= 0; i--) {
			string2 += strings[i];
		}
		System.out.println("倒序后：" + string2);
	}

	@Test
	public void test4_03() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String string = String.valueOf(scanner.next());
		String string2 = "";
		for (int i = string.length(); i > 0; i--) {
			string2 += string.substring(i - 1, i);
		}
		System.out.println("倒序后：" + string2);
	}

	@Test
	public void test5() {
		String string = "abcdef";
		System.out.println(string.substring(1, 1));
	}

	public String api_post(String url,String jsonObject) {	
		String resultString = "";
		CloseableHttpResponse httpResponse = null;
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			StringEntity entity = new StringEntity(jsonObject);
			httpPost.setEntity(entity);
			httpResponse = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				httpResponse.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultString;
	}
	
	public void ttt(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("siteId", "3066");
		api_post("http://172.17.3.237:8084/house/api/list",jsonObject.toString());
	}

}
