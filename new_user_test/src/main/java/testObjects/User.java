package testObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.NewUser_Page;
import pageObjects.UserList_Page;

public class User {
	
	private String userName;
	private String userEmail;
	private String userPassword;
	
	public User(String name, String email, String password) {
        userName = name;
        userEmail = email;
        userPassword = password;
    }
	
	public void registerNewUser(WebDriver driver) {
		
		NewUser_Page.field_userName(driver).sendKeys(userName);
		NewUser_Page.field_userEmail(driver).sendKeys(userEmail);
		NewUser_Page.field_password(driver).sendKeys(userPassword);
		NewUser_Page.field_confirmationPassword(driver).sendKeys(userPassword);
		NewUser_Page.button_submit(driver).click();
		
	}
	
	public void verifyNewUser(WebDriver driver) {
		
		Assert.assertEquals(UserList_Page.lastLine_userName(driver).getText(),userName);
		Assert.assertEquals(UserList_Page.lastLine_userEmail(driver).getText(),userEmail);
		Assert.assertEquals(UserList_Page.lastLine_password(driver).getText(),userPassword);
		
	}
	
public void verifyNameNotUnique(WebDriver driver) {
		
		Assert.assertEquals(NewUser_Page.msg_nameError(driver).getText(),"Must be unique");
			
	}

}
