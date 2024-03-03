package Entrata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EntrataDemo {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\Chromedriver\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.entrata.com/");
		driver.manage().window().maximize();          //maximizes the opened window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));    //wait for 5 seconds
		
		//Accepts the cookies
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[3]/div[2]/button[2]")).click();  
		
		//hover over on products element
		WebElement ele=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div/div[2]/div[1]/div[1]"));
		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();	
		
		//click on Property Management
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a[1]")).click();
		
		//select on sign in option
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div/div[3]/a[2]")).click();

		//select Property manager Login 
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/div/div[1]/div/div[3]/a[1]")).click();
	
		//Click and enter Username
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/ul/li[1]/div/input")).sendKeys("abc@gmail.com");
		
		//click and enter password
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/ul/li[2]/input")).sendKeys("12345");
		
	}
	
	@Test
	public void verifyTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Property Management Software | Entrata";
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void verifyLogo() {
		boolean logo = driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[1]/div/div/a")).isDisplayed();
		
		Assert.assertTrue(logo);
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
