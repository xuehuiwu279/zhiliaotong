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
	
	public static String special_add(WebDriver driver, Map<String, String> map){
		BaseOperation_cms.login(driver, "http://admin.house.ifeng.com/admin/login", "tangyp@ifeng.com", "typ123456");
		driver.findElement(By.xpath("//span[text()=' 专题 ']")).click();
		driver.findElement(By.xpath("//*[@id='special']/ul/li[1]/a")).click();
		Select select = new Select(driver.findElement(By.xpath("//*[@id='special_form']/table/tbody/tr[1]/td/select")));
		select.selectByVisibleText("家居专题");
		driver.findElement(By.id("input_specialName1")).sendKeys("MyTest专题名称");
		driver.findElement(By.id("input_specialName2")).sendKeys("MyTestSpecialNameForEnglish");
		BaseElement.clickBlankArea(driver);
		driver.findElement(By.id("templateSelect")).click();
		driver.findElement(By.xpath("//*[@tplid='52112']")).click();
		driver.findElement(By.id("specialms")).sendKeys("自动化脚本调试，请忽略");
		driver.findElement(By.id("special_save")).click();
		BaseOperation.sleep(2000);
		String re = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]")).getText();
		driver.findElement(By.xpath("//span[text()='确认']")).click();
		
		return re;
	}
	
	@Test
	public void ttt(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Map<String, String> map = new HashMap<String, String>();
		String re = special_add(driver, map);
		System.out.println(re);
	}

}
