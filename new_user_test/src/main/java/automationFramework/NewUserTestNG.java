package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.Assert;

public class NewUserTestNG {
	
	public WebDriver driver;

  //TC1 - User creation - Successful
  @Test
  public void testCase1() {
	 
	 String userName = "Test Case1";
	 String userEmail = "testcase1@email.com";
	 String password = "TestPassword123";
	 
	 driver.findElement(By.id("name")).sendKeys(userName);
	 driver.findElement(By.id("email")).sendKeys(userEmail);
	 driver.findElement(By.id("password")).sendKeys(password);
	 driver.findElement(By.id("confirmationPassword")).sendKeys(password);
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	 //Checking that page title is displayed - i.e. page didn't crash
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).isDisplayed());

  }
  
  //TC2 - User creation - user name not unique
  @Test
  public void testCase2() {
	 
	 String userName = "Test Case1";
	 String userEmail = "testcase2@email.com";
	 String password = "TestPassword123!@#$%&";
	 
	 driver.findElement(By.id("name")).sendKeys(userName);
	 driver.findElement(By.id("email")).sendKeys(userEmail);
	 driver.findElement(By.id("password")).sendKeys(password);
	 driver.findElement(By.id("confirmationPassword")).sendKeys(password);
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	 //Checking that page title is displayed - i.e. page didn't crash
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).isDisplayed());

  }
  
  //TC3 - User creation - email not unique
  @Test
  public void testCase3() {
	 
	 String userName = "Test Case3";
	 String userEmail = "testcase1@email.com";
	 String password = "TestPassword123";
	 
	 driver.findElement(By.id("name")).sendKeys(userName);
	 driver.findElement(By.id("email")).sendKeys(userEmail);
	 driver.findElement(By.id("password")).sendKeys(password);
	 driver.findElement(By.id("confirmationPassword")).sendKeys(password);
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	 //Checking that page title is displayed - i.e. page didn't crash
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).isDisplayed());

  }
  
  //TC4 - User creation - Password confirmation not equal
  @Test
  public void testCase4() {
	 
	 String userName = "Test Case4";
	 String userEmail = "testcase4@email.com";
	 String password = "TestPassword123";
	 
	 driver.findElement(By.id("name")).sendKeys(userName);
	 driver.findElement(By.id("email")).sendKeys(userEmail);
	 driver.findElement(By.id("password")).sendKeys(password);
	 driver.findElement(By.id("confirmationPassword")).sendKeys("WrongPassword");
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	 //Checking that page title is displayed - i.e. page didn't crash
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).isDisplayed());

  }
  
  //TC5 - User creation - Long user name
  @Test
  public void testCase5() {
	 
	 String userName = "TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 "
	 		+ "TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 "
	 		+ "TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 "
	 		+ "TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 "
	 		+ "TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 "
	 		+ "TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 "
	 		+ "TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 "
	 		+ "TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 "
	 		+ "TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 "
	 		+ "TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 TestCase5 "
	 		+ "TestCase5 ";
	 String userEmail = "testcase5@email.com";
	 String password = "TestPassword123";
	 
	 driver.findElement(By.id("name")).sendKeys(userName);
	 driver.findElement(By.id("email")).sendKeys(userEmail);
	 driver.findElement(By.id("password")).sendKeys(password);
	 driver.findElement(By.id("confirmationPassword")).sendKeys(password);
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	 //Checking that page title is displayed - i.e. page didn't crash
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).isDisplayed());

  }
  
  //TC6 - User creation - Long email
  @Test
  public void testCase6() {
	 
	 String userName = "TestCase6";
	 String userEmail = "testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66"
	 		+ "testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66"
	 		+ "testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66"
	 		+ "testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66"
	 		+ "testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66"
	 		+ "testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66"
	 		+ "testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66"
	 		+ "testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66"
	 		+ "testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66"
	 		+ "testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66"
	 		+ "testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66testcase66"
	 		+ "testcase66testcase66@email.com";
	 String password = "TestPassword123";
	 
	 driver.findElement(By.id("name")).sendKeys(userName);
	 driver.findElement(By.id("email")).sendKeys(userEmail);
	 driver.findElement(By.id("password")).sendKeys(password);
	 driver.findElement(By.id("confirmationPassword")).sendKeys(password);
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	 //Checking that page title is displayed - i.e. page didn't crash
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).isDisplayed());

  }
  
  //TC7 - User creation - Long password
  @Test
  public void testCase7() {
	 
	 String userName = "Test Case7";
	 String userEmail = "testcase7@email.com";
	 String password = "TestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswd"
	 		+ "TestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswd"
	 		+ "TestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswd"
	 		+ "TestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswd"
	 		+ "TestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswd"
	 		+ "TestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswd"
	 		+ "TestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswd"
	 		+ "TestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswd"
	 		+ "TestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswd"
	 		+ "TestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswd"
	 		+ "TestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswdTestPasswd"
	 		+ "TestPasswdTestPasswd1";
	 
	 driver.findElement(By.id("name")).sendKeys(userName);
	 driver.findElement(By.id("email")).sendKeys(userEmail);
	 driver.findElement(By.id("password")).sendKeys(password);
	 driver.findElement(By.id("confirmationPassword")).sendKeys(password);
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	 //Checking that page title is displayed - i.e. page didn't crash
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).isDisplayed());

  }
  
  //TC8 - User creation - Empty username
  @Test
  public void testCase8() {
	 
	 String userEmail = "testcase8@email.com";
	 String password = "TestPassword123";
	 
	 driver.findElement(By.id("email")).sendKeys(userEmail);
	 driver.findElement(By.id("password")).sendKeys(password);
	 driver.findElement(By.id("confirmationPassword")).sendKeys(password);
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	 //Checking that page title is displayed - i.e. page didn't crash
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).isDisplayed());

  }
  
  //TC9 - User creation - Empty email
  @Test
  public void testCase9() {
	 
	 String userName = "Test Case9";
	 String password = "TestPassword123";
	 
	 driver.findElement(By.id("name")).sendKeys(userName);
	 driver.findElement(By.id("password")).sendKeys(password);
	 driver.findElement(By.id("confirmationPassword")).sendKeys(password);
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	 //Checking that page title is displayed - i.e. page didn't crash
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).isDisplayed());

  }
  
  //TC10 - User creation - Empty password
  @Test
  public void testCase10() {
	 
	 String userName = "Test Case10";
	 String userEmail = "testcase10@email.com";
	 
	 driver.findElement(By.id("name")).sendKeys(userName);
	 driver.findElement(By.id("email")).sendKeys(userEmail);
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	 //Checking that page title is displayed - i.e. page didn't crash
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).isDisplayed());

  }
  
  //TC11 - User creation - Empty password confirmation
  @Test
  public void testCase11() {
	 
	 String userName = "Test Case11";
	 String userEmail = "testcase11@email.com";
	 String password = "TestPassword123";
	 
	 driver.findElement(By.id("name")).sendKeys(userName);
	 driver.findElement(By.id("email")).sendKeys(userEmail);
	 driver.findElement(By.id("password")).sendKeys(password);
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	 //Checking that page title is displayed - i.e. page didn't crash
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).isDisplayed());

  }
  
