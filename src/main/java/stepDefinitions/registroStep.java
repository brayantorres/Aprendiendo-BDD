package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class registroStep {
	
	WebDriver driver; 
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    	driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("El usuario esta en la pagina registro")
    public void usuarioEstaEnRegistro () {
    	driver.get("http://sdettraining.com/trguitransactions/NewAccount.aspx");
    }
	
	@When("El usuario ingresa sus datos")
    public void usuarioIngresaSusDastos () {
    	driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("Brayan David Torres Suarez");
    	driver.findElement(By.id("MainContent_txtEmail")).sendKeys("brayantorres@unac.edu.co");
    	driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys("3012363749");
    	driver.findElement(By.id("MainContent_Male")).click();
    	driver.findElement(By.id("MainContent_txtPassword")).sendKeys("asd$123");
    	driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("asd$123");
    	
    	Select selectordrop = new Select(driver.findElement(By.id("MainContent_menuCountry")));
    	selectordrop.selectByValue("Ecuador");
    	
    	driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
    	
    	driver.findElement(By.id("MainContent_btnSubmit")).click();
    }
	
	@Then("el usuario debe ser registrado")
    public void usuarioDebeEstarRegistrado () {
    	String texto = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
    	
		assertTrue(texto.contains("Customer information added succesfully"));
    }

}
