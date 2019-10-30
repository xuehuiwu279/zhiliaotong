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
		String script = "return arguments[0].scrollIntoView(false);";
		((JavascriptExecutor) driver).executeScript(script, element);
	}
	
	public static void scrollByJS(WebDriver driver,String xpath){
		String js="var q=document.documentElement.scrollTop=10000";
		((JavascriptExecutor) driver).executeScript(js);
	}

}
