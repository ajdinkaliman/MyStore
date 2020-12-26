package TestingDemo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class NewTestNG {
  public WebDriver driver;
  @Test(priority = 0)
  public void test1() throws InterruptedException {
	 
		String expectedTitle = "My Store";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
			
		String titleOfThePage = driver.getTitle();
		System.out.println("Title of the page is: " + titleOfThePage);
			
		WebElement goToLogin = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
		goToLogin.click();
				
		WebElement enterMail = driver.findElement(By.xpath("//input[@id='email']"));
		enterMail.sendKeys("ajdin.kaliman@hotmail.com");
		System.out.println("Mail is ok");
			
		WebElement enterPassword = driver.findElement(By.xpath("//input[@id='passwd']"));
		enterPassword.sendKeys("testing123");
		System.out.println("Password is ok");
			
		WebElement clickSingInButton = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]"));
		clickSingInButton.click();		
		}
  
  @Test(priority = 1)
  public void test2() throws InterruptedException {
	 
	    WebElement switchToTShirts = driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[3]/a[1]"));
		switchToTShirts.click();
		System.out.println("??");
		
		WebElement itemPreview = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
		itemPreview.click();
		
		Select dropDownListSize = new Select(driver.findElement(By.name("group_1")));
		dropDownListSize.selectByValue("2");
		
		WebElement quantityIncrease = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/form[1]/div[1]/div[2]/p[1]/a[2]/span[1]/i[1]"));
		quantityIncrease.click();
		
		WebElement changeColor = driver.findElement(By.id("color_14"));
		changeColor.click();
		
		WebElement addToCart = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
		addToCart.click();	
		}
		
	  
  @BeforeTest
  public void beforeTest() {
	  	String baseUrl = "http://automationpractice.com/index.php";
		String driverPath = "C:\\Users\\ajdin\\Downloads\\Sve za selenium\\chromedriver.exe";
	    WebDriver driver;
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(baseUrl);
			
  }

  @AfterTest
  public void afterTest() {
	// driver.close();
  }

}
