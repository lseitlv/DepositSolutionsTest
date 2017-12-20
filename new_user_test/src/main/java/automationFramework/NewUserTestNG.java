package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewUserTestNG {
	
	public WebDriver driver;
	
  @Test
  public void f() {
	  
	 String title =  driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).getText();
	 if (title.equals("New User")) {
		 System.out.println("Page loaded successfully.");
	 }
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\edoslui\\Documents\\geckodriver-v0.19.1-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  // Adding implicit timeout time for locating elements before throwing exception
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("http://85.93.17.135:9000");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  //Closing the driver at the end of the execution
	  driver.quit();
  }

}