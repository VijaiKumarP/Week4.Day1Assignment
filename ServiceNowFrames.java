package Week4.Day1Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowFrames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev113545.service-now.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("w6hnF2FRhwLC");
		driver.findElement(By.id("sysverb_login")).click();
		
		//driver.switchTo().defaultContent();
		
		System.out.println(driver.getTitle() +" - Page Loaded");
		
		driver.findElement(By.id("filter")).sendKeys("incidents");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		
		WebDriver frame1 = driver.switchTo().frame("gsft_main");
		
		//Click All Link		
		driver.findElement(By.className("breadcrumb_link")).click();
		
		//Click New option
		driver.findElement(By.id("sysverb_new")).click();
		
		//Enter the incident Details
		driver.findElement(By.id("incident.short_description")).sendKeys("Guest User");
		driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys("Guest");
		Thread.sleep(1000);
		driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys(Keys.ENTER);
		String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		/*
		driver.switchTo().defaultContent();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wndHandlesList=new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(wndHandlesList.get(1));
		
		driver.findElement(By.xpath("//input[@class='form-control'][1]")).sendKeys("Guest");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='form-control'][1]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Guest']")).click();
		
		*/
		
		driver.findElement(By.id("sysverb_insert")).click();
		
		// Search Incident Number
		WebElement searchBy = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select selSearchBy= new Select(searchBy);
		selSearchBy.selectByValue("number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//a[text()='" + incidentNumber +"']")).isDisplayed()==true) {
			System.out.println("Incident is Created successfully");
		}else {
			System.out.println("Incident is not Created");
		}
		
	}

}
