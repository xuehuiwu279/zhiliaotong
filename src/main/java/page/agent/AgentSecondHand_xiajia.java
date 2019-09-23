package page.agent;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AgentSecondHand_xiajia {

	public static void secondHand_xiajia_free(WebDriver driver){
		driver.get("https://agent.izhiliao.com/ucenter/index");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/ul/li[2]/div")).click();
		driver.findElement(By.linkText("房源管理")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[3]/ul/li[3]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//*[@id='input_list']/li"));		
		for (int i = 1; i < list.size()+1; i++) {
			driver.findElement(By.xpath("//*[@id='input_list']/li[" + i + "]/div/ul/li[3]")).click();
			driver.findElement(By.linkText("确定")).click();
		}
	}
}
