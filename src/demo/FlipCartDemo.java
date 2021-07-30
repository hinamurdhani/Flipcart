package demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
public class FlipCartDemo {
	
	
	WebDriver driver;

	
  @Test
  public void f() throws InterruptedException, IOException {
	  
	  //set up the driver
	  System.setProperty("webdriver.chrome.driver","./src/driver/chromedriver.exe");
	  driver = new ChromeDriver();
	  allActions(driver);
	  System.setProperty("webdriver.gecko.driver","./src/driver/geckodrive.exe");
	  driver = new FirefoxDriver();
	  allActions(driver);
	  
  }
  
 
  
  public void allActions(WebDriver driver) throws IOException {
	  //get url
	  driver.get("https://www.google.com");
	  driver.manage().window().maximize(); 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  capture(driver);
	  //Action Started
	  WebElement search = driver.findElement(By.name("q"));
	  search.sendKeys("Flipkart");
	  capture(driver);
	  //listing out all suggestions
	  List<WebElement> list = driver.findElements(By.xpath("//ul//child::li[@class='sbct']"));
	  for (int x = 0; x < list.size(); x++) {
		  
	       System.out.println("Suggested item "+ x + " " + list.get(x).getText());
	    }
	  search.sendKeys(Keys.ENTER);
	  capture(driver);
	  //go to flipcart site
	  driver.findElement(By.xpath("//cite[contains(text(),'flipkart.com')]")).click();
	  WebElement close = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	  capture(driver);
	  //click close if visible
	  if(close.isDisplayed()) {
		  close.click();
	  }
	  
	  //go to window acs by clicking on stepbystep
	  capture(driver);
	  driver.findElement(By.xpath("//div[contains(text(),'Appliances')]")).click();
	  capture(driver);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//span[contains(text(),'TVs & Appliances')]")).click();
	  capture(driver);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//a[@title='Window ACs']")).click();
	  capture(driver);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	  //click on add to compare checkbox
	  List<WebElement> checkbox = driver.findElements(By.xpath("//span[contains(text(),'Add to Compare')]"));
	  checkbox.get(2).click();
	  checkbox.get(3).click();
	  checkbox.get(6).click();
	  capture(driver);
	  
	  //click on compare button
	  driver.findElement(By.xpath("//span[contains(text(),'COMPARE')]")).click();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  capture(driver);
	  
	  //listing out name of all products
	  List<WebElement> nameOfProduct = driver.findElements(By.xpath("//div[@class='col col-3-12 _1Z-FPJ']//a[@class='_3L_M2k']"));
	  capture(driver);
	  for (int x = 0; x < nameOfProduct.size(); x++) {
		  
	       System.out.println("item name "+ x + " " + nameOfProduct.get(x).getText());
	  }
	  
	  //listing out price of all products
	  List<WebElement> priceOfProduct = driver.findElements(By.xpath("//div[@class='_2eCJrS']//div[@class='_30jeq3']"));
	  System.out.println("sizee----"+priceOfProduct.size());
	  
	  capture(driver);
	  for (int x = 0; x < priceOfProduct.size(); x++) {
		  
	       System.out.println("item price "+ x + " " + priceOfProduct.get(x).getText());
	  }

	  //clicking on add to cart one by one
	  String url = driver.getCurrentUrl();
	  for(int x = 0; x < 3 ; x++) {
		  
		  capture(driver);
		  List<WebElement> AddTOCart = driver.findElements(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww vsi37q']"));
		  AddTOCart.get(x).click();
		  driver.navigate().to(url);
		 
	  }
	  
	  //check for availability for pincode
	  capture(driver);
	  driver.findElement(By.xpath("//a[@class='_3SkBxJ']")).click();
	  WebElement pincode = driver.findElement(By.className("cfnctZ"));
	  capture(driver);
	  pincode.sendKeys("362730");
	  WebElement check = driver.findElement(By.xpath("//span[contains(text(),'Check')]"));
	  capture(driver);
	  check.click();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 
	  //listing out availability of products
	  List<WebElement> availability = driver.findElements(By.xpath("//div[@class='_1tBBEs' or @class='_2pqhhf']"));
	
	  for (int x = 0; x < availability.size(); x++) {
		  
	       System.out.println("item "+ x + " availabilty " + availability.get(x).getText());
	  }
	  driver.navigate().refresh();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  try {
		  driver.findElement(By.xpath("//div[@class='_3gc7Vf']")).click(); 
	  }catch(Exception e) {
		  System.out.println("Element is not there");
	  }
	  
	  //checking availability for different pincode
	  capture(driver);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  driver.findElement(By.className("cfnctZ")).sendKeys("395009");
	  driver.findElement(By.xpath("//span[contains(text(),'Check')]")).click();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 
	  capture(driver);
	  //listing out availability of product
	  List<WebElement> availability1 = driver.findElements(By.xpath("//div[@class='_1tBBEs' or @class='_2pqhhf']"));
	  for (int x = 0; x < availability1.size(); x++) {
		  
	       System.out.println("item "+ x + " availabilty " + availability1.get(x).getText());
	  }
	  driver.quit();
	  
  }
  
  public static String capture(WebDriver driver) throws IOException {
	  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  File Dest = new File("src/../Images/" + System.currentTimeMillis()
	  + ".png");
	  String errflpath = Dest.getAbsolutePath();
	  FileUtils.copyFile(scrFile, Dest);
	  return errflpath;
	  }
  
  @BeforeMethod
  public void beforeMethod() {
	
	  System.out.println("Session started");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Session ended");
  }
  


}
