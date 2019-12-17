package page.cms;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import common.element.BaseElement;
import common.operation.BaseOperation;
import common.operation.BaseOperation_cms;

public class Special {
	
	/**
	 * 发布专题
	 * @param driver
	 * @param map
	 * @return
	 */
	public static String special_add_base(WebDriver driver,Map<String, String> map){
		Select select = new Select(driver.findElement(By.xpath("//*[@id='special_form']/table/tbody/tr[1]/td/select")));
		select.selectByVisibleText("家居专题");
		driver.findElement(By.id("input_specialName1")).clear();
		driver.findElement(By.id("input_specialName1")).sendKeys("MyTest专题名称");
		if (driver.findElement(By.id("input_specialName2")) == null) {
			driver.findElement(By.id("input_specialName2")).sendKeys("MyTestSpecialNameForEnglish");
		}
		BaseElement.clickBlankArea(driver);
		driver.findElement(By.id("templateSelect")).click();
		driver.findElement(By.xpath("//*[@tplid='52112']")).click();
		driver.findElement(By.id("specialms")).clear();
		driver.findElement(By.id("specialms")).sendKeys("自动化脚本调试，请忽略");
		BaseOperation.sleep(1000);
		driver.findElement(By.id("special_save")).click();
		BaseOperation.sleep(2000);
		String re = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]")).getText();
		driver.findElement(By.xpath("//button[text()='确认']")).click();
		return re;
	}
	
	/**
	 * 新增专题
	 * @param driver
	 * @param map
	 * @return
	 */
	public static String special_add(WebDriver driver, Map<String, String> map){
		driver.findElement(By.xpath("//span[text()=' 专题 ']")).click();
		driver.findElement(By.xpath("//*[@id='special']/ul/li[1]/a")).click();
		String re = special_add_base(driver, map);		
		return re;
	}
	
	/**
	 * 编辑专题
	 * @param driver
	 * @param map
	 * @return
	 */
	public static String special_edit(WebDriver driver,Map<String, String> map){
		driver.findElement(By.xpath("//span[text()=' 专题 ']")).click();
		driver.findElement(By.xpath("//*[@id='special']/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id='special']/ul/li[3]/ul/li[1]/a")).click();
		driver.findElement(By.id("special_search")).click();
		driver.findElement(By.id("info_search_title")).sendKeys("MyTest专题名称");
		driver.findElement(By.id("search_b")).click();
		String re = "";
		String special = "";
		try {
			BaseOperation.sleep(1000);
			special = driver.findElement(By.xpath("//*[@id='specialList']/tbody/tr/td[2]/a")).getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (special.equals("MyTest专题名称")) {
			driver.findElement(By.xpath("//*[@id='specialList']/tbody/tr/td[8]/a[2]")).click();
			re = special_add_base(driver, map);
		} else {
			re = "没有这个专题";
		}
		return re;		
	}
	
	/**
	 * 下线专题
	 * @param driver
	 * @param map
	 * @return
	 */
	public static String special_delete(WebDriver driver,Map<String, String> map){
		driver.findElement(By.xpath("//span[text()=' 专题 ']")).click();
		driver.findElement(By.xpath("//*[@id='special']/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id='special']/ul/li[3]/ul/li[1]/a")).click();
		driver.findElement(By.id("special_search")).click();
		driver.findElement(By.id("info_search_title")).sendKeys("MyTest专题名称");
		driver.findElement(By.id("search_b")).click();
		String re = "";
		String special = "";
		try {
			BaseOperation.sleep(1000);
			special = driver.findElement(By.xpath("//*[@id='specialList']/tbody/tr/td[2]/a")).getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (special.equals("MyTest专题名称")) {
			String currentWindow = driver.getWindowHandle();
			driver.findElement(By.xpath("//*[@id='specialList']/tbody/tr/td[8]/a[4]")).click();
			driver.findElement(By.xpath("//button[text()='确认']")).click();
			BaseOperation.sleep(3000);
			driver.switchTo().window(currentWindow);
			re = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]")).getText();
		} else {
			re = "没有这个专题";
		}
		return re;	
	}
	
	
	@Test
	public void ttt(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Map<String, String> map = new HashMap<String, String>();
		BaseOperation_cms.login(driver, "http://admin.house.ifeng.com/admin/login", "tangyp@ifeng.com", "typ123456");
		String re = special_delete(driver, map);
		driver.close();
		System.out.println("+++++"+re);
	}

}
