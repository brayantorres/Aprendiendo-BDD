package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginStep {
	
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
	
	@Given("el usuario esta en la pagina de login")
    public void usuarioEstaEnLogin () {
    	driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
    }
    
    @When("el usuario ingresa credenciales validas")
    public void usuarioIngresaCredencialesValidas () {
    	driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testmail.com");
    	driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
    	
    	driver.findElement(By.id("MainContent_btnLogin")).click();
    }
    
    @Then("el usuario puede ver su panel de administracion")
    public void usuarioIngresaAlPanelDeAdministracion () {
    	String texto = driver.findElement(By.id("conf_message")).getText();
    	
    		assertTrue(texto.contains("Logged in successfully"));
    	}
    
    @When("^El usuario no se puede loguear con credeciales erroneas\"(.*)\"$")
    public void usuarioIngresaCredencialesErroneas () {
    	driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testmail.com");
    	driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass2356");
    	
    	driver.findElement(By.id("MainContent_btnLogin")).click();
    }
    
    @When("^el usuario ingresa usuario\"(.*)\"$")
    public void usuarioIngresaElNombre (String nombre) {
    	driver.findElement(By.id("MainContent_txtUserName")).sendKeys(nombre);
    }
    
    @And("^el usuario ingresa contraseña\"(.*)\"$")
    public void usuarioIngresaElPassword (CharSequence[] password) {
    	driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
    }
    
    @Then("El usuario no deberia ver su cuenta")
    public void usuarioNoDeberiaTenerAcceso () {
    	String texto = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
    	
		assertTrue(texto.contains("Invalid user name, try again!"));
    }
    

}
