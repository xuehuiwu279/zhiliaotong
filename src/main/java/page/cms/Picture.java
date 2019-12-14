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

public class Picture {
	
	public static String picture_add(WebDriver driver , Map<String, String> map){
		BaseOperation_cms.login(driver, "http://admin.house.ifeng.com/admin/login", "tangyp@ifeng.com", "typ123456");
		BaseOperation.sleep(2000);
		driver.findElement(By.xpath("//span[text()=' 图片 ']")).click();
		driver.findElement(By.xpath("//*[@id='picture']/ul/li[2]/a")).click();
		Select select = new Select(driver.findElement(By.id("pic_pub_col")));
		select.selectByVisibleText("家居");
		driver.findElement(By.id("pic_pub_title")).sendKeys("MyTest上传图集主标题");
		driver.findElement(By.id("pic_pub_subtitle")).sendKeys("MyTest上传图集副标题");
		driver.findElement(By.id("pic_pub_shorttitle_1")).sendKeys("MyTest上传图集短标题1");
		driver.findElement(By.id("pic_pub_src")).sendKeys("凤凰博客");
		BaseOperation.sleep(2000);
		driver.findElement(By.xpath("//*[@id='uploadifive-ifh_pic_upload_btn_1']/input[2]")).sendKeys("C:\\picture\\showPicture.jpg");
		BaseOperation.sleep(2000);
		driver.findElement(By.xpath("//*[@id='uploadifive-ifh_pic_upload_btn_1']/input[3]")).sendKeys("C:\\picture\\showPicture.jpg");
		BaseOperation.sleep(2000);
		driver.findElement(By.xpath("//*[@id='uploadifive-ifh_pic_upload_btn_1']/input[4]")).sendKeys("C:\\picture\\showPicture.jpg");
		BaseOperation.sleep(2000);
		BaseElement.scrollToElement(driver, driver.findElement(By.id("ifh_pic_btn_save")));
		driver.findElement(By.id("ifh_pic_btn_save")).click();
		driver.findElement(By.xpath("//button[text()='确认']")).click();
		BaseOperation.sleep(5000);
		String re = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]")).getText();
			
		BaseOperation.sleep(2000);
		
		return re;
	}
	
	@Test
	public void ttt(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Map<String, String> map = new HashMap<String, String>();
		String re = picture_add(driver, map);
		driver.close();
		System.out.println("---------"+re);
	}

}
