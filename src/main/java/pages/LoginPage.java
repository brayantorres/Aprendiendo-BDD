package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public void ingresaremailaddress(String username) {
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);;
	}
	
	public void ingresarpassword(String password) {
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	}
	
	public void clicklogin() {
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	public void clickcrearcuenta() {
		driver.findElement(By.linkText("Create Account")).click();
		//driver.findElement(By.xpath("//*[@id=\'ctl01\']/div[3]/div[2]/div/div[2]/a")).click();;
	}
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

}
