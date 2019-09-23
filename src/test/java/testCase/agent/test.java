package testCase.agent;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl11;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.data.GetXML;
import common.operation.BaseOperation;
import junit.framework.Assert;
import page.agent.AgentRent_Add;
import page.agent.AgentSecondHand_xiajia;

public class test {
	
	WebDriver driver = new ChromeDriver();
//	@Test
//	public void te() throws InterruptedException{
//		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get("https://sh.house.ifeng.com/");
//		driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[1]/ul/li[2]/a")).click();
//		//移动鼠标并进行点击操作
//		Actions action = new Actions(driver); 
//		WebElement toElement = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/ul/li[4]/div/a[1]"));
//		action.moveToElement(toElement, 50, -50);
//		action.click();
//		Thread.sleep(5000);
//		driver.close();
//		
//	}
	
	@BeforeClass
	public void before() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
//	@Test
//	@Parameters({"pp01","pp02"})
//	public void tt(String y01,String y02){
////		Assert.assertEquals("123", y01);
//		System.out.println(y01);
//		System.out.println(y02);
//	}
//	
//	@Test(dataProvider="test_data",dataProviderClass = GetXML.class)
//	public void tr(String no,Map<String, String> map){
//		System.out.println(no);
//		System.out.println(map.get("NAME"));
//	}
	
	@Test
	public void tt1(){
//		Random random = new Random();
//		System.out.println("test"+random.nextInt(100));
		AgentSecondHand_xiajia.secondHand_xiajia_free(driver);
	}

	@AfterTest
	public void after() throws InterruptedException{
		Thread.sleep(2000);
		driver.close();
		System.out.println("after");
	}

}
