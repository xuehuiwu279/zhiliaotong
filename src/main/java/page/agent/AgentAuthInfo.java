package page.agent;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import common.element.BaseElement;
import common.operation.BaseOperation;

public class AgentAuthInfo {
	
	/**
	 * 个人认证
	 * @param driver
	 * @param map
	 */
	public static String authInfo(WebDriver driver , Map<String, String> map){
		driver.get("https://agent.izhiliao.com/ucenter/index");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/ul/li[5]/div")).click();
		BaseOperation.sleep(1000);
		driver.findElement(By.linkText("我的认证")).click();
		driver.findElement(By.id("nameInput")).clear();
		driver.findElement(By.id("nameInput")).sendKeys(map.get("nameInput"));
		Select area=new Select(driver.findElement(By.name("area")));
		area.selectByVisibleText(map.get("area"));
		Select district=new Select(driver.findElement(By.name("district")));
		district.selectByVisibleText(map.get("district"));
		driver.findElement(By.id("store-input")).clear();
		driver.findElement(By.id("store-input")).sendKeys("测试门店");
		driver.findElement(By.id("3130")).click();
		driver.findElement(By.xpath("//*[@id='headImg']")).click();
		BaseOperation.sleep(2000);
		driver.findElement(By.name("file")).sendKeys(map.get("file"));
		BaseOperation.sleep(2000);
		driver.findElement(By.id("cutImgSubmitBtn")).click();
		BaseOperation.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id='idCard']/img")).click();
		BaseOperation.sleep(2000);
		driver.findElement(By.name("file")).sendKeys(map.get("file"));
		BaseOperation.sleep(2000);
		driver.findElement(By.id("cutImgSubmitBtn")).click();
		BaseOperation.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id='nameCard']/img")).click();
		BaseOperation.sleep(2000);
		driver.findElement(By.name("file")).sendKeys(map.get("file"));
		BaseOperation.sleep(2000);
		driver.findElement(By.id("cutImgSubmitBtn")).click();
		BaseOperation.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div/p/a")).click();
		//页面拖动到某一元素的位置
		BaseElement.scrollToElement(driver, driver.findElement(By.id("advantage")));
		driver.findElement(By.xpath("//*[@id='infoCard']/img")).click();
		BaseOperation.sleep(2000);
		driver.findElement(By.name("file")).sendKeys(map.get("file"));
		BaseOperation.sleep(2000);
		driver.findElement(By.id("cutImgSubmitBtn")).click();
		BaseOperation.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div/p/a")).click();
		driver.findElement(By.linkText("提交")).click();
		BaseOperation.sleep(3000);
		String message = driver.findElement(By.xpath("/html/body/div[7]/div/div")).getText();
//		driver.findElement(By.xpath("/html/body/div[7]/div/h4/a")).click();
		return message;
	}

}
