package common.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseOperation {

	/**
	 * 驱动
	 */
	public static WebDriver getDriver(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
		return driver;
	}
	
	/**
	 * 登录
	 * @param username
	 * @param pwd
	 */
	public static void login(WebDriver driver,String url,String username,String pwd){
		driver.get("https://agent.izhiliao.com/agent/login");
		driver.findElement(By.id("phone")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.linkText("快速登录")).click();
	}
	
	/**
	 * 退出
	 */
	public static void logout(WebDriver driver){
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/span[2]/a")).click();
	}
	
	/**
	 * Thread.sleep
	 */
	public static void sleep(int i){
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
