package page.cms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import common.element.BaseElement;
import common.operation.BaseOperation;
import common.operation.BaseOperation_cms;

public class Picture {
	
	/**
	 * 上传图集
	 * @param driver
	 * @param map
	 * @return
	 */
	public static String picture_add(WebDriver driver , Map<String, String> map){
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
	
	/**
	 * 编辑图片
	 * @param driver
	 * @param map
	 * @return
	 */
	public static String picture_edit(WebDriver driver , Map<String, String> map){
		driver.findElement(By.xpath("//span[text()=' 图片 ']")).click();
		driver.findElement(By.xpath("//*[@id='picture']/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='picture']//a[text()='全部']")).click();
		BaseOperation.sleep(1000);
		driver.findElement(By.id("ifh_pic_btn_search")).click();
		driver.findElement(By.id("info_search_title")).sendKeys("MyTest上传图集主标题");
		driver.findElement(By.id("ifh_pic_list_btn_search")).click();
		String re = "";
		String picture = "";
		try {
			BaseOperation.sleep(1000);
			picture = driver.findElement(By.xpath("//*[@id='ifh_pic_tbl_list']/tr[1]/td[3]/a")).getText();
			System.out.println("picture:"+picture);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (picture.equals("MyTest上传图集主标题")) {
			driver.findElement(By.xpath("//*[@id='ifh_pic_tbl_list']/tr[1]/td[10]/a[2]")).click();
			BaseOperation.sleep(1000);
			String currentWindow = driver.getWindowHandle();//获取当前窗口句柄
			Set<String> handles = driver.getWindowHandles();//获取所有窗口句柄
			Iterator<String> it = handles.iterator();
			while (it.hasNext()) {
				if (currentWindow == it.next()) {
					continue;
				}
				driver.switchTo().window(it.next());//切换到新窗口
			}
			Select select = new Select(driver.findElement(By.id("pic_pub_col")));
			select.selectByVisibleText("家居");
			driver.findElement(By.id("pic_pub_title")).clear();
			driver.findElement(By.id("pic_pub_title")).sendKeys("MyTest上传图集主标题");
			driver.findElement(By.id("pic_pub_subtitle")).clear();
			driver.findElement(By.id("pic_pub_subtitle")).sendKeys("MyTest上传图集副标题");
			driver.findElement(By.id("pic_pub_shorttitle_1")).clear();
			driver.findElement(By.id("pic_pub_shorttitle_1")).sendKeys("MyTest上传图集短标题1");
			driver.findElement(By.id("pic_pub_src")).clear();
			driver.findElement(By.id("pic_pub_src")).sendKeys("凤凰博客");
			BaseElement.scrollToElement(driver, driver.findElement(By.id("ifh_pic_upd_btn_update")));
			driver.findElement(By.id("ifh_pic_upd_btn_update")).click();
			driver.findElement(By.xpath("//button[text()='确认']")).click();
			BaseOperation.sleep(5000);
			re = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]")).getText();
			
		} else {
			re = "没有找到这个picture";
		}
		return re;
	}
	
	/**
	 * 下线图集
	 * @param driver
	 * @param map
	 * @return
	 */
	public static String picture_delete(WebDriver driver , Map<String, String> map){
		driver.findElement(By.xpath("//span[text()=' 图片 ']")).click();
		driver.findElement(By.xpath("//*[@id='picture']/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='picture']//a[text()='全部']")).click();
		BaseOperation.sleep(1000);
		driver.findElement(By.id("ifh_pic_btn_search")).click();
		driver.findElement(By.id("info_search_title")).sendKeys("MyTest上传图集主标题");
		driver.findElement(By.id("ifh_pic_list_btn_search")).click();
		String re = "";
		String picture = "";
		try {
			BaseOperation.sleep(1000);
			picture = driver.findElement(By.xpath("//*[@id='ifh_pic_tbl_list']/tr[1]/td[3]/a")).getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (picture.equals("MyTest上传图集主标题")){
			String currentWindow = driver.getWindowHandle();
			driver.findElement(By.xpath("//*[@id='ifh_pic_tbl_list']/tr[1]/td[10]/a[3]")).click();
			driver.findElement(By.id("ifh_pic_topic_off_reason")).sendKeys("MyTest上传图集下线");
			driver.findElement(By.id("ifh_pic_topic_off_from")).sendKeys("test");
			driver.findElement(By.id("ifh_pic_topic_off_agree")).sendKeys("test");
			driver.findElement(By.xpath("//button[text()='确认']")).click();
			BaseOperation.sleep(3000);
			driver.switchTo().window(currentWindow);
			re = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]")).getText();
		}else {
			re = "没有找到这个picture";
		}
		
		return re;
	}
	
	@Test
	public void ttt(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		BaseOperation_cms.login(driver, "http://admin.house.ifeng.com/admin/login", "tangyp@ifeng.com", "typ123456");
		Map<String, String> map = new HashMap<String, String>();
		String re = picture_edit(driver, map);
		driver.close();
		System.out.println("最终返回："+re);
	}

}
