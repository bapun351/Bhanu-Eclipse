package b123;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class irctc 
{
	public static void main(String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in");
		
		WebElement wb=driver.findElement(By.xpath("//a[@id='irctc_tourism']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(wb).perform();
		
		driver.findElement(By.xpath("//a[text()='Tourist Train']")).click();
		
		Set<String> set=driver.getWindowHandles();
		System.out.println(set.size());
		
		Iterator<String> it=set.iterator();
		String ParentWndw=it.next();
		String ChildWndw=it.next();
		
		driver.switchTo().window(ChildWndw);
		
		driver.findElement(By.xpath("//div[@class='heritage']/div/span/a[text()='Book Now']")).click();
		
		Set<String> set1=driver.getWindowHandles();
		System.out.println(set1.size());
		
		Iterator<String> it1=set1.iterator();
		String Wndw1=it1.next();
		String Wndw2=it1.next();
		String Wndw3=it1.next();
		
		driver.switchTo().window(Wndw3);
		
		WebElement phn=driver.findElement(By.xpath("//div[@class='container-fluid top-strip']/div/ul/li[2]/a"));
		WebElement email=driver.findElement(By.xpath("//div[@class='container-fluid top-strip']/div/ul/li[3]/a"));
		
		System.out.println(phn.getText());
		System.out.println(email.getText());
		
		driver.findElement(By.xpath("//div[@class='container-fluid top-strip']/div/ul/li[6]/a")).click();
	
		
		List<WebElement> lst=driver.findElements(By.xpath("//div[@class='two_columb clearfix']/div[1]/div[2]/table/tbody/tr[*]/td[*]"));
		
		for(int i=0;i<lst.size();i++)
		{
			System.out.println(lst.get(i).getText());
		}
		
		driver.close();
		driver.switchTo().window(Wndw2);
		driver.close();
		driver.switchTo().window(Wndw1);
		
	}
}
