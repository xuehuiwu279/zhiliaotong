package page.agent;

import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import common.element.BaseElement;
public class AgentSecondHand_Add {
		
	/**
	 * 二手房发布
	 * @param driver
	 */
	public static String secondHand_add(WebDriver driver,Map<String, String> map) {
		Random random = new Random();
		//经纪人  15694928508  qwe123
		driver.get("https://agent.izhiliao.com/ucenter/index");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/ul/li[2]/div")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.linkText("发布房源")).click(); 
		try {
			driver.findElement(By.xpath("/html/body/div[6]/div/p/a[2]")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		//房源页面
		driver.findElement(By.id("lpName")).sendKeys(map.get("lpName"));
		try {
			Thread.sleep(1000);//等待1秒，等联想列表出来
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='ui-id-1']")).click();
		driver.findElement(By.name("totalPrice")).sendKeys(map.get("totalPrice"));
		driver.findElement(By.name("bedroom")).sendKeys(map.get("bedroom"));
		driver.findElement(By.name("livingroom")).sendKeys(map.get("livingroom"));
		driver.findElement(By.name("kitchenroom")).sendKeys(map.get("kitchenroom"));
		driver.findElement(By.name("bathroom")).sendKeys(map.get("bathroom"));
		driver.findElement(By.name("buildArea")).sendKeys(map.get("buildArea"));
		driver.findElement(By.name("useArea")).sendKeys(map.get("useArea"));
		driver.findElement(By.name("floor")).sendKeys(map.get("floor"));
		driver.findElement(By.name("totalFloor")).sendKeys(map.get("totalFloor"));
		driver.findElement(By.xpath("//span[text()='物业类型']")).click();
		driver.findElement(By.xpath("//*[@value='住宅']")).click();
		driver.findElement(By.xpath("//span[text()='户型结构']")).click();
		driver.findElement(By.xpath("//*[@value='平层']")).click();
		driver.findElement(By.xpath("//span[text()='建筑年代']")).click();
		driver.findElement(By.xpath("//*[@value='2012']")).click();
		driver.findElement(By.xpath("//span[text()='建筑类别']")).click();
		driver.findElement(By.xpath("//*[@value='板楼']")).click();
		driver.findElement(By.xpath("//span[text()='装修程度']")).click();
		driver.findElement(By.xpath("//*[@value='简装']")).click();
		driver.findElement(By.xpath("//span[text()='朝向']")).click();
		driver.findElement(By.xpath("//*[@value='南']")).click();
		driver.findElement(By.xpath("//span[text()='年限']")).click();
		driver.findElement(By.xpath("//*[@value='70']")).click();
		driver.findElement(By.id("anytime")).click();
		driver.findElement(By.id("fullFive")).click();
		driver.findElement(By.name("dealOnly")).click();
		driver.findElement(By.name("sourceTitle")).sendKeys(map.get("sourceTitle")+random.nextInt(1000));
		driver.findElement(By.id("sourceDesc")).sendKeys(map.get("sourceDesc"));
		//页面拖动到某一元素的位置
		BaseElement.scrollToElement(driver, "file");
		driver.findElement(By.name("file")).sendKeys(map.get("file"));
		driver.findElement(By.xpath("//*[@id='huxingform']/li/input")).sendKeys(map.get("file"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='houseForm']/ul/li[32]/div[2]/div")).click();
		String re = driver.findElement(By.xpath("/html/body/div[6]/div/div")).getText();
		return re;
	}
	
}
