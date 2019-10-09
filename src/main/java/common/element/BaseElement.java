package common.element;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseElement {
	
	/**
	 * 页面拖动到某一元素的位置
	 * @param driver
	 * @param element 页面元素
	 */
	public static void scrollToElement(WebDriver driver,WebElement element){
		String script = "return arguments[0].scrollIntoView();";
		((JavascriptExecutor) driver).executeScript(script, element);
	}
	

}
