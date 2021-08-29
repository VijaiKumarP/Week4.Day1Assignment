package Week4.Day1Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		String userName="demosalesmanager";
		String pWd="crmsfa";
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(pWd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		String titleName="My Home | opentaps CRM";
		if (titleName.equals(driver.getTitle())) {
			 System.out.println("Home page reached");			
		} else {
			System.out.println("Home page not reached");
		}
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		Thread.sleep(1000);
		
		//from Contact
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wndHandlesList=new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(wndHandlesList.get(1));

		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> wndHandlesList1=new ArrayList<String>(windowHandles1);
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		driver.switchTo().window(wndHandlesList1.get(0));
		
		//To Contact
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> wndHandlesList2=new ArrayList<String>(windowHandles2);
		
		driver.switchTo().window(wndHandlesList2.get(1));

		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> wndHandlesList3=new ArrayList<String>(windowHandles3);
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();
		
		driver.switchTo().window(wndHandlesList3.get(0));
		
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		System.out.println(driver.getTitle());
	}

}
