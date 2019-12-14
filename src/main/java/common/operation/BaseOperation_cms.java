package common.operation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseOperation_cms {
	
	public static void login(WebDriver driver,String url,String username,String password){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("//span[text()='账号登录']")).click();
		driver.findElement(By.id("loginName")).sendKeys(username);
		driver.findElement(By.id("loginPwd")).sendKeys(password);
		driver.findElement(By.id("btn_ifh_admin_login")).click();
	}

}
