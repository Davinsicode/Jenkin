package executableFiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MicTest 
{
@Test
public void micTest() throws InterruptedException, AWTException
{
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();

driver.get("https://mictests.com/");
driver.findElement(By.xpath("//a[.='Test Webcam']")).click();
Set<String> ids = driver.getWindowHandles();
String title = "Webcam Test";
for (String id : ids) 
{
	driver.switchTo().window(id);
	String actual = driver.getTitle();
	if(title.equals(actual))
	{
		break;
	}
}

Thread.sleep(3000);
driver.findElement(By.xpath("//button[.='Test my cam']")).click();

Robot rbt = new Robot();
for (int i = 0; i < 2; i++) 
{
	rbt.keyPress(KeyEvent.VK_TAB);
	rbt.keyRelease(KeyEvent.VK_TAB);	
}
rbt.keyPress(KeyEvent.VK_ENTER);
rbt.keyRelease(KeyEvent.VK_ENTER);
}
}
