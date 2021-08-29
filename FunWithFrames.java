package Week4.Day1Assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunWithFrames {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		WebElement frame1Obj = driver.findElement(By.xpath("//iframe[@src='default.html']"));
		WebDriver frame1 = driver.switchTo().frame(frame1Obj);
		WebElement clickMeObj = driver.findElement(By.id("Click"));
		clickMeObj.click();
		
		File src1 = clickMeObj.getScreenshotAs(OutputType.FILE);
		File dst=new File("./SceenShot/SRSH1.png");
		FileUtils.copyFile(src1,dst);
		
		driver.switchTo().defaultContent();
		List<WebElement> findElements = driver.findElements(By.xpath("//iframe"));
		System.out.println("Number of Frames availabe in the Web Page is : " +findElements.size());
		
		WebElement frame2Obj = driver.findElement(By.xpath("//iframe[@src='page.html']"));
		WebDriver frame2 = driver.switchTo().frame(frame2Obj);
		
		driver.switchTo().frame("frame2");
		
		driver.findElement(By.id("Click1")).click();
		
	}

}
