package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewUser_Page {
	
	private static WebElement element = null;
	
	public static WebElement field_userName(WebDriver driver){
		 
	    element = driver.findElement(By.id("name"));
	 
	    return element;
	    
	}
	
	public static WebElement field_userEmail(WebDriver driver){
		 
	    element = driver.findElement(By.id("email"));
	 
	    return element;
	    
	}
	
	public static WebElement field_password(WebDriver driver){
		 
	    element = driver.findElement(By.id("password"));
	 
	    return element;
	    
	}
	
	public static WebElement field_confirmationPassword(WebDriver driver){
		 
	    element = driver.findElement(By.id("confirmationPassword"));
	 
	    return element;
	    
	}
	
	public static WebElement button_submit(WebDriver driver){
		 
	    element = driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div[5]/button"));
	 
	    return element;
	    
	}
	
	public static WebElement msg_nameError(WebDriver driver){
		 
	    element = driver.findElement(By.id("user.name.error"));
	 
	    return element;
	    
	}
	

}
