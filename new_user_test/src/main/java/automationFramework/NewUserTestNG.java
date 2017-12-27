package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import testObjects.User;
import resources.ServiceAPI;

public class NewUserTestNG {
	
	public WebDriver driver;
	
	//TC1 - User creation - Successful
	  @Test
	  public void testCase1() {
		  
		 User testUser = new User("Test Case1","testcase1@email.com","TestPassword123");
		 testUser.registerNewUser(driver);
		 testUser.verifyNewUser(driver);
	
	  }
	  
	  //TC2 - User creation - user name not unique
	  @Test
	  public void testCase2() {
		 
		 User testUser = new User("Test Case1","testcase2@email.com","TestPassword123");
		 testUser.registerNewUser(driver);
		 testUser.verifyNameNotUnique(driver);

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
	  
	//sending a DELETE request to the service API to get all users deleted.
	  try {
		  ServiceAPI.deleteAllUsers("http://85.93.17.135:9000/user/all");
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
  }

  @AfterClass
  public void afterClass() {
	  
	  //sending a DELETE request to the service API to get all users deleted.
	  try {
		  ServiceAPI.deleteAllUsers("http://85.93.17.135:9000/user/all");
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
		  
	  //Closing the driver at the end of the execution
	  driver.quit();
  }

}


/*
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
	 
	//Checking that 'Email must be unique' message is displayed
		 String expectedMessage = "Must be unique";
		 String errorMessage = driver.findElement(By.id("user.email.error")).getText();
		 Assert.assertEquals(errorMessage, expectedMessage);
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
	 
	//Checking that password error message is displayed
	 String expectedMessage = "passwords are not the same";
	 String errorMessage = driver.findElement(By.id("user.confirmationPassword.error")).getText();
	 Assert.assertEquals(errorMessage, expectedMessage);

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
	 
	//Checking that user name too long message is displayed
		 String expectedMessage = "Maximum size is 255";
		 String errorMessage = driver.findElement(By.id("user.name.error")).getText();
		 Assert.assertEquals(errorMessage, expectedMessage);

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
	 
	//Checking that email too long message is displayed
	 String expectedMessage = "Maximum size is 255";
	 String errorMessage = driver.findElement(By.id("user.email.error")).getText();
	 Assert.assertEquals(errorMessage, expectedMessage);

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
	 
	//Checking that password error message is displayed
		 String expectedMessage = "Maximum size is 255";
		 String errorMessage = driver.findElement(By.id("user.password.error")).getText();
		 Assert.assertEquals(errorMessage, expectedMessage);

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
	 
	//Checking that user name is required message is displayed
		 String expectedMessage = "Required";
		 String errorMessage = driver.findElement(By.id("user.name.error")).getText();
		 Assert.assertEquals(errorMessage, expectedMessage);

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
	 
	//Checking that user email required message is displayed
	 String expectedMessage = "Required";
	 String errorMessage = driver.findElement(By.id("user.email.error")).getText();
	 Assert.assertEquals(errorMessage, expectedMessage);

  }
  
  //TC10 - User creation - Empty password
  @Test
  public void testCase10() {
	 
	 String userName = "Test Case10";
	 String userEmail = "testcase10@email.com";
	 
	 driver.findElement(By.id("name")).sendKeys(userName);
	 driver.findElement(By.id("email")).sendKeys(userEmail);
	 driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button")).click();
	 
	//Checking that password is required message is displayed
	 String expectedMessage = "Required";
	 String errorMessage = driver.findElement(By.id("user.password.error")).getText();
	 Assert.assertEquals(errorMessage, expectedMessage);

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
	 
	//Checking that passwords are not equal message is displayed
		 String expectedMessage = "passwords are not the same";
		 String errorMessage = driver.findElement(By.id("user.confirmationPassword.error")).getText();
		 Assert.assertEquals(errorMessage, expectedMessage);

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
	 
	//Verifying that user information is displayed in the table
		 String tableName = driver.findElement(By.cssSelector("table#users tr:last-child td:nth-of-type(1)")).getText();
		 String tableEmail = driver.findElement(By.cssSelector("table#users tr:last-child td:nth-of-type(2)")).getText();
		 String tablePassword = driver.findElement(By.cssSelector("table#users tr:last-child td:nth-of-type(3)")).getText();
		 
		 Assert.assertEquals(tableName, userName);
		 Assert.assertEquals(tableEmail, userEmail);
		 Assert.assertEquals(tablePassword, password);

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
	 
	//Checking that user email required message is displayed
		 String expectedMessage = "Invalid email address";
		 String errorMessage = driver.findElement(By.id("user.email.error")).getText();
		 Assert.assertEquals(errorMessage, expectedMessage);

  }
  */