//TC12 - User creation - Special characters on Name
  @Test
  public void testCase12() {
	 
	 String userName = "Test Case12!@#$%^&*()_+=~:";
	 String userEmail = "testcase12@email.com";
	 String password = "TestPassword123";
	 
	 driver.findElement(By.id("name")).sendKeys(userName);
	 driver.findElement(By.id("email")).sendKeys(userEmail);
	 driver.findElement(By.id("password")).sendKeys(password);
	 driver.findElement(By.id("confirmationPassword")).sendKeys(password);
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	 //Checking that page title is displayed - i.e. page didn't crash
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).isDisplayed());

  }
  
//TC13 - User creation - Invalid email format
  @Test
  public void testCase13() {
	 
	 String userName = "Test Case13";
	 String userEmail = "invalid email format";
	 String password = "TestPassword123";
	 
	 driver.findElement(By.id("name")).sendKeys(userName);
	 driver.findElement(By.id("email")).sendKeys(userEmail);
	 driver.findElement(By.id("password")).sendKeys(password);
	 driver.findElement(By.id("confirmationPassword")).sendKeys(password);
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	 //Checking that page title is displayed - i.e. page didn't crash
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/h1")).isDisplayed());

  }
 
  @BeforeMethod
  public void beforeMethod() {

	  driver.get("http://85.93.17.135:9000");
  }
 
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\edoslui\\Documents\\geckodriver-v0.19.1-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  // Adding implicit timeout time for locating elements before throwing exception
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  
	  //Closing the driver at the end of the execution
	  driver.quit();
  }

}