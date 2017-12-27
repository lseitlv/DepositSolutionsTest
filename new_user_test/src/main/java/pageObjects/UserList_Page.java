package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserList_Page {
	
private static WebElement element = null;
	
	public static WebElement lastLine_userName(WebDriver driver){
		 
	    element = driver.findElement(By.cssSelector("table#users tr:last-child td:nth-of-type(1)"));
	 
	    return element;
	    
	}

	public static WebElement lastLine_userEmail(WebDriver driver){
		 
	    element = driver.findElement(By.cssSelector("table#users tr:last-child td:nth-of-type(2)"));
	 
	    return element;
	    
	}

	public static WebElement lastLine_password(WebDriver driver){
		 
	    element = driver.findElement(By.cssSelector("table#users tr:last-child td:nth-of-type(3)"));
	 
	    return element;
	    
	}

}
