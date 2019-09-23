package common.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseJudge {
	
	/**
	 * 判断C端是否展示该二手房房源，因是用房源名称精确查询，所以只需判断有没有结果
	 * @param sourceTitle
	 * @return
	 */
	public static Boolean viewOrNot_secondHand(String sourceTitle){
		Boolean re = false;
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
		driver.get("https://www.izhiliao.com/ershoufang?");
		driver.findElement(By.name("keyword")).sendKeys(sourceTitle);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div")).click();
		try {
			driver.findElement(By.xpath("/html/body/div[3]/div[5]/div[1]/div[1]/ul/li/a/p[1]"));
			re = true;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			re = false;
		}
		driver.close();
		return re;
	}
	
	/**
	 * 判断C端是否展示该租房房源，因是用房源名称精确查询，所以只判断有没有结果
	 * @param sourceTitle
	 * @return
	 */
	public static Boolean viewOrNot_rent(String sourceTitle){
		Boolean re = false;
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
		driver.get("https://www.izhiliao.com/zufang/");
		driver.findElement(By.name("keyword")).sendKeys(sourceTitle);
		driver.findElement(By.xpath("//*[@id='searchForm']/div")).click();
		try {
			driver.findElement(By.xpath("/html/body/div[3]/div[5]/div[1]/div[1]/ul/li/a/p[1]"));
			re = true;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			re = false;
		}
		driver.close();
		return re;
	}
	
}
