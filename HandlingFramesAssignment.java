package Week4.Day1Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFramesAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		//Textbox
		WebDriver frame1 = driver.switchTo().frame("frame1");
		
		frame1.findElement(By.xpath("//input[@type='text']")).sendKeys("Frames");
		Thread.sleep(1000);
		frame1.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.TAB);
		//Checkbox
		WebDriver frame3 = frame1.switchTo().frame("frame3");

		frame3.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(1000);
		frame3.findElement(By.xpath("//input[@type='checkbox']")).sendKeys(Keys.TAB);		
		driver.switchTo().defaultContent();
		
		WebDriver frame2 = driver.switchTo().frame("frame2");

		WebElement animalElement = frame2.findElement(By.className("col-lg-3"));
		Select selAnimalElement=new Select(animalElement);
		selAnimalElement.selectByValue("babycat");
		
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		driver.close();

	}

}
