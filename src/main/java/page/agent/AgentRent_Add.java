package page.agent;

import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.element.BaseElement;
import common.operation.BaseOperation;

public class AgentRent_Add {
	
	/**
	 * 发布租房信息
	 * @param driver
	 */
	public static String rent_add(WebDriver driver,Map<String, String> map){
		Random random = new Random();
		driver.get("https://agent.izhiliao.com/ucenter/index");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/ul/li[3]/div")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/ul/li[3]/ul/li[1]/a")).click();
		try {
			driver.findElement(By.xpath("/html/body/div[6]/div/p/a[2]")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.findElement(By.xpath("//*[@value='"+map.get("rentType")+"']")).click();
		driver.findElement(By.id("lpName")).sendKeys(map.get("lpName"));
		BaseOperation.sleep(1000);//等待1秒，等联想列表出来
		driver.findElement(By.xpath("//*[@id='ui-id-1']")).click();
		driver.findElement(By.name("bedroom")).sendKeys(map.get("bedroom"));
		driver.findElement(By.name("livingroom")).sendKeys(map.get("livingroom"));
		driver.findElement(By.name("kitchenroom")).sendKeys(map.get("kitchenroom"));
		driver.findElement(By.name("bathroom")).sendKeys(map.get("bathroom"));
		driver.findElement(By.name("floor")).sendKeys(map.get("floor"));
		driver.findElement(By.name("totalFloor")).sendKeys(map.get("totalFloor"));
		driver.findElement(By.xpath("//span[text()='"+ map.get("houseTypeSpan") +"']")).click();
		driver.findElement(By.xpath("//*[@value='"+ map.get("houseType") +"']")).click();
		driver.findElement(By.xpath("//span[text()='"+ map.get("fitmentSpan") +"']")).click();
		driver.findElement(By.xpath("//*[@value='"+ map.get("fitment") +"']")).click();
		driver.findElement(By.xpath("//span[text()='"+ map.get("supportLiftSpan") +"']")).click();
		driver.findElement(By.xpath("//*[@value='"+ map.get("supportLift") +"']")).click();
		driver.findElement(By.xpath("//span[text()='"+ map.get("supportHeatingSpan") +"']")).click();
		driver.findElement(By.xpath("//*[@value='"+ map.get("supportHeating") +"']")).click();
		driver.findElement(By.xpath("//span[text()='"+ map.get("rentPersonLimitSpan") +"']")).click();
		driver.findElement(By.xpath("//*[@value='"+ map.get("rentPersonLimit") +"']")).click();
		driver.findElement(By.xpath("//*[@value='"+ map.get("icebox1") +"']")).click();
		driver.findElement(By.xpath("//*[@value='"+ map.get("icebox2") +"']")).click();
		driver.findElement(By.xpath("//span[text()='"+ map.get("orientationSpan") +"']")).click();
		driver.findElement(By.xpath("//*[@value='"+ map.get("orientation") +"']")).click();
		driver.findElement(By.name("buildArea")).sendKeys(map.get("buildArea"));
		driver.findElement(By.name("rentFamilyNum")).sendKeys(map.get("rentFamilyNum"));
		driver.findElement(By.xpath("//*[@value='"+ map.get("visitType") +"']")).click();
		driver.findElement(By.name("rentPrice")).sendKeys(map.get("rentPrice"));
		driver.findElement(By.xpath("//span[text()='"+ map.get("rentPayTypeSpan") +"']")).click();
		driver.findElement(By.xpath("//*[@value='"+ map.get("rentPayType") +"']")).click();
		driver.findElement(By.name("sourceTitle")).sendKeys(map.get("sourceTitle")+random.nextInt(1000));
		driver.findElement(By.name("sourceDesc")).sendKeys(map.get("sourceDesc"));
		BaseElement.scrollToElement(driver, "file");
		driver.findElement(By.name("file")).sendKeys(map.get("file"));
		driver.findElement(By.xpath("//*[@id='houseForm']/ul/li[21]/div[2]/ul/form/li/input")).sendKeys(map.get("file"));
		BaseOperation.sleep(2000);//等待2秒，图片上传需要时间
		driver.findElement(By.xpath("//*[@id='houseForm']/ul/li[23]/div[2]/div")).click();
		String re = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]")).getText();
		return re;
	}

}
