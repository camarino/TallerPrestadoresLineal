import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ejercicios {

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated constructor stub

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");

		ChromeOptions options= new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);

		driver.get("https://tsegundaopinion.osde.com.ar/prestadores/signin");
		
		WebElement usuario = driver.findElement(By.name("user"));
		assertTrue(usuario.isDisplayed());
		usuario.click();
		usuario.sendKeys("cmarino@sms-latam.com");
		WebElement pass = driver.findElement(By.name("password"));
		assertTrue(pass.isDisplayed());
		pass.sendKeys("Smotest1!");
		WebElement btnIngresar = driver.findElement(By.id("prestadores-signin-btn-login"));
		assertTrue(btnIngresar.isDisplayed());
		btnIngresar.click();
		
		//caso2
		WebElement btnInterConsulta = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div/div/div[1]/div/div/div/button"));
		assertTrue(btnInterConsulta.isDisplayed());
		WebElement btnBienvenido = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[1]/a"));
		assertEquals(btnBienvenido.getText(), "Bienvenido, Usuario Test01");
		
		WebElement btnCambiarConstraseña = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a"));
		assertTrue(btnCambiarConstraseña.isDisplayed());
		
		WebElement btnSalir = driver.findElement(By.id("btSalir"));
		assertTrue(btnSalir.isDisplayed());
		
		//caso3
		
		btnInterConsulta.click();
		WebElement btnEnviarInv = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div[1]/button"));
		btnEnviarInv.click();
		WebElement formulario = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div[2]/div"));
		assertTrue(formulario.isDisplayed());
		WebElement cmpNumero = driver.findElement(By.name("valorIdentificacion"));
		cmpNumero.click();
		cmpNumero.sendKeys("34234242424");
		WebElement cmpApellido = driver.findElement(By.id("apellido"));
		cmpApellido.click();
		cmpApellido.sendKeys("marino");
		WebElement cmpNombre = driver.findElement(By.id("nombre"));
		cmpNombre.click();
		cmpNombre.sendKeys("Cinthya");
		WebElement cmpFechaNac = driver.findElement(By.id("fechaNacimiento"));
		cmpFechaNac.click();
		cmpFechaNac.sendKeys("11041991");
		WebElement cmpApellidoSol = driver.findElement(By.id("apellidoSolicitante"));
		cmpApellidoSol.click();
		cmpApellidoSol.sendKeys("Garcia");
		WebElement cmpNombreSol = driver.findElement(By.id("nombreSolicitante"));
		cmpNombreSol.click();
		cmpNombreSol.sendKeys("Pepe");
		WebElement tipoMatricula = driver.findElement(By.id("tipoMatricula"));
		
		Select sTipo = new Select(tipoMatricula);
		sTipo.selectByVisibleText("MP - Córdoba");
		
		WebElement numMatricula = driver.findElement(By.id("nroMatricula"));
		numMatricula.click();
		numMatricula.sendKeys("5675654535");
		WebElement email = driver.findElement(By.id("email"));
		email.click();
		email.sendKeys("cmarino@sms-latam.com");
		WebElement telefono  = driver.findElement(By.id("phone"));
		telefono.click();
		telefono.sendKeys("1143939932");
		WebElement Especialista = driver.findElement(By.id("especialidad"));
		Select sEspecialista = new Select(Especialista);
		sEspecialista.selectByVisibleText("Cirugía General");
		WebElement Profesional = driver.findElement(By.id("profesional"));
		Select sProfesional = new Select(Profesional);
		sProfesional.selectByVisibleText("Martin Carball");
		WebElement Motivo  = driver.findElement(By.name("detalle"));
		Motivo.click();
		Motivo.sendKeys("consulta para una cirugía");
		WebElement btnEnviar = driver.findElement(By.xpath("//*[@id='enviarInvitacionForm']/div/footer/div/div/div/div[2]/button"));
		btnEnviar.click();
		System.out.println("test ok");
		Thread.sleep(4000);
		driver.quit();	
		driver.close();
		
	}

}
