package TEST;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class DAtesting {	

	
		WebDriver driver;
		@BeforeTest
		public void setup()
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sundar\\Downloads\\chromedriver.exe");
			 driver = new ChromeDriver();
			driver.get("http://www.newtours.demoaut.com");
		
		}
		
		@Test
		public void login()
		{
			driver.findElement(By.name("userName")).sendKeys("123");
			driver.findElement(By.name("password")).sendKeys("123");
			
			driver.findElement(By.name("login")).click();
			
		}
		@Test
		public void trip()
		{
			
			List<WebElement> raios = driver.findElements(By.xpath("//input[@type = 'radio']"));
			for (WebElement chk : raios)
			{
				if(!chk.isSelected())
				{
				String b = chk.getAttribute("value");
				
				if (b.equalsIgnoreCase("oneway"))
						{
							chk.click();
						}
				}		
		
			}
		}
		
		@AfterTest
		public void tearDown()
		{
		driver.quit();	
		}
}

	