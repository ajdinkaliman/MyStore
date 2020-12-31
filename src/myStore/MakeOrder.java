package myStore;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class MakeOrder {
	public String baseUrl = "http://automationpractice.com/index.php";
	String driverPath = "C:\\\\Users\\\\ajdin\\\\Downloads\\\\Sve za selenium\\\\chromedriver.exe";  // "C:\\Users\\ajdin\\Downloads\\Sve za selenium\\chromedriver.exe"
	public WebDriver driver;
	public Actions action;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(baseUrl);
		action = new Actions(driver);
	}

	@Test(priority = 0)
	public void logIn() throws InterruptedException {
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
	
	@Test(priority = 0)
	public void makeOrder() throws InterruptedException {	
		//Switch to T-Shirts
		WebElement switchToTShirts = driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[3]/a[1]"));  
		switchToTShirts.click();
		System.out.println("Go to T-Shirts done");
		
		//Click on Item
		WebElement we = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li"));
		action.moveToElement(we).build().perform();
		WebElement itemPreview = driver.findElement(By.xpath("//span[contains(text(),'More')]"));
		itemPreview.click();
		System.out.println("Item selected");
		
		//Select size
		Select dropDownListSize = new Select(driver.findElement(By.id("group_1"))); 
		dropDownListSize.selectByValue("2");
		System.out.println("Size selected");
		
		//Increase quantity
		WebElement quantityIncrease = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/form[1]/div[1]/div[2]/p[1]/a[2]/span[1]/i[1]"));
		quantityIncrease.click();
		System.out.println("Quantity increased");
		
		//Change color
		WebElement changeColor = driver.findElement(By.id("color_14"));
		changeColor.click();
		System.out.println("Color changed");
		
		//Add to cart
		WebElement addToCart = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
		addToCart.click();
		System.out.println("Added to cart");
		
		//Proceed to checkout
		WebElement proceedToCheckout = driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]"));
		proceedToCheckout.click();
		System.out.println("Proceeded to checkout");
		
		//Summary PTC
		WebElement summaryProceedToCheckout = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]"));
		summaryProceedToCheckout.click();
		System.out.println("Proceeded to checkout again in Summary");
		
		//Address PTC
		WebElement addressProceedToCheckout = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]"));
		addressProceedToCheckout.click();
		System.out.println("Proceeded to checkout again in Address");
		
		//Agree terms and shipping PTC
		WebElement checkBoxTerms = driver.findElement(By.id("cgv"));
		checkBoxTerms.click();
		WebElement shippingProceedToCheckout = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]/span[1]"));
		shippingProceedToCheckout.click();
		System.out.println("Agreed and proceeded to checkout again in Shipping");
		
		//Select payment
		WebElement selectPayment = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/p[1]/a[1]"));
		selectPayment.click();
		System.out.println("Payment selected");
		
		//Confirm order
		WebElement confirmOrder = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]"));
		confirmOrder.click();
		System.out.println("Order confirmed");
				
	}

	@AfterTest
	public void terminateBrowser() {
		// driver.close();
	}
}