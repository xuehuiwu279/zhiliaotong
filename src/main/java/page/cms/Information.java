package page.cms;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import common.element.BaseElement;
import common.operation.BaseOperation;
import common.operation.BaseOperation_cms;

public class Information {
	
	/**
	 * 发布资讯
	 * @param driver
	 * @return
	 */
	public static String information_add(WebDriver driver ){	
//		driver.findElement(By.xpath("//span[text()='资讯']")).click();
//		driver.findElement(By.xpath("//*[@id='information']/ul/li[1]/a")).click();
		Select select = new Select(driver.findElement(By.id("info_pub_col")));
		select.selectByVisibleText("----"+"行业资讯");
		driver.findElement(By.id("info_pub_title")).clear();
		driver.findElement(By.id("info_pub_title")).sendKeys("MyTest发布资讯主标题");
		driver.findElement(By.id("info_pub_subtitle")).clear();
		driver.findElement(By.id("info_pub_subtitle")).sendKeys("MyTest发布资讯副标题");
		driver.findElement(By.id("info_pub_shorttitle")).clear();
		driver.findElement(By.id("info_pub_shorttitle")).sendKeys("MyTest发布资讯短标题");
		driver.findElement(By.id("info_pub_src")).clear();
		driver.findElement(By.id("info_pub_src")).sendKeys("凤凰博客");
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		driver.findElement(By.tagName("body")).clear();
		driver.findElement(By.tagName("body")).sendKeys("MyTest发布资讯正文");
		driver.switchTo().defaultContent();
		String currentWindow = driver.getWindowHandle();//获取当前窗口句柄
		BaseOperation.sleep(2000);
		try {
			BaseElement.scrollToElement(driver, driver.findElement(By.id("news_article_save")));
			BaseOperation.sleep(2000);
			driver.findElement(By.id("news_article_save")).click();
		} catch (Exception e) {
			// TODO: handle exception
			BaseElement.scrollToElement(driver, driver.findElement(By.id("btn_ifh_news_article_update")));
			BaseOperation.sleep(2000);
			driver.findElement(By.id("btn_ifh_news_article_update")).click();
		}
		BaseOperation.sleep(2000);
		
		driver.switchTo().alert().accept();
		BaseOperation.sleep(3000);
		driver.switchTo().window(currentWindow);
		String re = driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]")).getText();
		BaseOperation.sleep(2000);
		return re;
	}
	
	
	public static String information_edit(WebDriver driver){
		driver.findElement(By.xpath("//span[text()='资讯']")).click();
		driver.findElement(By.xpath("//*[@id='information']/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='information']/ul/li[2]/ul/li[1]/a")).click();
		BaseOperation.sleep(1000);
		driver.findElement(By.id("news_search")).click();
		driver.findElement(By.id("info_search_title")).sendKeys("MyTest发布资讯主标题");
		driver.findElement(By.id("search_b")).click();
		String re = "";
		if (driver.findElement(By.xpath("//table/tbody/tr/td[3]/a")).getText().equals("MyTest发布资讯主标题")) {
			driver.findElement(By.xpath("//table/tbody/tr/td[13]/a[2]")).click();
			String currentWindow = driver.getWindowHandle();//获取当前窗口句柄
			Set<String> handles = driver.getWindowHandles();//获取所有窗口句柄
			Iterator<String> it = handles.iterator();
			while (it.hasNext()) {
				if (currentWindow == it.next()) {
					continue;
				}
				driver.switchTo().window(it.next());//切换到新窗口
			}
			re = information_add(driver);
		} else {
			re = "没有找到这个标题";
		}
		
		return re;
	}
	
	@Test
	public void tt(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		BaseOperation_cms.login(driver, "http://admin.house.ifeng.com/admin/login", "tangyp@ifeng.com", "typ123456");
		String re = information_edit(driver);
		System.out.println(re);
		BaseOperation.sleep(3000);
		driver.close();
	}

}
