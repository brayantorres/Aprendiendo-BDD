package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.RegistroPage;

public class registroStep {
	
	WebDriver driver; 
	RegistroPage registropage;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    	driver = new ChromeDriver();
    	registropage = new RegistroPage(driver);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("el usuario esta en la pagina registro")
    public void usuarioEstaEnRegistro () {
    	driver.get("http://sdettraining.com/trguitransactions/NewAccount.aspx");
    }
	
	@When("el usuario ingresa su primer nombre \"(.*)\"$")
    public void usuarioIngresaSusDastos (String user) {
    	registropage.usuarioIngresaSuNombre(user); 	
    }
	
	@And("el usuario ingresa el email \"(.*)\"$")
	public void usuarioIngresaEmail(String email) {
		registropage.usuarioIngresaSuEmail(email);
	}
	
	@And("el usuario ingresa el telefono \"(.*)\"$")
	public void usarioIngresaTelefono(String telefono) {
		registropage.usuarioIngresaSuTelefono(telefono);
	}
	
	@And("el usuario da click en genero Male")
	public void usuarioDaClickEnMale() {
		registropage.usuarioDaClickEnSuGenero();
	}
	
	@And("el usuario ingresa password \"(.*)\"$")
	public void usuarioIngresaPassword(String password) {
		registropage.usuarioIngresaPassword(password);
	}
	
	@And("el usuario verifica su password \"(.*)\"$")
	public void usuarioVerificaPassword(String verifypassword) {
		registropage.usuarioVerificaSuPassword(verifypassword);
	}
	
	@And("el usuario selecciona el pais \"(.*)\"$")
	public void usuarioSeleccionaPais(String pais) {
		Select selectordrop = new Select(driver.findElement(By.id("MainContent_menuCountry")));
    	selectordrop.selectByValue(pais);
	}
	
	@And("el usuario elige suscripcion Weekly Email")
	public void usuarioSeSuscribeWeeklyEmail() {
		registropage.usuarioSeSuscribeWeeklyEmail();
	}
	
	@And("el usuario da click en submit")
	public void usuarioDaClickEnSubmit() {
		registropage.usuarioDaClickEnSubmit();
	}
	
	@Then("el usuario debe ser registrado")
    public void usuarioDebeEstarRegistrado () {
    	String texto = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
    	
		assertTrue(texto.contains("Customer information added succesfully"));
    }

}
