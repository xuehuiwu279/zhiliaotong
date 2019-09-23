package common.element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseElement {
	
	/**
	 * 页面拖动到某一元素的位置
	 * @param driver
	 * @param name 元素name
	 */
	public static void scrollToElement(WebDriver driver,String name){
		String script = "return arguments[0].scrollIntoView();";
		WebElement element = driver.findElement(By.name("file"));
		((JavascriptExecutor) driver).executeScript(script, element);
	}
	

}
