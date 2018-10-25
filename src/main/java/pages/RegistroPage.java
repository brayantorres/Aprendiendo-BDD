package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistroPage {
	
	WebDriver driver;
	
	public void usuarioIngresaSuNombre(String user) {
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys(user);  
	}
	
	public void usuarioIngresaSuEmail(String email) {
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys(email);
	}
	
	public void usuarioIngresaSuTelefono(String telefono) {
		driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys(telefono);
	}
	
	public void usuarioDaClickEnSuGenero() {
		driver.findElement(By.id("MainContent_Male")).click();
	}
	
	public void usuarioIngresaPassword(String password) {
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	}
	
	public void usuarioVerificaSuPassword(String verifypassword) {
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(verifypassword);
	}
	
	public void usuarioSeSuscribeWeeklyEmail() {
		driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
	}
	
	public void usuarioDaClickEnSubmit() {
		driver.findElement(By.id("MainContent_btnSubmit")).click();
	}
	
	//Constructor
		public RegistroPage(WebDriver driver2) {
		this.driver = driver2;
	}
}
