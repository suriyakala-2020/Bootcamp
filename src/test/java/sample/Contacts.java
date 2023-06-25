package sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Contacts {

	private static RemoteWebDriver driver;
	@Test
	public void addUser() {
		// TODO Auto-generated method stub
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(options);
			 driver.get("https://login.salesforce.com/");
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
			 driver.findElement(By.id("password")).sendKeys("Leaf@1234");
			 driver.findElement(By.id("Login")).click();
			 driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			 driver.findElement(By.xpath("//button[text()='View All']")).click();
			 driver.findElement(By.xpath("//p[text()='Sales']")).click();
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 WebElement Accounts = driver.findElement(By.xpath("//one-app-nav-bar-item-root/a/span[text()='Accounts']"));
			 driver.executeScript("arguments[0].click();", Accounts);
			 driver.findElement(By.xpath("//a[@title='New']/div")).click();
			 String AccountName="sk";
			 driver.findElement(By.xpath("//*[text()='Account Name']//following-sibling::div//input")).sendKeys(AccountName);
			 js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//label[text()='Ownership']/following-sibling::div")));
			 driver.findElement(By.xpath("//label[text()='Ownership']/following-sibling::div")).click();
			 driver.findElement(By.xpath("//span[text()='Public']")).click();
			 driver.findElement(By.xpath("//button[text()='Save']")).click();
			 String Actual_AccountName = driver.findElement(By.xpath("//*[@data-aura-class='sfaOutputNameWithHierarchyIcon']//lightning-formatted-text")).getText();
			 System.out.println(Actual_AccountName);
			 Assert.assertEquals(Actual_AccountName, AccountName);
			
			 
			 
			 
	}

}
