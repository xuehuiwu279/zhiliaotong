package tools;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import common.operation.BaseOperation;

public class BugCount {
	
	public static WebDriver driver = new ChromeDriver();
	
	/**
	 * 登录
	 */
	public static void login(){
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://172.17.2.200/index.php?m=user&f=login");
		driver.findElement(By.id("account")).sendKeys("wuxh5");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.id("submit")).click();
	}

	/**
	 * 统计禅道bug
	 */
	public static void count(String url){
		driver.get(url);
		int[] counts = new int[5];
		String[] level = new String[]{"一级bug","二级bug","三级bug","四级bug","外部原因"};
		for(int i = 0;i < level.length;i++){
			if(level[i]!="外部原因"){
				driver.findElement(By.id("bysearchTab")).click();//点击“搜索”
				BaseOperation.sleep(2000);
				counts[i]=count("严重程度", ""+(i+1),"解决方案","已解决");
			}
			else {
				counts[i]= others();
			}
		}
		int all = 0;
		for(int i = 0;i < level.length;i++){
			System.out.println(level[i]+":"+counts[i]);
			all+=counts[i];
		}
		System.out.println("共:"+all);
		
	}
	
	/**
	 * 筛选条件选择
	 * @param i
	 * @param type
	 * @param status
	 */
	public static void ch(int i,String type,String status){
		driver.findElement(By.xpath("//*[@id='field"+i+"_chosen']/a/div[1]")).click();//筛选类型
		driver.findElement(By.xpath("//*[@id='field"+i+"_chosen']/a/div[2]/input")).sendKeys(type);//输入type  
		driver.findElement(By.xpath("//*[@id='field"+i+"_chosen']/div/ul/li")).click();//联想搜索列表选择type 
		driver.findElement(By.xpath("//*[@id='value"+i+"_chosen']/a")).click();//值
		driver.findElement(By.xpath("//*[@id='value"+i+"_chosen']/a/div[2]/input")).sendKeys(status);//输入值
		driver.findElement(By.xpath("//*[@id='value"+i+"_chosen']/div/ul/li")).click();//联想搜索列表选择status
		
	}
	
	/**
	 * 当前条件下bug数量
	 * @param type1
	 * @param status1
	 * @param type2
	 * @param status2
	 * @return
	 */
	public static int count(String type1,String status1,String type2,String status2){
		choose(type1, status1, type2, status2);
		driver.findElement(By.id("submit")).click();
		String ii = "";
		try {
			ii = driver.findElement(By.xpath("//*[@id='projectBugForm']/div/ul/li[1]/div/strong")).getText();
		} catch (Exception e) {
			// TODO: handle exception
			ii = "0";
		}
		int i = Integer.parseInt(ii);
		return i;
	}
	
	/**
	 * 解决方案非已解决的bug数量
	 * @return
	 */
	public static int others(){
		String[] others = new String[]{"设计如此","外部原因","无法重现","延期处理","不予解决","转为需求"};
		int i = 0;
		for(String str:others){
			driver.findElement(By.id("bysearchTab")).click();//点击“搜索”
			BaseOperation.sleep(2000);
			i+=count("bug状态", "已关闭","解决方案",str);
		}
		
		return i;
	}
	
	/**
	 * 两组筛选条件的调用
	 * @param type1
	 * @param status1
	 * @param type2
	 * @param status2
	 */
	public static void choose(String type1,String status1,String type2,String status2){
		ch(1, type1, status1);
		ch(4, type2, status2);
	}
	
	@Test
	public void test(){
		login();
		count("http://172.17.2.200/index.php?m=project&f=bug&projectID=275");
		driver.close();
	}
}
