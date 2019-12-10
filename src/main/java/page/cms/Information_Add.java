package page.cms;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import common.operation.BaseOperation;

public class Information_Add {
	
	public static String information_add(WebDriver driver ){
		driver.get("http://admin.house.ifeng.com/admin/login");
		BaseOperation.sleep(2000);
		driver.findElement(By.xpath("//span[text()='账号登录']")).click();
//		driver.manage().getCookies();
//		System.out.println(driver.manage().getCookies());
		
//		driver.add_cookie({'name':'Login_UserNumber', 'value':'username'});
//		driver.add_cookie({'name':'Login_Passwd', 'value':'password'});
//		driver.findElement(By.id("loginName")).sendKeys("tangyp@ifeng.com");
//		driver.findElement(By.id("loginPwd")).sendKeys("typ123456");
		
		return "";
	}
	
	@Test
	public void tt(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		information_add(driver);
		BaseOperation.sleep(3000);
		driver.close();
	}

}
